package com.incentify.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.incentify.model.Cart;

@Transactional
public interface CartRepository extends CrudRepository<Cart, Long> {

}
