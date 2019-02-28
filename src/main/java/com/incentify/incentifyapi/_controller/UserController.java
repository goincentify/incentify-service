package com.incentify.incentifyapi._controller;

import java.util.List;

import com.incentify.incentifyapi._models.User;
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
	private UserService userService = new UserService();

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