package com.tomek.domek;

import java.math.BigDecimal;

public class CurrencyConversionBean {
	
	private Long id;
	private String from;
	private String to;
	private BigDecimal conversionMultiple;
	private BigDecimal quantity;
	private BigDecimal totalAmiuntCalculated;
	private int port;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public BigDecimal getQuantity() {
		return quantity;
	}
	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}
	public BigDecimal getConversionMultiple() {
		return conversionMultiple;
	}
	public void setConversionMultiple(BigDecimal conversionMultiple) {
		this.conversionMultiple = conversionMultiple;
	}
	public BigDecimal getTotalAmiuntCalculated() {
		return totalAmiuntCalculated;
	}
	public void setTotalAmiuntCalculated(BigDecimal totalAmiuntCalculated) {
		this.totalAmiuntCalculated = totalAmiuntCalculated;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	public CurrencyConversionBean(Long id, String from, String to, BigDecimal quantity, BigDecimal conversionMultiple,
			BigDecimal totalAmiuntCalculated,int port) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.quantity = quantity;
		this.conversionMultiple = conversionMultiple;
		this.totalAmiuntCalculated = totalAmiuntCalculated;
		this.port=port;
		
		
	}
//	public CurrencyConversionBean(Long long1, String from2, String to2, BigDecimal quantity2, BigDecimal bigDecimal, BigDecimal bigDecimal2, int i) {
//		super();
		// TODO Auto-generated constructor stub
//	}
	public CurrencyConversionBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return String.format(
				"CurrencyConversionBean [id=%s, from=%s, to=%s, conversionMultiple=%s, quantity=%s, totalAmiuntCalculated=%s, port=%s]",
				id, from, to, conversionMultiple, quantity, totalAmiuntCalculated, port);
	}
	
	
	
	

}
