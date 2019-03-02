package com.incentify.incentifyapi._service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;

@Service
public class RewardLoader {
//	@Autowired
//	ReadJson readJson;

	public JsonNode getRewards() {
		ReadJson readJson = new ReadJson();
		return readJson.readFileAsString("C:\\Users\\Luke\\Documents\\incentify\\incentify-service\\src\\main\\java\\com\\incentify\\incentifyapi\\_models\\_defaultRewards.json");
	}

}
