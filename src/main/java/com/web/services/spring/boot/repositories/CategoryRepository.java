package com.web.services.spring.boot.repositories;

import com.web.services.spring.boot.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {
}
