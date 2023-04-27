package com.mv.course.fhirplainserver;

import com.mv.course.fhirplainserver.config.PlainRestfulServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.elasticsearch.ElasticsearchRestClientAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

@ServletComponentScan(basePackageClasses = {
        PlainRestfulServer.class})
@SpringBootApplication(exclude = {ElasticsearchRestClientAutoConfiguration.class})
public class FhirPlainServerApplication extends SpringBootServletInitializer {

    @Autowired
    AutowireCapableBeanFactory beanFactory;

    public static void main(String[] args) {
        System.setProperty("spring.batch.job.enabled", "false");
        SpringApplication.run(FhirPlainServerApplication.class, args);

        //Server is now accessible at eg. http://localhost:8080/fhir/metadata
        //UI is now accessible at http://localhost:8080/
    }

    @Override
    protected SpringApplicationBuilder configure(
            SpringApplicationBuilder builder) {
        return builder.sources(FhirPlainServerApplication.class);
    }

    @Bean
    public ServletRegistrationBean<PlainRestfulServer> hapiServletRegistration() {
        ServletRegistrationBean<PlainRestfulServer> servletRegistrationBean = new ServletRegistrationBean<>();
        PlainRestfulServer plainRestfulServer = new PlainRestfulServer();
        beanFactory.autowireBean(plainRestfulServer);
        servletRegistrationBean.setServlet(plainRestfulServer);
        servletRegistrationBean.addUrlMappings("/fhir/*");
        servletRegistrationBean.setLoadOnStartup(1);
        return servletRegistrationBean;
    }

}
