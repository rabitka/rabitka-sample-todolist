/*
 *
 * Copyright (c) 2017 Rabitka Framework
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package io.rabitka.sample.todolist.springconf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                    .apis(RequestHandlerSelectors.basePackage("io.rabitka.sample.todolist.rest"))
                //.paths(regex("/product.*"))
                    .build();

    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
            .title("Todo List API")
            .description("Rabitka Sample Todo List")
            .contact("wassim.abid@rabitka.io")
            .termsOfServiceUrl("https://github.com/rabitka/rabitka-framework")
            .license("MIT License")
            .licenseUrl("https://github.com/rabitka/rabitka-framework/blob/master/LICENSE")
            .version("1.0")
            .build();
    }
}