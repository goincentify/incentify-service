package com.incentify.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.incentify.model.RewardCode;

@Transactional
public interface RewardCodeRepository extends CrudRepository<RewardCode, Long> {

	boolean existsByCode(String code);

	List<RewardCode> findByCode(String code);

}