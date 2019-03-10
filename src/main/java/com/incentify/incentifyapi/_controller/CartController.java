package com.incentify.incentifyapi._controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.incentify.incentifyapi._models.RewardItem;
import com.incentify.incentifyapi._service.CartService;

@RestController
class CartController {

	@Autowired
	private CartService cartService = new CartService();

	// POST add item to cart
	@ResponseBody
	@RequestMapping(value = "/cart/add", method = RequestMethod.POST, produces = "application/json")
	List<RewardItem> addItem() {
		return cartService.removeItem();
	}

	// GET remove item from Cart
	@ResponseBody
	@RequestMapping(value = "/cart/remove", method = RequestMethod.GET, produces = "application/json")
	List<RewardItem> removeItem(@RequestParam(value = "cart_id", required = true) String cartId,
			@RequestParam(value = "items_id", required = true) Long itemToDrop) {
		return cartService.removeItem();
	}
}