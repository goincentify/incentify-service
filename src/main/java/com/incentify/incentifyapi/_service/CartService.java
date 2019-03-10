package com.incentify.incentifyapi._service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.incentify.incentifyapi._models.Cart;
import com.incentify.incentifyapi._models.RewardItem;

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
}