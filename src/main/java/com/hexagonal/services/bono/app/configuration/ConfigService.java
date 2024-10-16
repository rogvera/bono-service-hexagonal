package com.hexagonal.services.bono.app.configuration;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Configuration
@Getter
@RequiredArgsConstructor
public class ConfigService {
    private final Environment environment;

    // Cargar configuraciones desde application.properties
    @Value("${spring.application.name:bonoService}")
    private String nombreAplicacion;

    @Value("${server.port:8080}")
    private String puertoServidor;

    @Value("${spring.datasource.url}")
    private String databaseUrl;

    @Value("${spring.datasource.username}")
    private String databaseUsername;

    @Value("${spring.h2.console.enabled:true}")
    private boolean h2ConsoleEnabled;

    // Obtener cualquier propiedad dinámica usando Environment
    public String getProperty(String key) {
        return environment.getProperty(key);
    }

}
