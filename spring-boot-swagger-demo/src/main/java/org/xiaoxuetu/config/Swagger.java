package org.xiaoxuetu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger {

    private static final String CONTACT_NAME = "Kevin";

    private static final String CONTACT_URL = "https://github.com/xiaoxuetu";

    private static final String CONTACT_MAIL = "hjj20040849@qq.com";

    private static final String API_BASE_PACKAGE = "org.xiaoxuetu.controller";

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
            .apiInfo(apiInfo())
            .select()
            .apis(RequestHandlerSelectors.basePackage(API_BASE_PACKAGE))
            .paths(PathSelectors.any())
            .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
            .title("Title: Swagger Demo")
            .description("Description: Demo for Spring boot Swagger")
            .contact(new Contact(CONTACT_NAME, CONTACT_URL, CONTACT_MAIL))
            .version("1.0")
            .build();
    }
}
