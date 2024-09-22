package com.matching_system.users.service;

import com.matching_system.users.Models.User;
import com.matching_system.users.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return (List<User>) userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontró el usuario con el id " + id));
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(Long id, User userDetails) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontró el usuario con el id " + id));

        user.setName(userDetails.getName());
        user.setAge(userDetails.getAge());
        user.setAddress(userDetails.getAddress());
        user.setPhoneNumber(userDetails.getPhoneNumber());
        user.setRegistrationDate(userDetails.getRegistrationDate());
        user.setEmail(userDetails.getEmail());

        return userRepository.save(user);
    }

    public User partialUpdateUser(Long id, User userDetails) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontró el usuario con el id " + id));

        if (userDetails.getName() != null) {
            user.setName(userDetails.getName());
        }
        if (userDetails.getAge() != 0) {
            user.setAge(userDetails.getAge());
        }
        if (userDetails.getAddress() != null) {
            user.setAddress(userDetails.getAddress());
        }
        if (userDetails.getPhoneNumber() != null) {
            user.setPhoneNumber(userDetails.getPhoneNumber());
        }
        if (userDetails.getRegistrationDate() != null) {
            user.setRegistrationDate(userDetails.getRegistrationDate());
        }
        if (userDetails.getEmail() != null) {
            user.setEmail(userDetails.getEmail());
        }

        return userRepository.save(user);
    }

    public String deleteUser(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontró el usuario con el id " + id));
        userRepository.delete(user);
        return "Se ha borrado el usuario con el id " + id;
    }
}