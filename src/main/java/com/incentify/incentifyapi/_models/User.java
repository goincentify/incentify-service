package com.incentify.incentifyapi._models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

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

    protected User() {
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
        this.id = id;
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
        this.username = username;
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
        this.password = password;
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
        this.firstName = firstName;
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
        this.lastName = lastName;
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
        this.token = token;
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
        this.job = job;
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
        this.tier = tier;
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
        this.bio = bio;
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
        this.address = address;
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
        this.city = city;
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
        this.state = state;
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
        this.zip = zip;
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
        this.interests = interests;
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
        this.picture = picture;
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
        this.points = points;
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
        this.totaldays = totaldays;
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
        this.ontimedays = ontimedays;
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
        this.daystreak = daystreak;
    }

}