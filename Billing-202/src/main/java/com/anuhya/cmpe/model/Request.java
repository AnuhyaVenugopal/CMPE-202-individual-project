package com.anuhya.cmpe.model;

public class Request {
	private String itemRequest;
	private int quantity;
	private String cardNumber;
	
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

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public Request(String itemRequest, int quantity, String cardNumber) {
		this.itemRequest = itemRequest;
		this.quantity = quantity;
		this.cardNumber = cardNumber;
	}

	@Override
	public String toString() {
		return "Request [itemRequest=" + itemRequest + ", quantity=" + quantity + ", cardNumber=" + cardNumber + "]";
	}
	
}
