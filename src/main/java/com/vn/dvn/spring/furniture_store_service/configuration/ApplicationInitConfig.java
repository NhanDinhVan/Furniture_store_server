package com.vn.dvn.spring.furniture_store_service.configuration;


import com.vn.dvn.spring.furniture_store_service.entity.Users;
import com.vn.dvn.spring.furniture_store_service.enums.Role;
import com.vn.dvn.spring.furniture_store_service.repository.UserRepository;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;

@Configuration
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ApplicationInitConfig {

    PasswordEncoder passwordEncoder;

    @NonFinal
    String password = "admin";
    @NonFinal
    String username = "admin@gmail.com";
    @Bean
    ApplicationRunner applicationRunner(UserRepository userRepository)
    {
        return args->{
            if(userRepository.findByEmail(username).isEmpty()){
                Users user = Users.builder()
                        .email("admin@gmail.com")
                        .password(passwordEncoder.encode(password))
                        .role(Role.ADMIN.name())
                        .build();
                userRepository.save(user);
                log.warn("Admin user has been created with default password: admin, please change it !");
            }
        } ;
    }
}
