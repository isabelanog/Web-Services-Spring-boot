package com.web.services.spring.boot.repositories;

import com.web.services.spring.boot.entities.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Orders,Long> {
}
