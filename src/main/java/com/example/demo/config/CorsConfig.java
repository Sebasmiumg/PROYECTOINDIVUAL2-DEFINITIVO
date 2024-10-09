package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/api/**") // Aplica la configuración a las rutas que comienzan con /api/
                        .allowedOrigins("http://localhost:5173") // Permitir solicitudes solo desde tu frontend (Vite)
                        .allowedMethods("GET", "POST", "PUT", "DELETE") // Permitir estos métodos HTTP
                        .allowedHeaders("*") // Permitir todos los headers en la solicitud
                        .allowCredentials(true); // Permitir el envío de cookies o credenciales si es necesario
            }
        };
    }
}

