package com.tomek.domek;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tomek.domek.bean.LimitConfiguration;

@RestController
public class LimitsServiceConfigurationController {
	
	@Autowired
	private Configuration configuration;
	
	@GetMapping("/limits")
	public LimitConfiguration retriveLimitsConfiguration() {
		return new LimitConfiguration(configuration.getMin(),configuration.getMax());
	}

}
