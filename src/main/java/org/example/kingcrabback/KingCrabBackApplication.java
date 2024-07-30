package org.example.kingcrabback;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@ConfigurationPropertiesScan
@SpringBootApplication
public class KingCrabBackApplication {

    public static void main(String[] args) {
        SpringApplication.run(KingCrabBackApplication.class, args);
    }

}
