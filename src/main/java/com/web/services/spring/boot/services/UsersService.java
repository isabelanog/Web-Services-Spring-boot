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
    public Users insert(Users user) {
        return usersRepository.save(user);
    }
    public void delete(Long id) {
        usersRepository.deleteById(id);
    }
    public Users update(Long id, Users user) {
        Users entity = usersRepository.getReferenceById(id);
        updateData(entity,user);
        return usersRepository.save(entity);
    }
    private void updateData(Users entity, Users user) {
        entity.setUserName(user.getUserName());
        entity.setEmail(user.getEmail());
        entity.setPhone(user.getPhone());
    }
}
