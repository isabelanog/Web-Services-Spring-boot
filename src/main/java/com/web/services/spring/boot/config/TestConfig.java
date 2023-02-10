package com.web.services.spring.boot.config;

import com.web.services.spring.boot.entities.Users;
import com.web.services.spring.boot.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class TestConfig implements CommandLineRunner {
    @Autowired
    private UsersRepository usersRepository;

    @Override
    public void run(String... args) throws Exception {

        usersRepository.deleteAll();

        Users u1 = new Users(null, "Maria Green", "maria@gmail.com","988888888", "123456");
        Users u2 = new Users(null, "Alex Green", "alex@gmail.com","977777777", "123456");

        usersRepository.saveAll(Arrays.asList(u1,u2));
    }
}
