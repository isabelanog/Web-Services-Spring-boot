package com.web.services.spring.boot.Resources;

import com.web.services.spring.boot.Entities.Users;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;

@RestController
@RequestMapping(value = "/users")
public class UsersResource  {
    @GetMapping
    public ResponseEntity<Users> findAll() {
        Users users = new Users(1L,"Maria","maria@gmail.com","9999999","12345");
        return ResponseEntity.ok().body(users);
    }
}
