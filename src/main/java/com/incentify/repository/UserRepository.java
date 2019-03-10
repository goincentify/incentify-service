package com.incentify.repository;

import java.util.List;
import java.util.Optional;

import com.incentify.model.User;
import com.incentify.model.UserDto;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);

    User save(UserDto user);

    List<User> findAll();

    // User findOne(String username);

    Optional<User> findById(Long id);

    boolean existsByUsername(String username);

    @Modifying
    void deleteById(Long id);

    @Modifying
    @Query("update User user set user.points = points + :points where user.id = :id")
    int addUserPoints(@Param("id") Long id, @Param("points") Integer points);

    @Modifying
    @SuppressWarnings("unchecked")
    User save(User user);

}
