package com.springbootsoap;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class WSConfigClient {

    @Bean
    public Jaxb2Marshaller marshaller(){
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("allapis.springbootsoap.com");
        return marshaller;
    }

    @Bean
    public ProductClient productClient(Jaxb2Marshaller marshaller){
        ProductClient client = new ProductClient();
        client.setDefaultUri("http://localhost:8080/allService/products.wsdl");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }
}
