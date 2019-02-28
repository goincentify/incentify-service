package com.incentify.incentifyapi._service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import com.incentify.incentifyapi._models.Tier;
import com.incentify.incentifyapi._models.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RewardCodeService rewardCodeService;

    @Autowired
    private RewardCodeRepository rewardCodeRepository;

    private Tier tier = new Tier();

    Random random = new Random();

    public String registerUser(String firstName, String lastName, String username, String password) {
        if (userRepository.existsByUsername(username)) {
            return null;
        }

        User newUser = new User();

        newUser.setUsername(username);
        newUser.setPassword(password);
        newUser.setFirstName(firstName);
        newUser.setLastName(lastName);
        newUser.setToken("token");
        newUser.setJob("Employee");
        newUser.setBio("No bio saved!");
        newUser.setAddress("");
        newUser.setCity("city");
        newUser.setState("state");
        newUser.setZip(0);
        newUser.setInterests("No interests saved!");
        newUser.setPicture("No picture on file");
        newUser.setPoints(random.nextInt(2001) + 4000); // 4000 - 6000
        newUser.setTotaldays(random.nextInt(101) + 200); // 200 - 300
        newUser.setOntimedays(random.nextInt(151) + 100); // 100 - 250
        newUser.setDaystreak(random.nextInt(21) + 3); // 3 - 20

        newUser.setTier(tier.getTier(newUser).getValue());

        userRepository.save(newUser);

        return newUser.toString();
    }

    public List<User> getAllUsers() {
        return (List<User>) userRepository.findAll();
    }

    public int remove(Long id) {
        try {
            userRepository.deleteById(id);
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }

    public User update(Long id, String username, String password, String address, String city, String state,
            Integer zip, String bio) {

        User updateUser = userRepository.findById(id).get();

        updateUser.setUsername(username);
        updateUser.setPassword(password);
        updateUser.setAddress(address);
        updateUser.setCity(city);
        updateUser.setState(state);
        updateUser.setZip(zip);
        updateUser.setBio(bio);

        return userRepository.save(updateUser);
    }

    public Integer addUserPoints(Long id, Integer points) {
        return userRepository.addUserPoints(id, points);
    }

    public Integer redeem(Long id, String code) {
        return userRepository.addUserPoints(id, rewardCodeService.redeem(code));
    }

    public User find(Long id) {
        return userRepository.findById(id).get();
    }

}