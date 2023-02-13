package com.web.services.spring.boot.services;

import com.web.services.spring.boot.entities.Users;
import com.web.services.spring.boot.repositories.UsersRepository;
import com.web.services.spring.boot.services.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService {
    @Autowired
    private UsersRepository usersRepository;

    public List<Users> findAll() {
        return usersRepository.findAll();
    }
    public Users findById (Long id) {
        boolean hasUser = usersRepository.findById(id).isPresent();
            if (!hasUser) {
                throw new NotFoundException("User not found");
            }
        return usersRepository.findById(id).get();
    }
}
