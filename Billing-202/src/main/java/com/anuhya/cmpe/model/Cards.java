package com.anuhya.cmpe.model;

public class Cards {
	private String cardID;

	public Cards(String cardID) {
		this.cardID = cardID;
	}

	public String getCardID() {
		return cardID;
	}

	public void setCardNumber(String cardID) {
		this.cardID = cardID;
	}

	@Override
	public String toString() {
		return "Cards [cardID=" + cardID + "]";
	}

}
