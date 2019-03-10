package com.incentify.controller;

import java.util.List;

import com.incentify.model.User;
import com.incentify.model.UserDto;
import com.incentify.repository.UserRepository;
import com.incentify.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    // @Secured({"ROLE_ADMIN", "ROLE_USER"})
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    // @PreAuthorize("hasRole('USER')")
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<User> listUser() {
        return userRepository.findAll();
    }

    // @Secured("ROLE_USER")
    // @PreAuthorize("hasRole('USER')")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    public User getOne(@PathVariable(value = "id") Long id) {
        return userRepository.findById(id).get();
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public User saveUser(@RequestBody UserDto user) {
        return userRepository.save(user);
    }

    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @ResponseBody
    @RequestMapping(value = "/user", method = RequestMethod.GET, produces = "application/json")
    User getUser(@RequestParam(value = "username", required = false, defaultValue = "sergeihanka") String username) {
        System.out.println("Made it to service");
        return userRepository.findByUsername(username);
    }

}
