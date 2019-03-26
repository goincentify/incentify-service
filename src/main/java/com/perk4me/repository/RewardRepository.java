package com.perk4me.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.perk4me.model.RewardItem;

@Transactional
public interface RewardRepository extends CrudRepository<RewardItem, Long> {

}