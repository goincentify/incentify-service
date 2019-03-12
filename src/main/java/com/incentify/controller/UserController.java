package com.incentify.controller;

import java.util.List;

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

import com.incentify.model.User;
import com.incentify.model.UserDto;
import com.incentify.repository.UserRepository;
import com.incentify.service.UserService;

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
	@RequestMapping(value = "/getUserByUsername", method = RequestMethod.GET, produces = "application/json")
	User getUserByUsername(
			@RequestParam(value = "username", required = false, defaultValue = "sergeihanka") String username) {
		System.out.println("Made it to service");
		return userRepository.findByUsername(username);
	}

	// GET get all users
	@ResponseBody
	@RequestMapping(value = "/user/all", method = RequestMethod.GET, produces = "application/json")
	List<User> getAllUsers() {
		return userService.getAllUsers();
	}

	// GET get user by ID
	@ResponseBody
	@RequestMapping(value = "/getUserById", method = RequestMethod.GET, produces = "application/json")
	User getUserById(@RequestParam(value = "id", required = false, defaultValue = "1") String id) {
		return userService.find(Long.parseLong(id));
	}

	// POST authenticate user
	@ResponseBody
	@RequestMapping(value = "/user/authenticate", method = RequestMethod.POST, produces = "application/json")
	User authenticateUser(@RequestParam(value = "username", required = true) String username,
			@RequestParam(value = "password", required = true) String password) {
		return null;
	}

	// POST add points to user
	@ResponseBody
	@RequestMapping(value = "/user/points/add", method = RequestMethod.POST, produces = "application/json")
	int addUserPoints(@RequestParam(value = "points") String points, @RequestParam(value = "id") String id) {
		return userService.addUserPoints(Long.parseLong(id), Integer.parseInt(points));
	}

	// POST redeem valid code
	@ResponseBody
	@RequestMapping(value = "/user/points/redeem", method = RequestMethod.POST, produces = "application/json")
	Integer redeemUserPoints(@RequestParam(value = "code") String code, @RequestParam(value = "id") String id) {
		return userService.redeem(Long.parseLong(id), code);
	}

	// POST redeem valid code
	@ResponseBody
	@RequestMapping(value = "/user/update", method = RequestMethod.POST, produces = "application/json")
	User updateUser(@RequestParam(value = "id") String id,
			@RequestParam(value = "username", required = false) String username,
			@RequestParam(value = "password", required = false) String password,
			@RequestParam(value = "address", required = false) String address,
			@RequestParam(value = "city", required = false) String city,
			@RequestParam(value = "state", required = false) String state,
			@RequestParam(value = "zip", required = false) Integer zip,
			@RequestParam(value = "bio", required = false) String bio) {

		return userService.update(Long.parseLong(id), username, password, address, city, state, zip, bio);
	}

	// DELETE delete user
	@ResponseBody
	@RequestMapping(value = "/user/delete", method = RequestMethod.DELETE, produces = "application/json")
	int deleteUser(@RequestParam(value = "id", required = false, defaultValue = "1") String id) {
		return userService.remove(Long.parseLong(id));
	}
}
