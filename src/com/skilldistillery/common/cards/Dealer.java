package com.skilldistillery.common.cards;

import java.util.Scanner;

public class Dealer {
	private Hand hand = new Hand();
	private Scanner kb = new Scanner(System.in);



	public void playBlackjack() {
		Blackjack game = new Blackjack();
		game.shuffle();
		game.dealCards();
		game.displayHands();
		game.checkBlackjack();
		game.hitOrStay();
		game.dealersTurn();
	}

	public void displayRules() {

		System.out.println("Blackjack Rules");
		System.out.println();
		System.out.println("Each player is dealt 2 cards, and the dealer is dealt one card face-up and down.");
		System.out.println("Cards are equal exactly to their value with face cards being 10 and Ace being 11.");
		System.out.println("The players cards are added up for their total.");
		System.out.println("Player(s) 'hit' to gain another card from the deck, or 'stay' at their current total. ");
		System.out.println("Dealer has a set of rules that they follow, they will 'hit' until 17, or 'stay'.");
		System.out.println("The goal is to have a higher card total than the dealer without going over 21.");
		System.out.println("Getting 21 on your first two cards is called Blackjack.");
		System.out.println();
		System.out.println();
	}

	public boolean isBlackjack() {
		if (hand.calculateTotal() == 21) {
			return true;
		} else {
			return false;
		}
	}
	
	
	
	// This automates the dealer's play
	public void dealerPlay(Deck deck){
		System.out.println();
		while (hand.calculateTotal() <= 16) {
			System.out.println("Dealer has " + hand.calculateTotal()+ " and hits");
			hand.addCard(deck.nextCard());
			System.out.println("Dealer " + this.getHandString(true, false));
		} 
		if ( hand.calculateTotal() > 21) {
			System.out.println("Dealer busts. " + this.getHandString(true, false));
		} else {
			System.out.println("Dealer stands. " + this.getHandString(true, false));
		}
	}
	
	// Adds a card o the dealer's hand
	public void addCard(Card card) {
		hand.addCard(card);

	}
	
	// Gets the dealer's hand as a string
	public String getHandString(boolean isDealer, boolean hideHoleCard ) {
		String str = "Cards:" + hand.toString(isDealer, hideHoleCard);

		return str;
	}
	
	// Calculates the dealer's hand total
	public int calculateTotal() {
		return hand.calculateTotal();
	}
	
	// Clears the dealer's hand
	public void clearHand() {
		hand.clearHand();
	}
	
	// Peeks the dealer's face-down card
	public boolean peek() {
		return hand.dealerPeek();
	}
	


}