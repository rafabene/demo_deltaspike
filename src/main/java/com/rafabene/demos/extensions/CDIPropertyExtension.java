package com.rafabene.demos.extensions;

import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import javax.enterprise.context.Dependent;
import javax.enterprise.context.spi.CreationalContext;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.spi.AfterBeanDiscovery;
import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeforeBeanDiscovery;
import javax.enterprise.inject.spi.Extension;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.enterprise.inject.spi.ProcessAnnotatedType;
import javax.enterprise.inject.spi.ProcessInjectionTarget;

import org.jboss.logging.Logger;

public class CDIPropertyExtension implements Extension {

    private Logger logger = Logger.getLogger(getClass());

    private final List<String> properties = new LinkedList<String>();

    public void beforeBeanDiscovery(@Observes BeforeBeanDiscovery bbd) {
        logger.info("Comecei o processo de scanning dos Beans");
    }

    public <T> void processAnnotatedType(@Observes ProcessAnnotatedType<T> pat) {
        // Só imprime o scan de classes do pacote org.tdc...
        if (pat.getAnnotatedType().getJavaClass().getPackage().getName().startsWith("com.rafabene")) {
            logger.info("Scanning Classe do pacote com.rafabene " + pat.getAnnotatedType().getJavaClass().getName());
        }

    }

    public void processInjectionTarget(@Observes ProcessInjectionTarget<?> pit) {
        for (InjectionPoint ip : pit.getInjectionTarget().getInjectionPoints()) {
            Propriedade property = ip.getAnnotated().getAnnotation(Propriedade.class);
            if (property != null) {
                properties.add(property.value());
            }
        }
    }

    public void afterBeanDiscovery(@Observes AfterBeanDiscovery abd) {
        logger.info("Fim do processo de scanning dos Beans. Agora vou adicionar os Beans para serem injetados");
        final Properties propertiesFile = new Properties();
        try {
            try (InputStream is = this.getClass().getResourceAsStream("/meuproperties.properties")) {
                propertiesFile.load(is);
            }
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
        // Criar um Bean com seu respectivo qualifier para cada injection point
        for (final String s : properties) {
            abd.addBean(new Bean<String>() {

                @Override
                public String create(CreationalContext<String> creationalContext) {
                    // retorna nulo se não existe a propriedade
                    // Poderia lançar uma exception;
                    return propertiesFile.getProperty(s);
                }

                @Override
                public void destroy(String s, CreationalContext<String> creationalContext) {
                    creationalContext.release();
                }

                @Override
                public String getName() {
                    return "propriedade" + s;
                }

                @Override
                public Set<Annotation> getQualifiers() {
                    Set<Annotation> qualifiers = new HashSet<Annotation>();
                    qualifiers.add(new PropriedadeLiteral(s));
                    return qualifiers;
                }

                @Override
                public Class<? extends Annotation> getScope() {
                    return Dependent.class;
                }

                @Override
                public Set<Class<? extends Annotation>> getStereotypes() {
                    return Collections.emptySet();
                }

                @Override
                public Set<Type> getTypes() {
                    Set<Type> types = new HashSet<Type>();
                    types.add(Object.class);
                    types.add(String.class);
                    return types;
                }

                @Override
                public boolean isAlternative() {
                    return false;
                }

                @Override
                public Class<?> getBeanClass() {
                    return String.class;
                }

                @Override
                public Set<InjectionPoint> getInjectionPoints() {
                    return Collections.emptySet();
                }

                @Override
                public boolean isNullable() {
                    return false;
                }
            });
        }
    }
}
