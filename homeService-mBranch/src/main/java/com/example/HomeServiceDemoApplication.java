package com.example;

import com.example.data.entity.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HomeServiceDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(HomeServiceDemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner run() {
        return (String[] args) -> {
            User user1 = new User();
            user1.setEmail("m.a@gmail.com");
            user1.setName("m");
            User user2 = new User();
            user2.setEmail("h.a@gmail.com");
            user1.setName("h");
            System.out.println(user1);
            System.out.println(user2);
        };
    }
}
