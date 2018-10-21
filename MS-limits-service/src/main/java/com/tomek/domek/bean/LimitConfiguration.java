package com.tomek.domek.bean;

public class LimitConfiguration {

	
	
	private int min;
	private int max;
	public int getMin() {
		return min;
	}
	public void setMin(int min) {
		this.min = min;
	}
	public int getMax() {
		return max;
	}
	public void setMax(int max) {
		this.max = max;
	}
	@Override
	public String toString() {
		return String.format("LimitConfiguration [min=%s, max=%s]", min, max);
	}
	public LimitConfiguration(int min, int max) {
		this.min = min;
		this.max = max;
	}
	public LimitConfiguration() {
	}
	
	
}
