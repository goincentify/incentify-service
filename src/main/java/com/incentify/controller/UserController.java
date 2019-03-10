package com.incentify.controller;

import com.incentify.model.User;
import com.incentify.model.UserDto;
import com.incentify.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    // @Secured({"ROLE_ADMIN", "ROLE_USER"})
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    // @PreAuthorize("hasRole('USER')")
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<User> listUser() {
        return userService.findAll();
    }

    // @Secured("ROLE_USER")
    // @PreAuthorize("hasRole('USER')")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    public User getOne(@PathVariable(value = "id") Long id) {
        return userService.findById(id);
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public User saveUser(@RequestBody UserDto user) {
        return userService.save(user);
    }

    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @ResponseBody
    @RequestMapping(value = "/user", method = RequestMethod.GET, produces = "application/json")
    User getUser(@RequestParam(value = "username", required = false, defaultValue = "sergeihanka") String username) {
        System.out.println("Made it to service");
        return userService.findOne(username);
    }

}
