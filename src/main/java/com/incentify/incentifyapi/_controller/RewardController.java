package com.incentify.incentifyapi._controller;

import java.io.IOException;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.incentify.incentifyapi._models.RewardItem;
import com.incentify.incentifyapi._service.RewardLoader;

@RestController
class RewardController {

	// TEST
	@ResponseBody
	@RequestMapping(value = "/rewards/all", method = RequestMethod.GET, produces = "application/json")
	List<RewardItem> getRewards() throws IOException {
		RewardLoader rewardLoader = new RewardLoader();
		return rewardLoader.createRewardsList(rewardLoader.getRewards());
	}
}