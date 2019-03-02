package com.incentify.incentifyapi._controller;

import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.incentify.incentifyapi._models.User;
import com.incentify.incentifyapi._service.RewardLoader;
import com.incentify.incentifyapi._service.UserRepository;
import com.incentify.incentifyapi._service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class RewardController {

	// TEST
	@ResponseBody
	@RequestMapping(value = "/rewards/all", method = RequestMethod.GET, produces = "application/json")
	JsonNode getRewards() {
		RewardLoader rewardLoader = new RewardLoader();		
		return rewardLoader.getRewards();
		//return "test";
	}
}