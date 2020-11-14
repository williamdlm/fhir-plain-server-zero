package com.evangelista.leonardo.fhirplainserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@SpringBootApplication
public class FhirplainserverApplication {

	@Autowired
	ApplicationContext context;

	public static void main(String[] args) {
		SpringApplication.run(FhirplainserverApplication.class, args);
	}

	@Bean
	public ServletRegistrationBean ServletRegistrationBean() {
		ServletRegistrationBean registration = new ServletRegistrationBean(new FhirRestfulServer(context), "/*");
		registration.setName("FhirServlet");
		return registration;
	}

	@Bean
	CorsConfigurationSource
	corsConfigurationSource() {
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
		return source;
	}

}
