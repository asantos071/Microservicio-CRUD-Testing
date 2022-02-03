package com.map_json.example.map_json;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages ="com.map_json.example.controllers")
public class MapJsonApplication {

	public static void main(String[] args) {
		SpringApplication.run(MapJsonApplication.class, args);
	}

}
