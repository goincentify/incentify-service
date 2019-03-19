package com.incentify.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.incentify.model.Cart;
import com.incentify.model.RewardItem;
import com.incentify.service.CartService;

@RestController
class CartController {

	@Autowired
	private CartService cartService;

	// POST add item to cart
	@ResponseBody
	@RequestMapping(value = "/cart/add", method = RequestMethod.POST, produces = "application/json")
	Cart addItem(@RequestParam(value = "cartId", required = true) Long cartId,
			@RequestParam(value = "itemId", required = true) Long itemId) {
		return cartService.addItem(cartId, itemId);
	}

	// GET remove item from Cart
	@ResponseBody
	@RequestMapping(value = "/cart/remove", method = RequestMethod.GET, produces = "application/json")
	Cart removeItem(@RequestParam(value = "cartId", required = true) Long cartId,
			@RequestParam(value = "itemId", required = true) Long itemToDrop) {
		return cartService.removeItem(cartId, itemToDrop);
	}

	// GET Cart's content
	@ResponseBody
	@RequestMapping(value = "/cart/contents", method = RequestMethod.GET, produces = "application/json")
	List<RewardItem> cartContents(@RequestParam(value = "cartId", required = true) Long cartId) {
		return cartService.getContents(cartId);
	}
}