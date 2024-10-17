package com.hexaware.ordermanagementsystem.entity;

public class Electronics extends Product{
	
	private String brand;
    private int warrantyPeriod;
	public Electronics() {
		super();
	}
	public Electronics(String brand, int warrantyPeriod) {
		super();
		this.brand = brand;
		this.warrantyPeriod = warrantyPeriod;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public int getWarrantyPeriod() {
		return warrantyPeriod;
	}
	public void setWarrantyPeriod(int warrantyPeriod) {
		this.warrantyPeriod = warrantyPeriod;
	}
    
    

}
