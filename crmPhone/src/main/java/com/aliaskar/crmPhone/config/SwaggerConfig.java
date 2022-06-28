package com.aliaskar.crmPhone.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Admin on 23.05.2022
 */
@Configuration
public class SwaggerConfig {

        @Bean
    public OpenAPI srm() {
        return new OpenAPI()
                .info(
                        new Info()
                                .title("CRM application for frontend")
                                .version("1.0.0")
                                .contact(
                                        new Contact()
                                                .name("Aliaskar")
                                )
                );

    }

}
