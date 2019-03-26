package com.perk4me.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.perk4me.model.RewardItem;
import com.perk4me.service.RewardLoader;
import com.perk4me.service.RewardService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
class RewardController {

	@Autowired
	RewardService rewardService = new RewardService();

	// GET all rewards
	@ResponseBody
	@RequestMapping(value = "/rewards/list", method = RequestMethod.GET, produces = "application/json")
	List<RewardItem> getRewards() throws IOException {
		RewardLoader rewardLoader = new RewardLoader();
		return rewardLoader.createRewardsList(rewardLoader.getRewards());
	}

	// POST load rewards
	@PreAuthorize("hasAnyRole('USER', 'ADMIN')")
	@RequestMapping(value = "/rewards/load", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody Iterable<RewardItem> loadRewards() {
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