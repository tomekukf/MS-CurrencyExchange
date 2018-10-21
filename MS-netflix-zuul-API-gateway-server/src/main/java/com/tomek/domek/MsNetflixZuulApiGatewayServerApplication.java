package com.tomek.domek;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import brave.sampler.Sampler;

@EnableZuulProxy
@EnableDiscoveryClient
@SpringBootApplication
public class MsNetflixZuulApiGatewayServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsNetflixZuulApiGatewayServerApplication.class, args);
	}
	
	//Sampler which traces all requests.  If you trace all the requests, there is a 
	//possibility of a performance problem. The samplers provide you with an option of decided the kind of requests you would want to trace. 
	@Bean
	public Sampler defaultSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}
	
}
