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

          userService.saveUser(new User(null, "Erol Buyukburc", "Saksi","1234", new ArrayList<>()));
          userService.saveUser(new User(null, "Erol Kucukburc", "kSaksi","1234", new ArrayList<>()));
          userService.saveUser(new User(null, "Erol Ortancaburc", "oSaksi","1234", new ArrayList<>()));
          userService.saveUser(new User(null, "Erol Cokbuyukburc", "cbSaksi","1234", new ArrayList<>()));

          userService.addRoleToUser("Saksi", "ROLE_USER");
          userService.addRoleToUser("Saksi", "ROLE_MANAGER");
          userService.addRoleToUser("kSaksi", "ROLE_MANAGER");
          userService.addRoleToUser("oSaksi", "ROLE_ADMIN");

        };
    }

}
