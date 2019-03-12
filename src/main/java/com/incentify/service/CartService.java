package com.incentify.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.incentify.model.Cart;
import com.incentify.model.RewardItem;
import com.incentify.repository.CartRepository;
import com.incentify.repository.RewardRepository;

@Service
public class CartService {
	@Autowired
	private CartRepository cartRepository;

	@Autowired
	private RewardRepository rewardRepository;

	public Cart addItem(Long cartId, Long itemId) {
		Cart cart = cartRepository.findById(cartId).get();
		RewardItem itemToAdd = rewardRepository.findById(itemId).get();
		cart.getCartItems().add(itemToAdd);
		return cartRepository.save(cart);
	}

	public Cart removeItem(Long cartId, Long itemId) {
		Cart cart = cartRepository.findById(cartId).get();
		RewardItem itemToRemove = rewardRepository.findById(itemId).get();
		cart.getCartItems().remove(itemToRemove);
		return cartRepository.save(cart);
	}

	public List<RewardItem> getContents(Long cartId) {
		Cart cart = cartRepository.findById(cartId).get();
		return cart.getCartItems();
	}
}