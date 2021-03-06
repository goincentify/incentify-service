package com.incentify.incentifyapi._service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.incentify.incentifyapi._models.RewardItem;

@Service
public class RewardLoader {

	public String getRewards() throws IOException {
		ReadJson readJson = new ReadJson();
		File directory = new File("./src/main/java/com/incentify/incentifyapi/_models/_defaultRewards.json");
		return readJson.readFileAsString(directory.getAbsolutePath());
	}

	public List<RewardItem> createRewardsList(String jsonRewardList) throws IOException {
		List<RewardItem> rewardItems = new ArrayList<RewardItem>();
		ObjectMapper jsonMapper = new ObjectMapper();
		try {
			System.out.println(jsonRewardList);
			System.out.println(
					"JsonMapper: " + jsonMapper.readValue(jsonRewardList, new TypeReference<List<RewardItem>>() {
					}));
			rewardItems = jsonMapper.readValue(jsonRewardList, new TypeReference<List<RewardItem>>() {
			});
		} catch (JsonProcessingException e) {
			// Definitely a hand written auto catch block.
			e.printStackTrace();
		}
		return rewardItems;
	}
}