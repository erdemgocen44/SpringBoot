package com.example.userservice;

import com.example.userservice.domain.Role;
import com.example.userservice.domain.User;
import com.example.userservice.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class UserserviceApplication {

    public static void main(String[] args) {

        SpringApplication.run(UserserviceApplication.class, args);
    }
    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    CommandLineRunner run(UserService userService) {
        return args -> {
            userService.saveRole(new Role(null, "ROLE_USER"));
            userService.saveRole(new Role(null, "ROLE_MANAGER"));
            userService.saveRole(new Role(null, "ROLE_ADMIN"));
            userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

            userService.saveUser(new User(null, "Elif Yazici", "Cadi","NAbersin1234", new ArrayList<>()));
            userService.saveUser(new User(null, "Gülcan Kisakol", "MamavonCadi","Haloha1234", new ArrayList<>()));
            userService.saveUser(new User(null, "Batu Kisakol", "Bro","Laeblebi1234", new ArrayList<>()));
            userService.saveUser(new User(null, "Bige Kisakol", "Aristico","1234", new ArrayList<>()));

            userService.addRoleToUser("Cadi", "ROLE_USER");
            userService.addRoleToUser("MamavonCadi", "ROLE_MANAGER");
            userService.addRoleToUser("Bro", "ROLE_MANAGER");
            userService.addRoleToUser("Artistico", "ROLE_ADMIN");

        };
    }

}