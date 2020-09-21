package com.skilldistillery.common.cards;

public class Player {

	private String name;
	private Hand hand;

	public Player() {
		hand = new Hand();
	}
	
	public void setName(String name ) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public int getTotal() {
		return hand.calculateTotal();
	}
	
	public void addCard(Card nextCard) {
		hand.addCard(nextCard);
	}
	
	public String getHandString() {
		String str = "Cards: " + hand.toString();
		return str;
	}
	
	public void clearHand() {
		hand.clearHand();
	}



}
