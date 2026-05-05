package br.com.bebuns.dos.cervejaria.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Beer Guide API",
                version = "1.0",
                description = "API para Guia de Cervejas Artesanais, desenvolvida para os apreciadores e bebuns."
        )
)
public class SwaggerConfig {
}
