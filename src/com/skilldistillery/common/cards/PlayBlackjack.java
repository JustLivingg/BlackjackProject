package com.skilldistillery.common.cards;

public class PlayBlackjack {

	public static void main(String[] args) {

		Dealer dealer = new Dealer();
		Blackjack play = new Blackjack();

		displayRules();

		play.playGame();
		play.shuffle();
		play.dealCards();
		play.displayHands();
//		play.checkBlackjack();
//		play.hitOrStay();
//		play.dealersTurn();

	}

	public static void displayRules() {

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

}
