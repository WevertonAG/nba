package com.example.nba.controller;

import com.example.nba.entity.User;
import com.example.nba.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public List<User> getAllUsers() {

        return userService.getAllUser();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable String id) {
        User userSelect = userService.verifyUser(id);

        if (userSelect == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(userSelect);

    }

    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody User user) {
        userService.addUser(user);
        return ResponseEntity.created(null).body(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@RequestBody User updateUser, @PathVariable String id) {
        User user = userService.verifyUser(id);
        if(user != null){
            User userUpdate = userService.updateUser(id,updateUser);
            return ResponseEntity.ok().body(userUpdate);

        }
        return ResponseEntity.notFound().build();

    }

    @PatchMapping("/{id}")
    public ResponseEntity<User> updatePoints(@RequestParam("points") int points, @PathVariable String id) {
        User user = userService.verifyUser(id);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        user.setPoints(points);
        userService.updateUser(id,user);

        return ResponseEntity.ok().body(user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable String id) {
        User user = userService.verifyUser(id);
        if(user == null){
            return ResponseEntity.notFound().build();
        }
        userService.deleteUser(id);
        return ResponseEntity.ok().body(null);
    }
}
