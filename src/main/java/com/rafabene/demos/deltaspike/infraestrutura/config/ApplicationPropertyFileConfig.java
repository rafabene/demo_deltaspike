package com.rafabene.demos.deltaspike.infraestrutura.config;

import org.apache.deltaspike.core.api.config.PropertyFileConfig;


public class ApplicationPropertyFileConfig implements PropertyFileConfig {

    private static final long serialVersionUID = 1L;

    @Override
    public String getPropertyFileName() {
        return "config.properties";
    }

}
