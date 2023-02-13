package com.web.services.spring.boot.config;

import com.web.services.spring.boot.entities.Category;
import com.web.services.spring.boot.entities.Orders;
import com.web.services.spring.boot.entities.Users;
import com.web.services.spring.boot.entities.enums.OrderStatus;
import com.web.services.spring.boot.repositories.CategoryRepository;
import com.web.services.spring.boot.repositories.OrderRepository;
import com.web.services.spring.boot.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.Instant;
import java.util.Arrays;

@Configuration
public class TestConfig implements CommandLineRunner {
    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void run(String... args) throws Exception {

        usersRepository.deleteAll();
        orderRepository.deleteAll();
        categoryRepository.deleteAll();

        Category cat1 = new Category(null, "Electronics");
        Category cat2 = new Category(null, "Books");
        Category cat3 = new Category(null, "Computers");

        Users u1 = new Users(null, "Maria Green", "maria@gmail.com","988888888", "123456");
        Users u2 = new Users(null, "Alex Green", "alex@gmail.com","977777777", "123456");

        Orders o1 = new Orders(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID,u1);
        Orders o2 = new Orders(null,Instant.parse("2019-07-21T03:53:07Z") ,OrderStatus.WAITING_PAYMENT,u2);
        Orders o3 = new Orders(null, Instant.parse("2019-07-22T15:53:07Z"),OrderStatus.WAITING_PAYMENT,u1);


        categoryRepository.saveAll(Arrays.asList(cat1,cat2,cat3));
        usersRepository.saveAll(Arrays.asList(u1,u2));
        orderRepository.saveAll(Arrays.asList(o1,o2,o3));
    }
}
