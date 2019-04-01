package com.turchanovskyi.mediasphere;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class MediasphereApplication {

    public static void main(String[] args) {
        SpringApplication.run(MediasphereApplication.class, args);
    }

}
