package com.nagp.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.annotation.PostConstruct;

@SpringBootApplication
@EnableSwagger2
public class NagpProductServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(NagpProductServicesApplication.class, args);
	}

	@Bean
	@PostConstruct
	public Docket productAPI() {
		return new Docket(DocumentationType.SWAGGER_2)
				.enable(true)
				.apiInfo(new ApiInfoBuilder()
						.title("Swagger")
						.description("Product microservice API details")
						.version("1.0").build())
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.nagp.product"))
				.paths(PathSelectors.any()).build();
	}
}
