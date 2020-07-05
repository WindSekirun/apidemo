package com.github.windsekirun.apidemo.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2

@Configuration
@EnableSwagger2
class Swagger2Config {

    @Bean
    fun api() = Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(RequestHandlerSelectors.basePackage("com.github.windsekirun.apidemo.controller"))
            .paths(PathSelectors.regex("/.*"))
            .build()
            .apiInfo(apiInfo())

    private fun apiInfo() = ApiInfoBuilder().apply {
        title("ApiDemo Docs")
        description("API Endpoint for getting server time")
    }.build()
}