package com.incentify.incentifyapi._controller;

import java.util.List;

import com.incentify.incentifyapi._models.User;
import com.incentify.incentifyapi._service.UserRepository;
import com.incentify.incentifyapi._service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class UserController {

	@Value("${properties.message}")
	private String message;

	@Autowired
	UserService userService = new UserService();

	@Autowired
	private UserRepository userRepository;

	// TEST
	@ResponseBody
	@RequestMapping(value = "/message", method = RequestMethod.GET, produces = "application/json")
	String getMessage() {
		return message;
	}

	// POST register user
	@RequestMapping(value = "/user/register", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody String registerUser(@RequestParam String firstName, @RequestParam String lastName,
			@RequestParam String username, @RequestParam String password) {

		return "Register: " + userService.registerUser(firstName, lastName, username, password);
	}

	// GET get all users
	@ResponseBody
	@RequestMapping(value = "/user/all", method = RequestMethod.GET, produces = "application/json")
	List<User> getAllUsers() {
		return userService.getAllUsers();
	}

	// GET get user by ID
	@ResponseBody
	@RequestMapping(value = "/user", method = RequestMethod.GET, produces = "application/json")
	User getUser(@RequestParam(value = "id", required = false, defaultValue = "1") String id) {
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
	String addUserPoints(@RequestParam(value = "id", required = false, defaultValue = "1") String id) {
		return "ADD POINTS";
	}

	// POST redeem valid code
	@ResponseBody
	@RequestMapping(value = "/user/points/redeem", method = RequestMethod.POST, produces = "application/json")
	String redeemUserPoints(@RequestParam(value = "id", required = false, defaultValue = "1") String id) {
		return "REDEEM";
	}

	// DELETE delete user
	@ResponseBody
	@RequestMapping(value = "/user/delete", method = RequestMethod.DELETE, produces = "application/json")
	int deleteUser(@RequestParam(value = "id", required = false, defaultValue = "1") String id) {
		return userService.remove(Long.parseLong(id));
	}
}