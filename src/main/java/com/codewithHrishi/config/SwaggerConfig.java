/*
 * package com.codewithHrishi.config;
 * 
 * import java.util.Arrays;
 * 
 * import org.springframework.context.annotation.Bean;
 * 
 * import io.swagger.v3.oas.models.PathItem.HttpMethod; import
 * io.swagger.v3.oas.models.info.Contact; import
 * springfox.documentation.builders.PathSelectors; import
 * springfox.documentation.builders.RequestHandlerSelectors; import
 * springfox.documentation.builders.ResponseBuilder; import
 * springfox.documentation.schema.Collections; import
 * springfox.documentation.service.ApiInfo; import
 * springfox.documentation.spi.DocumentationType; import
 * springfox.documentation.spring.web.plugins.Docket;
 * 
 * public class SwaggerConfig {
 * 
 * @Bean public Docket docket() { return new Docket(DocumentationType.SWAGGER_2)
 * .useDefaultResponseMessages(false) .globalResponses(HttpMethod.GET,
 * Arrays.asList( new ResponseBuilder().code("500")
 * .description("500 message").build(), new ResponseBuilder().code("403")
 * .description("You Don't Allowd!!").build())) .apiInfo(getApiInfo())
 * .securityContexts(securityContexts())
 * .securitySchemes(Arrays.asList(apiKeys())) .select()
 * .apis(RequestHandlerSelectors.any()) .paths(PathSelectors.any()) .build(); }
 * 
 *//**
	 * @return
	 *//*
		 * private ApiInfo getApiInfo() { return new ApiInfo( "RDMS : Java API's",
		 * "Release & Deployment Management System", "Version 1.0", "Terms of Service",
		 * new Contact("ONKAR", "rdms-react", "o.chavan@rnt.ai"), "License of API's",
		 * "API's license URL", Collections.emptyList()); } }
		 */