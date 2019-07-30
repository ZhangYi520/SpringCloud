package com.zy.zy_sso.base.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
 
/**
 * 
 **************************************************
 * @Description:项目描述
 * @author:zy
 * @date:2017年10月23日
 **************************************************
 */
@Configuration
//@EnableSwagger2
public class Swagger2 {
 
	@Bean
	public Docket createRestApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.zy.zy_sso"))
				.paths(PathSelectors.any())
				.build();
	}
	
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("zy")
				.description("单点登录")
				.termsOfServiceUrl("链接地址")
				.version("V1.0.0")
				.build();
	}
}