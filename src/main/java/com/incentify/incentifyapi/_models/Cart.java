package com.incentify.incentifyapi._models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Cart {
	@Id
	@GeneratedValue
	Long id;

	@OneToMany(cascade = CascadeType.ALL)
	List<RewardItem> items = new ArrayList<RewardItem>();

	public Cart() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<RewardItem> getCartItems() {
		return items;
	}

	public void setCartItems(List<RewardItem> cartItems) {
		this.items = cartItems;
	}
}