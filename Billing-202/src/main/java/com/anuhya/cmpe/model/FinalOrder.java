package com.anuhya.cmpe.model;

public class FinalOrder {
	
	private String itemRequest;
	private int quantity;
	private double price;
	private double finalPrice;
	
	public String getItemRequest() {
		return itemRequest;
	}
	public void setItemRequest(String itemRequest) {
		this.itemRequest = itemRequest;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getFinalPrice() {
		return finalPrice;
	}
	public void setFinalPrice(double finalPrice) {
		this.finalPrice = finalPrice;
	}
	
	@Override
	public String toString() {
		return "FinalOrder [itemRequest=" + itemRequest + ", quantity=" + quantity + ", price=" + price
				+ ", finalPrice=" + finalPrice + "]";
	}
	
	public FinalOrder(String itemRequest, int quantity, double price, double finalPrice) {
		this.itemRequest = itemRequest;
		this.quantity = quantity;
		this.price = price;
		this.finalPrice = finalPrice;
	}
	
	
}
