package com.pscouse.conference.controller;

import com.pscouse.conference.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/user")
    public User getUser(@RequestParam(value = "firstname", defaultValue = "Czarek") String firstname,
                        @RequestParam(value = "lastname", defaultValue = "Platek") String lastname,
                        @RequestParam(value = "age", defaultValue = "22") int age){
        User user = new User();
        user.setFirstname(firstname);
        user.setLastname(lastname);
        user.setAge(age);
        return user;
    }

    @PostMapping
    public User postUser(User user){
        System.out.println("User's first name: " + user.getFirstname());
        return user;
    }
}
