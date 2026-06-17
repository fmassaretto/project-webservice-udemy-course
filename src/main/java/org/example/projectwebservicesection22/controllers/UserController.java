package org.example.projectwebservicesection22.controllers;

import org.example.projectwebservicesection22.entities.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @GetMapping
    public ResponseEntity<User> findAll() {
        User u = new User(1L, "Marcia", "marcia@gmail.com", "114536456456", "12345678");

        return new ResponseEntity<>(u, HttpStatus.OK);
    }
}
