package com.matching_system.users.Controllers;

import com.matching_system.users.Models.User;
import com.matching_system.users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping
    public void SaveUser(@RequestBody User user){
        userService.saveUser(user);
    }

    @GetMapping
    public ResponseEntity<?> getAllUsers(){
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Long id){
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUserById(@PathVariable Long id, @RequestBody User userDetails){
        return ResponseEntity.ok(userService.updateUser(id,userDetails));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> partialUpdateUserById(@PathVariable Long id, @RequestBody User userDetails){
        return ResponseEntity.ok(userService.partialUpdateUser(id,userDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteuserById(@PathVariable Long id){
        return ResponseEntity.ok(userService.deleteUser(id));
    }

}
