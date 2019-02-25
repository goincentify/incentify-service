package com.incentify.incentifyapi._controller;

import java.util.List;

import com.incentify.incentifyapi._models.User;
import com.incentify.incentifyapi._service.UserRepository;
import com.incentify.incentifyapi._service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class UserController {

	@Autowired
	UserService userService = new UserService();

	@Autowired
	private UserRepository userRepository;

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
		// User usr = new User("lennon", "password", "John", "Lennon");
		return userRepository.findById(Long.parseLong(id)).get();
	}

	// POST authenticate user
	@ResponseBody
	@RequestMapping(value = "/user/authenticate", method = RequestMethod.POST, produces = "application/json")
	User authenticateUser(@RequestParam(value = "id", required = false, defaultValue = "1") String id) {
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
	String deleteUser(@RequestParam(value = "id", required = false, defaultValue = "1") String id) {
		return "DELETE";
	}
}