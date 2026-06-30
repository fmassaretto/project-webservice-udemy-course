package org.example.projectwebservicesection22.services;

import org.example.projectwebservicesection22.entities.User;
import org.example.projectwebservicesection22.repositories.UserRepository;
import org.example.projectwebservicesection22.services.exceptions.DatabaseException;
import org.example.projectwebservicesection22.services.exceptions.ResourceNotFoundException;
import org.h2.jdbc.JdbcSQLIntegrityConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findById(Long id){
        Optional<User> user = userRepository.findById(id);

        return user.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public User insert(User user){
        return userRepository.save(user);
    }

    public void delete(Long id){
        try{
            userRepository.deleteById(id);
        } catch(EmptyResultDataAccessException e){
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException dive) {
            throw new DatabaseException(dive.getMessage());
        }
    }

    public User update(Long id, User user) {
        User userToUpdate = userRepository.getReferenceById(id);

        updateData(userToUpdate, user);

        return userRepository.save(userToUpdate);
    }

    private void updateData(User userToUpdate, User user) {
        userToUpdate.setName(user.getName());
        userToUpdate.setEmail(user.getEmail());
        userToUpdate.setPhone(user.getPhone());
    }

}
