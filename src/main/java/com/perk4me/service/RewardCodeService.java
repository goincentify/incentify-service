package com.perk4me.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.perk4me.model.RewardCode;
import com.perk4me.repository.RewardCodeRepository;

@Service
public class RewardCodeService {

	@Autowired
	RewardCodeRepository rewardCodeRepository;

	private boolean exists(String code) {
		return rewardCodeRepository.existsByCode(code);
	}

	private RewardCode getRewardCode(String code) {
		return rewardCodeRepository.findByCode(code).get(0);
	}

	public Integer redeem(String code) {
		if (!exists(code)) {
			return 0;
		} else {
			RewardCode reward = getRewardCode(code);
			return reward.getValue();
		}
	}

}