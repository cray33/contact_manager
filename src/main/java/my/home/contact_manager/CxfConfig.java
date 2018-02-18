package my.home.contact_manager;

import java.util.Arrays;

import my.home.contact_manager.controller.ContactRestController;
import org.apache.cxf.Bus;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxrs.swagger.Swagger2Feature;
import org.codehaus.jackson.jaxrs.JacksonJsonProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class CxfConfig {
    @Autowired
    private Bus bus;

    @Autowired
    private ContactRestController contactRestController;

    @Bean
    public Server rsServer() {
        JacksonJsonProvider jsonProvider = new JacksonJsonProvider();

        JAXRSServerFactoryBean endpoint = new JAXRSServerFactoryBean();
        endpoint.setBus(bus);
        endpoint.setProviders(Arrays.asList(jsonProvider));
        endpoint.setServiceBeans(Arrays.<Object>asList(contactRestController));
        endpoint.setAddress("/");
        endpoint.setFeatures(Arrays.asList(createSwaggerFeature()));

        return endpoint.create();
    }


    public Swagger2Feature createSwaggerFeature() {
        Swagger2Feature swagger2Feature = new Swagger2Feature();
        swagger2Feature.setPrettyPrint(true);
        swagger2Feature.setBasePath("/rest");
        swagger2Feature.setTitle("Spring Boot CXF REST Application");
        swagger2Feature.setContact("The Apache CXF team");
        swagger2Feature.setDescription("This sample project demonstrates how to use CXF JAX-RS services"
                + " with Spring Boot. This demo has two JAX-RS class resources being"
                + " deployed in a single JAX-RS endpoint.");
        swagger2Feature.setVersion("1.0.0");
        return swagger2Feature;
    }



}