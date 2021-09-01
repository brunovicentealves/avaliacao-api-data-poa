package avaliacao.forttiori.config;

import java.util.ArrayList;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket greetingApi() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.basePackage("avaliacao.forttiori")).build()
						.apiInfo(metaInfo());

	}

	private ApiInfo metaInfo() {

		ApiInfo apiInfo = new ApiInfo("Transporte  API REST", "API REST  com integração com Api Data Poa", "1.0", "Terms of Service",
						new Contact("Bruno Vicente Alves", "https://github.com/brunovicentealves", "brunovicentealves.ti@gmail.com"),
						"Apache License Version 2.0", "https://www.apache.org/licesen.html", new ArrayList<VendorExtension>());

		return apiInfo;
	}

}
