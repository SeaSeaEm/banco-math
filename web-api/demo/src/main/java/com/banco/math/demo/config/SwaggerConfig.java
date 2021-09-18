package com.banco.math.demo.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo()).useDefaultResponseMessages(false);
    }

    private ApiInfo apiInfo() {
        ApiInfo apiInfo = new ApiInfo("Banco Math API", "API for managing an accout (just like a bank maybe).", "1A", "N/A",
                new Contact("Caio Cesar", "https://github.com/SeaSeaEm", "caioc.mota@gmail.com"), "MIT License",
                "https://github.com/SeaSeaEm/banco-math/blob/main/LICENSE", Collections.emptyList());
        return apiInfo;
    }
}