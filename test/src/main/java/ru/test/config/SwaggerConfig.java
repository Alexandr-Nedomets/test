package ru.test.config;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

import static springfox.documentation.builders.PathSelectors.*;

@Configuration
@EnableSwagger2
@Import(BeanValidatorPluginsConfiguration.class)
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("Base API")
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(any())
                .paths(Predicates.not(PathSelectors.regex("/error.*")))
                .build()
                .apiInfo(apiInfo())
                .useDefaultResponseMessages(false)
                .tags(new Tag("user-controller", "CRUD API для взаимодествия с Пользователям"));
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Test API",
                "API for work app",
                "1.0.O",
                "",
                new Contact("Admin", "ru.test", "admin@ya.ru"),
                "Test License",
                "https://opensource.org/",
                Collections.emptyList());
    }

}
