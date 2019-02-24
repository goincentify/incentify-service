package com.incentify.incentifyapi._service;

import java.util.List;

import com.incentify.incentifyapi._models.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public String registerUser(String firstName, String lastName, String username, String password) {
        if (userRepository.existsByUsername(username)) {
            return "Username has already been taken.";
        }

        String token = "token";
        String job = "job";
        String tier = "tier";
        String bio = "bio";
        String address = "address";
        String city = "city";
        String state = "state";
        int zip = 10101;
        String interests = "interests";
        String picture = "picture";
        int points = 10;
        int totaldays = 10;
        int ontimedays = 10;
        int daystreak = 10;

        User newUser = new User(username, password, firstName, lastName, token, job, tier, bio, address, city, state,
                zip, interests, picture, points, totaldays, ontimedays, daystreak);

        userRepository.save(newUser);

        return newUser.toString();
    }

    public List<User> getAllUsers() {
        return (List<User>) userRepository.findAll();
    }

    // public User updateUser() {

    // return;
    // }
}