package com.incentify.incentifyapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.incentify.incentifyapi._models.Cart;

@Transactional
public interface CartRepository extends CrudRepository<Cart, Long> {

}
