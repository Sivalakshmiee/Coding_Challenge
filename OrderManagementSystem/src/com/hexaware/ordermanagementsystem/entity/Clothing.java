package com.hexaware.ordermanagementsystem.entity;

public class Clothing extends Product{
	
	private String size;
    private String color;
	public Clothing() {
		super();
	}
	public Clothing(String size, String color) {
		super();
		this.size = size;
		this.color = color;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
    
    

}
