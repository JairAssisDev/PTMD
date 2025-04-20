package br.edu.ifpe.ptmd.config.docs;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocOpenApiConfig {
    @Bean
    public OpenAPI openAPI(){
        return new OpenAPI()
                .info(new Info()
                        .title("REST API - PTMD")
                        .description("API de Prediction of Tympanic Membrane Diseases")
                        .contact(new Contact().name("JairVictor").email("jvla2@discente.ifpe.edu.br"))
                        .version("1.0"));
    }
}
