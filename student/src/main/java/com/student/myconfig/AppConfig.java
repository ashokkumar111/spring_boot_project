package com.student.myconfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {
   /* @Bean
    @Scope("prototype") // Prototype scope defined here
    public MyPrototypeBeen prototypeBeen(){
        return new MyPrototypeBeen();
    }*/
    @Bean
    public RestTemplate restTemplate(){
        RestTemplate restTemplate=new RestTemplate();
        return restTemplate;
    }
}
