package co.com.javeriana.cofig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;



@Configuration
@EnableSwagger2
public class SwaggerDocConfig implements WebMvcConfigurer{

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {

		registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");

		registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
	}
	
	@Bean
	public Docket documentation() {
		return new Docket(DocumentationType.SWAGGER_2)
				.useDefaultResponseMessages(false)
				.select()
				.apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
				.build()
				.apiInfo(metaData());
	}

	private ApiInfo metaData() {
		return new ApiInfoBuilder()
				.title("Clients-Unitysoft-ms")
				.description("\"Microservicio de exposición para gestion de usuarios\"")
				.version("1.0.0")
				.build();
	}

}

