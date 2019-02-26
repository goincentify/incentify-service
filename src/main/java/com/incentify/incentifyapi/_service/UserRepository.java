package com.incentify.incentifyapi._service;

import java.util.List;

import com.incentify.incentifyapi._models.User;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

    boolean existsByUsername(String username);

    void deleteById(Long id);

    List<User> findByLastName(String lastName);

    List<User> findByFirstName(String firstName);

}