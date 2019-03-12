package com.incentify.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@OneToOne(cascade = CascadeType.ALL)
	Cart cart = new Cart();

	@Column
	private String username;

	@Column
	@JsonIgnore
	private String password;

	@Column
	String firstName;

	@Column
	String lastName;

	private Integer age;
	private String job;
	private String tier;
	private String bio;
	private String address;
	private String city;
	private String state;
	private Integer zip;
	private String interests;
	private String picture;
	private Integer points;
	private Integer totaldays;
	private Integer ontimedays;
	private Integer daystreak;
	private String token;

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

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "USER_ROLES", joinColumns = { @JoinColumn(name = "USER_ID") }, inverseJoinColumns = {
			@JoinColumn(name = "ROLE_ID") })
	private Set<Role> roles;

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getTier() {
		return tier;
	}

	public void setTier(String tier) {
		this.tier = tier;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Integer getZip() {
		return zip;
	}

	public void setZip(Integer zip) {
		this.zip = zip;
	}

	public String getInterests() {
		return interests;
	}

	public void setInterests(String interests) {
		this.interests = interests;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public Integer getPoints() {
		return points;
	}

	public void setPoints(Integer points) {
		this.points = points;
	}

	public Integer getTotaldays() {
		return totaldays;
	}

	public void setTotaldays(Integer totaldays) {
		this.totaldays = totaldays;
	}

	public Integer getOntimedays() {
		return ontimedays;
	}

	public void setOntimedays(Integer ontimedays) {
		this.ontimedays = ontimedays;
	}

	public Integer getDaystreak() {
		return daystreak;
	}

	public void setDaystreak(Integer daystreak) {
		this.daystreak = daystreak;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
}
