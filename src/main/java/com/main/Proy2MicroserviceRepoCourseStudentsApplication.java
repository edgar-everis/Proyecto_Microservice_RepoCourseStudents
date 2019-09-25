package com.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;



@EnableEurekaClient
@SpringBootApplication
public class Proy2MicroserviceRepoCourseStudentsApplication {

    public static void main(String[] args) {
        SpringApplication.run(Proy2MicroserviceRepoCourseStudentsApplication.class, args);
    }

}
