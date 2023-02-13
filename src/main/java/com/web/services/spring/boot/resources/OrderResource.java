package com.web.services.spring.boot.resources;

import com.web.services.spring.boot.entities.Orders;
import com.web.services.spring.boot.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/orders")
public class OrderResource {
    @Autowired
    private OrderService orderService;
    @GetMapping
    public ResponseEntity<List<Orders>> findAll() {
        List<Orders> orderList = orderService.findAll();
        return ResponseEntity.ok().body(orderList);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<Orders> findById(@PathVariable Long id) {
        Orders order = orderService.findById(id);
        return ResponseEntity.ok().body(order);
    }

}
