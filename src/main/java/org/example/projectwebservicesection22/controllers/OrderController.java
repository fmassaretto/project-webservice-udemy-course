package org.example.projectwebservicesection22.controllers;

import org.example.projectwebservicesection22.entities.Order;
import org.example.projectwebservicesection22.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping
    public ResponseEntity<List<Order>> findAll() {
        List<Order> orders = orderService.findAll();

        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Order> findById(@PathVariable(value = "id") Long id) {
        Order order = orderService.findById(id);

        return new ResponseEntity<>(order, HttpStatus.OK);
    }
}
