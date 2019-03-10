package com.incentify.incentifyapi._service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.incentify.incentifyapi._models.RewardItem;
import com.incentify.incentifyapi.repository.RewardRepository;

@Service
public class RewardService {

	@Autowired
	private RewardRepository rewardRepository;

	@Transactional
	public Iterable<RewardItem> loadRewards(List<RewardItem> rewards) {
		System.out.println("In loadRewards");
		return rewardRepository.saveAll(rewards);
	}
}