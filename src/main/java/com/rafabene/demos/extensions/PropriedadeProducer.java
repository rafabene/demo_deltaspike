package com.rafabene.demos.extensions;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;

import org.apache.deltaspike.core.api.resourceloader.InjectableResource;

/**
 * Eu teria que ter um producer com qualifier para cada valor como nesta classe.
 * 
 * Neste caso uma extension faz melhor o trabalho.
 * 
 * @author rafaelbenevides
 *
 */
@ApplicationScoped
public class PropriedadeProducer {

    @Inject
    @InjectableResource(location = "/meuproperties.properties")
    private InputStream is;

    private Properties propertiesFile = new Properties();

    @PostConstruct
    public void setup() {
        try {
            propertiesFile.load(is);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

//    @Produces
//    @Propriedade("key1")
//    public String propriedade1Producer() {
//        return propertiesFile.getProperty("key1");
//    }
//
//    @Produces
//    @Propriedade("key2")
//    public String propriedade2Producer() {
//        return propertiesFile.getProperty("key2");
//    }
}
