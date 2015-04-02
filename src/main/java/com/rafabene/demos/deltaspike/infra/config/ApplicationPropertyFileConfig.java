package com.rafabene.demos.deltaspike.infra.config;

import org.apache.deltaspike.core.api.config.PropertyFileConfig;


public class ApplicationPropertyFileConfig implements PropertyFileConfig {

    private static final long serialVersionUID = 1L;

    @Override
    public String getPropertyFileName() {
        return "config.properties";
    }

    @Override
    public boolean isOptional()
    {
        return false;
    }

}
