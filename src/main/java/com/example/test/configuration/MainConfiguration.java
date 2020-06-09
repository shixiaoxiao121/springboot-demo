package com.example.test.configuration;

import com.example.test.interceptor.AuthInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.annotation.Resource;

/**
 * describe:
 *
 * @author sc
 * @date 2020/06/05
 */
@Configuration
@EnableSwagger2
public class MainConfiguration extends WebMvcConfigurationSupport {

	@Resource
	AuthInterceptor authInterceptor;

	@Value("${swagger.enabled}")
	private  boolean enabled;

	@Override
	protected void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(authInterceptor).addPathPatterns("/**")
				.excludePathPatterns("/swagger");
		super.addInterceptors(registry);
	}

	@Override
	protected void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("swagger-ui.html")
				.addResourceLocations("classpath:/META-INF/resources/");
		registry.addResourceHandler("/webjars/**")
				.addResourceLocations("classpath:/META-INF/resources/webjars/");
		super.addResourceHandlers(registry);
	}

	@Bean
	public Docket createRestApi(){
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.enable(enabled).select()
				.apis(RequestHandlerSelectors.basePackage("com.example.test.controller"))
				.paths(PathSelectors.any()).build();
	}

	public ApiInfo apiInfo(){
		return new ApiInfoBuilder().title("接口文档").description("服务端通用接口").version("1.0").build();
	}

}
