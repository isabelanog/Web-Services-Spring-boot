package com.web.services.spring.boot.services;

import com.web.services.spring.boot.entities.Orders;
import com.web.services.spring.boot.repositories.OrderRepository;
import com.web.services.spring.boot.services.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public List<Orders> findAll() {
        return orderRepository.findAll();
    }
    public Orders findById (Long id) {
        boolean hasOrder = orderRepository.findById(id).isPresent();
        if (!hasOrder) {
            throw new NotFoundException("Order not found");
        }
        return orderRepository.findById(id).get();
    }
}
