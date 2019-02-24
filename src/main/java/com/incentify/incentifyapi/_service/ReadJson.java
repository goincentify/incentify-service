package com.incentify.incentifyapi._service;

import java.io.File;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.stereotype.Service;

@Service
public class ReadJson {

    public JsonNode readFileAsString(String filepath) {

        File file = new File(filepath);

        ObjectMapper mapper = new ObjectMapper();

        try {

            JsonNode node = mapper.readValue(file, JsonNode.class);

            return node;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}