package com.incentify.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.incentify.model.RewardItem;

@Transactional
public interface RewardRepository extends CrudRepository<RewardItem, Long> {

}