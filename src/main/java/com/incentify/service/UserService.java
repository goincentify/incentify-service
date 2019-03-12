package com.incentify.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.incentify.model.Tier;
import com.incentify.model.User;
import com.incentify.repository.RewardCodeRepository;
import com.incentify.repository.UserRepository;

@Service(value = "userService")
public class UserService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RewardCodeService rewardCodeService;

	@Autowired
	private RewardCodeRepository rewardCodeRepository;

	private Tier tier = new Tier();

	Random random = new Random();

	@Autowired
	private BCryptPasswordEncoder bcryptEncoder;

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				getAuthority(user));
	}

	private Set<SimpleGrantedAuthority> getAuthority(User user) {
		Set<SimpleGrantedAuthority> authorities = new HashSet<>();
		user.getRoles().forEach(role -> {
			// authorities.add(new SimpleGrantedAuthority(role.getName()));
			authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName()));
		});
		return authorities;
	}

	public List<User> findAll() {
		List<User> list = new ArrayList<>();
		userRepository.findAll().iterator().forEachRemaining(list::add);
		return list;
	}

	public int remove(Long id) {
		try {
			userRepository.deleteById(id);
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}

	public User find(Long id) {
		return userRepository.findById(id).get();
	}

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
}