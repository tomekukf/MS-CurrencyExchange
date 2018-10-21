package com.tomek.domek;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//@FeignClient(name="currency-exchange-service", url="localhost:8000") || before zuul and  ribbon
//@FeignClient(name="currency-exchange-service") ||  before zull
@FeignClient(name="netflix-zuul-api-gateway-service")
@RibbonClient(name="currency-exchange-service")
public interface CurrencyExchangeServiceProxy {
	
	
//	@GetMapping("/currency-exchange/from/{from}/to/{to}") || before zuul
	@GetMapping("/currency-exchange-service/currency-exchange/from/{from}/to/{to}")

	public CurrencyConversionBean retriveExchangeValue(@PathVariable("from") String from, @PathVariable("to") String to);
		
		
	

}
