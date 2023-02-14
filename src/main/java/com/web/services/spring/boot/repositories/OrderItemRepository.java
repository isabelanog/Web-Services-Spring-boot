package com.web.services.spring.boot.repositories;

import com.web.services.spring.boot.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem,Long> {
}
