package com.anuhya.cmpe.model;

public class Items {
	private String itemName;
	private String itemCatergory;
	private int itemQuantity;
	private double itemPrice;
	
	public Items(String itemName, String itemCatergory, int itemQuantity, double itemPrice) {
		this.itemName = itemName;
		this.itemCatergory = itemCatergory;
		this.itemQuantity = itemQuantity;
		this.itemPrice = itemPrice;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemCatergory() {
		return itemCatergory;
	}

	public void setItemCatergory(String itemCatergory) {
		this.itemCatergory = itemCatergory;
	}

	public int getItemQuantity() {
		return itemQuantity;
	}

	public void setItemQuantity(int itemQuantity) {
		this.itemQuantity = itemQuantity;
	}

	public double getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(double itemPrice) {
		this.itemPrice = itemPrice;
	}

	@Override
	public String toString() {
		return "Items [itemName=" + itemName + ", itemCatergory=" + itemCatergory + ", itemQuantity=" + itemQuantity
				+ ", itemPrice=" + itemPrice + "]";
	}
	
}
