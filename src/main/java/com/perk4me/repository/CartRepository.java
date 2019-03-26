package com.perk4me.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.perk4me.model.Cart;

@Transactional
public interface CartRepository extends CrudRepository<Cart, Long> {

}
