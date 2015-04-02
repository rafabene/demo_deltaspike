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
 * I should have a producer for each qualifier value as in this class
 * 
 * In this case, an CDI extension should do a better job
 * 
 * @author rafaelbenevides
 *
 */
@ApplicationScoped
public class PropertyProducer
{

    @Inject
    @InjectableResource(location = "/myproperties.properties")
    private InputStream is;

    private Properties propertiesFile = new Properties();

    @PostConstruct
    public void setup()
    {
        try
        {
            propertiesFile.load(is);
        }
        catch (IOException e)
        {
            throw new IllegalStateException(e);
        }
    }

//    @Produces
//    @Property("key1")
//    public String propriedade1Producer()
//    {
//        return propertiesFile.getProperty("key1");
//    }
//
//    @Produces
//    @Property("key2")
//    public String propriedade2Producer()
//    {
//        return propertiesFile.getProperty("key2");
//    }
}
