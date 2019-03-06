package com.incentify.incentifyapi._controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.incentify.incentifyapi._models.RewardItem;
import com.incentify.incentifyapi._service.RewardLoader;
import com.incentify.incentifyapi._service.RewardService;

@RestController
class RewardController {

	@Autowired
	RewardService rewardService = new RewardService();

	// TEST
	@ResponseBody
	@RequestMapping(value = "/rewards/list", method = RequestMethod.GET, produces = "application/json")
	List<RewardItem> getRewards() throws IOException {
		RewardLoader rewardLoader = new RewardLoader();
		return rewardLoader.createRewardsList(rewardLoader.getRewards());
	}

	// POST register user
	@RequestMapping(value = "/rewards/load", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody Iterable<RewardItem> registerUser() {
		System.out.println("In rewards/load");
		try {
			return rewardService.loadRewards(getRewards());
		} catch (Exception e) {
			// Artisanally crafted catch block
			e.printStackTrace();
		}
		return null;
	}
}