package com.incentify.incentifyapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.incentify.incentifyapi._models.RewardItem;

@Transactional
public interface RewardRepository extends CrudRepository<RewardItem, Long> {

}