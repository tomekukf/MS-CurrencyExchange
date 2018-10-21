package com.tomek.domek;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrecnyExchangerepository extends JpaRepository<ExchangeValue, Long> {
	
	
	public ExchangeValue findAllByFromAndTo(String from,String to);

}
