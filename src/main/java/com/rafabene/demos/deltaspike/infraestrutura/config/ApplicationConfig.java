package com.rafabene.demos.deltaspike.infraestrutura.config;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.deltaspike.core.api.config.ConfigResolver;
import org.apache.deltaspike.core.api.projectstage.ProjectStage;
import org.apache.deltaspike.core.api.resourceloader.InjectableResource;

@Named
public class ApplicationConfig {

    @Inject
    private ProjectStage projectStage;

    @Inject
    @InjectableResource(location = "/version.txt")
    private InputStream is;

    // Demonstra como retornar o Project Stage Atual
    public ProjectStage getProjectStage() {
        return projectStage;
    }

    // Demonstra que pode ser injetar InputStream de recursos
    public String getVersion() throws IOException {
        try (BufferedReader br =
            new BufferedReader(new InputStreamReader(is))) {
            return br.readLine();
        }
    }

    // Demonstra como ler configurações de maneira fácil e de acordo com o ProjectStage
    public String getFilaJMS() {
        return ConfigResolver.getProjectStageAwarePropertyValue("jms.queue");
    }
}
