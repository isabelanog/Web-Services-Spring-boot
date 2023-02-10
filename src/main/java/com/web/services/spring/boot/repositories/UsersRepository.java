package com.web.services.spring.boot.repositories;

import com.web.services.spring.boot.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users,Long> {

}
