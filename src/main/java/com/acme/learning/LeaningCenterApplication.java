package com.acme.learning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
public class LeaningCenterApplication {
    @EnableJpaAuditing
    @SpringBootApplication
    public class LearningCenterApplication {

        public static void main(String[] args) {
            SpringApplication.run(LearningCenterApplication.class, args);
        }
    }
}
