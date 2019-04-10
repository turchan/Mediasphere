package com.turchanovskyi.mediasphere;

import com.turchanovskyi.mediasphere.securityConfig.AppProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(AppProperties.class)
public class MediasphereApplication {

    public static void main(String[] args) {
        SpringApplication.run(MediasphereApplication.class, args);
    }

}
