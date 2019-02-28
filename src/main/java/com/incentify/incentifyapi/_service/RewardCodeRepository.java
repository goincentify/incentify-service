package com.incentify.incentifyapi._service;

import java.util.List;

import com.incentify.incentifyapi._models.RewardCode;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface RewardCodeRepository extends CrudRepository<RewardCode, Long> {

    boolean existsByCode(String code);

    List<RewardCode> findByCode(String code);

}