package com.skilldistillery.common.cards;

public class TestTEst {

	public static void main(String[] args) {
		Deck deck = new Deck();
		
		int value = 0;
		for (int i = 0; i < 2; i++) {
			deck.shuffle();
			Card c = deck.dealCard();
			value += c.getValue();
			System.out.println(c);
		}
		System.out.println("Your value is " + value);
	}
}
