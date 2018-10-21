package com.tomek.domek;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CurrencyConversionController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CurrencyExchangeServiceProxy feignProxy;

	@GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean convserionBean(@PathVariable String from,@PathVariable String to,@PathVariable  BigDecimal  quantity) {
		
		
		Map<String,String> uriVariables = new HashMap<>();
		uriVariables.put("from", from.toLowerCase());
		uriVariables.put("to", to.toLowerCase());
//																						http://localhost:8000/currency-exchange/from/usd/to/inr
		ResponseEntity<CurrencyConversionBean> response = new RestTemplate().getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}", CurrencyConversionBean.class, uriVariables );
//		ResponseEntity<CurrencyConversionBean> responseEntity = new RestTemplate().getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}", CurrencyConversionBean.class,uriVariables);
		CurrencyConversionBean body = response.getBody();
		System.out.println(body);
		
		return new CurrencyConversionBean(body.getId(), from.toLowerCase(), to.toLowerCase(), quantity, body.getConversionMultiple(), quantity.multiply(body.getConversionMultiple()),body.getPort());
//		return new CurrencyConversionBean(1L, from, to, quantity, quantity, quantity, 1001);
	}
	

	@GetMapping("/currency-converter-feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean convserionBeanFeign(@PathVariable String from,@PathVariable String to,@PathVariable  BigDecimal  quantity) {
		
		
		CurrencyConversionBean body = feignProxy.retriveExchangeValue(from, to);
		
		logger.info("{}",body);
		
		return new CurrencyConversionBean(body.getId(), from.toLowerCase(), to.toLowerCase(), quantity, body.getConversionMultiple(), quantity.multiply(body.getConversionMultiple()),body.getPort());
//		return new CurrencyConversionBean(1L, from, to, quantity, quantity, quantity, 1001);
	}
	
	
}
