package com.web.services.spring.boot.resources;

import com.web.services.spring.boot.entities.Users;
import com.web.services.spring.boot.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UsersResource  {
    @Autowired
    private UsersService usersService;
    @GetMapping
    public ResponseEntity<List<Users>> findAll() {
        List<Users> usersList = usersService.findAll();
        return ResponseEntity.ok().body(usersList);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<Users> findById(@PathVariable Long id) {
        Users user = usersService.findById(id);
        return ResponseEntity.ok().body(user);
    }
    @PostMapping
    public ResponseEntity<Users> insert(@RequestBody Users user) {
        user = usersService.insert(user);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(user.getUserId()).toUri();
        return ResponseEntity.created(uri).body(user);
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        usersService.delete(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<Users> update(@PathVariable Long id, @RequestBody Users user) {
        user = usersService.update(id, user);
        return ResponseEntity.ok().body(user);
    }
}
