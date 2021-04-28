package com.microservices.limitservice.Beans;

public class Limits {
	int minimum;
	int maximum;
	public Limits() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Limits(int minimum, int maximum) {
		super();
		this.minimum = minimum;
		this.maximum = maximum;
	}
	public int getMinimum() {
		return minimum;
	}
	public void setMinimum(int minimum) {
		this.minimum = minimum;
	}
	public int getMaximum() {
		return maximum;
	}
	public void setMaximum(int maximum) {
		this.maximum = maximum;
	}
	@Override
	public String toString() {
		return "Limits [minimum=" + minimum + ", maximum=" + maximum + "]";
	}
	
	
}
