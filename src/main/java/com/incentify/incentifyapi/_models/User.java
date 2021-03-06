package com.incentify.incentifyapi._models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class User {

	@Id
	@GeneratedValue
	Long id;

	@OneToOne(cascade = CascadeType.ALL)
	Cart cart = new Cart();

	String username;
	String password;
	String firstName;
	String lastName;
	String token;
	String job;
	String tier;
	String bio;
	String address;
	String city;
	String state;
	Integer zip;
	String interests;
	String picture;
	Integer points;
	Integer totaldays;
	Integer ontimedays;
	Integer daystreak;
	// Cart create new cart
	// https://github.com/goincentify/incentify-service/projects/6?add_cards_query=is%3Aopen

	// DEFAULT, makes JPA happy.
	public User() {
		super();
	}

	public User(String username, String password, String firstName, String lastName) {
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.token = "fake-jwt-token";
	}

	public User(String username, String password, String firstName, String lastName, String token, String job,
			String tier, String bio, String address, String city, String state, Integer zip, String interests,
			String picture, Integer points, Integer totaldays, Integer ontimedays, Integer daystreak) {

		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.token = token;
		this.job = job;
		this.tier = tier;
		this.bio = bio;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.interests = interests;
		this.picture = picture;
		this.points = points;
		this.totaldays = totaldays;
		this.ontimedays = ontimedays;
		this.daystreak = daystreak;
	}

	@Override
	public String toString() {
		return "id: " + this.id + ", username: " + this.username + ", lastName, firstName:  " + this.lastName + ", "
				+ this.firstName;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		if (id != null) {
			this.id = id;
		}
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		if (username != null) {
			this.username = username;
		}
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		if (password != null) {
			this.password = password;
		}
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		if (firstName != null) {
			this.firstName = firstName;
		}
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		if (lastName != null) {
			this.lastName = lastName;
		}
	}

	/**
	 * @return the token
	 */
	public String getToken() {
		return token;
	}

	/**
	 * @param token the token to set
	 */
	public void setToken(String token) {
		if (token != null) {
			this.token = token;
		}
	}

	/**
	 * @return the job
	 */
	public String getJob() {
		return job;
	}

	/**
	 * @param job the job to set
	 */
	public void setJob(String job) {
		if (job != null) {
			this.job = job;
		}
	}

	/**
	 * @return the tier
	 */
	public String getTier() {
		return tier;
	}

	/**
	 * @param tier the tier to set
	 */
	public void setTier(String tier) {
		if (tier != null) {
			this.tier = tier;
		}
	}

	/**
	 * @return the bio
	 */
	public String getBio() {
		return bio;
	}

	/**
	 * @param bio the bio to set
	 */
	public void setBio(String bio) {
		if (bio != null) {
			this.bio = bio;
		}
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		if (address != null) {
			this.address = address;
		}
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		if (city != null) {
			this.city = city;
		}
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		if (state != null) {
			this.state = state;
		}
	}

	/**
	 * @return the zip
	 */
	public Integer getZip() {
		return zip;
	}

	/**
	 * @param zip the zip to set
	 */
	public void setZip(Integer zip) {
		if (zip != null) {
			this.zip = zip;
		}
	}

	/**
	 * @return the interests
	 */
	public String getInterests() {
		return interests;
	}

	/**
	 * @param interests the interests to set
	 */
	public void setInterests(String interests) {
		if (interests != null) {
			this.interests = interests;
		}
	}

	/**
	 * @return the picture
	 */
	public String getPicture() {
		return picture;
	}

	/**
	 * @param picture the picture to set
	 */
	public void setPicture(String picture) {
		if (picture != null) {
			this.picture = picture;
		}
	}

	/**
	 * @return the points
	 */
	public Integer getPoints() {
		return points;
	}

	/**
	 * @param points the points to set
	 */
	public void setPoints(Integer points) {
		if (points != null) {
			this.points = points;
		}
	}

	/**
	 * @return the totaldays
	 */
	public Integer getTotaldays() {
		return totaldays;
	}

	/**
	 * @param totaldays the totaldays to set
	 */
	public void setTotaldays(Integer totaldays) {
		if (totaldays != null) {
			this.totaldays = totaldays;
		}
	}

	/**
	 * @return the ontimedays
	 */
	public Integer getOntimedays() {
		return ontimedays;
	}

	/**
	 * @param ontimedays the ontimedays to set
	 */
	public void setOntimedays(Integer ontimedays) {
		if (ontimedays != null) {
			this.ontimedays = ontimedays;
		}
	}

	/**
	 * @return the daystreak
	 */
	public Integer getDaystreak() {
		return daystreak;
	}

	/**
	 * @param daystreak the daystreak to set
	 */
	public void setDaystreak(Integer daystreak) {
		if (daystreak != null) {
			this.daystreak = daystreak;
		}
	}

}