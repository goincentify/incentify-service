package com.incentify.incentifyapi._service;

import org.springframework.data.repository.CrudRepository;

import com.incentify.incentifyapi._models.RewardItem;

public interface RewardRepository extends CrudRepository<RewardItem, Long> {

}