package com.backend.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.backend.entity.User;
import com.backend.exceptions.UserNotFoundException;
import com.backend.repository.UserRepository;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
public class UserResource {

    // Autowire the StudentRepository so that we can retrieve and save data to the
    // database.
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public List<User> retrieveAllUsers() {
        List<User> users = userRepository.findAll();
        System.out.println("Users retrieved: " + users);
        return users;
    }

    // exposing details of a specific user

    // same as "users/{id}"
    @GetMapping("users/{uni_num}")
    public User retrieveUser(@PathVariable long uni_num) {
        Optional<User> user = userRepository.findById(uni_num);

        if (user.isEmpty()) {

            // formulate exceptions
            throw new UserNotFoundException("id/university number:" + uni_num);

        }
        return user.get();
    }

    // deleting user
    @DeleteMapping("/users/{uni_num}")
    public void deleteUser(@PathVariable long uni_num) {
        userRepository.deleteById((uni_num));
    }

    // adding user
    @PostMapping("/users")
    public ResponseEntity<Object> createUser(@RequestBody User user) {
        User savedUser = userRepository.save(user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{uni_num}")
                .buildAndExpand(savedUser.getUni_num()).toUri();

        return ResponseEntity.created(location).build();
    }

    // updating a user
    @PutMapping("/users/{uni_num}")
    public ResponseEntity<Object> updateUser(@RequestBody User user, @PathVariable long uni_num) {
        Optional<User> userOptional = userRepository.findById(uni_num);

        if (userOptional.isEmpty())
            return ResponseEntity.notFound().build();

        // check here, initially it was setId
        user.setUni_num(uni_num);
        userRepository.save(user);
        return ResponseEntity.noContent().build();

    }
}
