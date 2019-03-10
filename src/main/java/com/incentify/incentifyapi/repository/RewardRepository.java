package com.incentify.incentifyapi.repository;

import org.springframework.data.repository.CrudRepository;

import com.incentify.incentifyapi._models.RewardItem;

public interface RewardRepository extends CrudRepository<RewardItem, Long> {

}