package com.tomek.domek;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {
	

	private Logger logger = LoggerFactory.getLogger(CurrencyExchangeController.class);
	
	@Autowired
	private Environment environment;
	
	@Autowired
	private CurrecnyExchangerepository exchangeRepo;
	
//	@Autowired
//	public EntityManager em;
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public ExchangeValue exchangeValue(@PathVariable String from, @PathVariable String to) {
		
		
		ExchangeValue all = exchangeRepo.findAllByFromAndTo(from, to);
		ExchangeValue exchangeValue = all;
		
//		Query query = em.createNativeQuery("Select * from exchange_value where currency_from=?" , ExchangeValue.class);
//		query.setParameter(1, "usd");
//	List<ExchangeValue> list = query.getResultList();
//		System.out.println("lollllllllllllllllllllllllllllllllll");
//		System.out.println(list);
		
		int port = Integer.parseInt(environment.getProperty("local.server.port"));
		
		exchangeValue.setPort(port);
		
		logger.info("{}",exchangeValue);
		
		return exchangeValue;
		
	}

}
