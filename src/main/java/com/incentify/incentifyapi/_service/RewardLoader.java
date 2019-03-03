package com.incentify.incentifyapi._service;

import java.io.File;
import java.net.URL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;

@Service
public class RewardLoader {
//	@Autowired
//	ReadJson readJson;

	public String getRewards() {
		ReadJson readJson = new ReadJson();
		//URL url = getClass().getResource("_defaultRewards.json");
		   File directory = new File("../src/main/java/com/incentify/incentifyapi/_models/_defaultRewards.json");
		   System.out.println(directory.getAbsolutePath());
		return directory.getAbsolutePath();
		//return readJson.readFileAsString("C:\\Users\\Luke\\Documents\\incentify\\incentify-service\\src\\main\\java\\com\\incentify\\incentifyapi\\_models\\_defaultRewards.json");
	}

}
