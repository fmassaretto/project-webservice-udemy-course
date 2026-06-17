package org.example.projectwebservicesection22.services;

import org.example.projectwebservicesection22.entities.User;
import org.example.projectwebservicesection22.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }
}
