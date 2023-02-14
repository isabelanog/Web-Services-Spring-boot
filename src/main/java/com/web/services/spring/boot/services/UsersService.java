package com.web.services.spring.boot.services;

import com.web.services.spring.boot.entities.Users;
import com.web.services.spring.boot.repositories.UsersRepository;
import com.web.services.spring.boot.services.exception.DataBaseException;
import com.web.services.spring.boot.services.exception.NotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersService {
    @Autowired
    private UsersRepository usersRepository;

    public List<Users> findAll() {
        return usersRepository.findAll();
    }
    public Users findById (Long id) {
        Optional<Users> user = usersRepository.findById(id);
        return user.orElseThrow(() -> new NotFoundException(id));
    }
    public Users insert(Users user) {
        return usersRepository.save(user);
    }
    public void delete(Long id) {
        try {
            usersRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new NotFoundException(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataBaseException(e.getMessage());
        }
    }
    public Users update(Long id, Users user) {
        try {
            Users entity = usersRepository.getReferenceById(id);
            updateData(entity,user);
            return usersRepository.save(entity);
        } catch (EntityNotFoundException e) {
            throw new NotFoundException(id);
        }
    }
    private void updateData(Users entity, Users user) {
        entity.setUserName(user.getUserName());
        entity.setEmail(user.getEmail());
        entity.setPhone(user.getPhone());
    }
}
