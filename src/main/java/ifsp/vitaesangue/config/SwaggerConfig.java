package ifsp.vitaesangue.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        final String securitySchemeName = "bearerAuth";
        
        return new OpenAPI()
            .addSecurityItem(new SecurityRequirement().addList(securitySchemeName)) // Adiciona o esquema como requisito de segurança
            .components(new io.swagger.v3.oas.models.Components()
                .addSecuritySchemes(securitySchemeName, // Define o esquema de segurança
                    new SecurityScheme()
                        .type(SecurityScheme.Type.HTTP)
                        .scheme("bearer")
                        .bearerFormat("JWT") // Opcional: para tokens JWT
                        .name("Authorization") // Nome do cabeçalho HTTP usado
                        .in(SecurityScheme.In.HEADER))) // Indica que o token será enviado no cabeçalho HTTP
            .info(new io.swagger.v3.oas.models.info.Info()
                .title("VitaeSangeue API")
                .version("1.0"));
    }
}