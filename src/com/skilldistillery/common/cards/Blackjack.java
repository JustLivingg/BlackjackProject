package com.skilldistillery.common.cards;

import java.util.Scanner;

public class Blackjack {
//#TODO Write method for the game blackjack that plays on the dealer class.
	private Dealer dealer = new Dealer();
	private Player[] player;
	private Scanner kb = new Scanner(System.in);
	private Deck deck;
	private int users;

//	This method allows multiple players in a game. Adds list of players to array.
	public void playGame() {
		do {
			System.out.print("How many people are playing (1-5)? ");
			users = kb.nextInt();

		} while (users > 5 || users < 0);

		player = new Player[users];
		deck = new Deck();

		for (int i = 0; i < users; i++) {
			System.out.print("What is player " + (i + 1) + "'s name? ");
			String name;
			name = kb.next();
			player[i] = new Player();
			player[i].setName(name);
		}
	}

	public void shuffle() {

		deck.shuffle();
	}

	public void dealCards() {

		for (int j = 0; j < 2; j++) {
			for (int i = 0; i < users; i++) {
				player[i].addCard(deck.dealCard());
			}
			dealer.addCard(deck.dealCard());

		}
	}

	public void checkBlackjack() {
		// System.out.println();

		if (dealer.isBlackjack()) {
			System.out.println("Dealer has BlackJack!");
			for (int i = 0; i < users; i++) {
				if (player[i].getTotal() == 21) {
					System.out.println(player[i].getName() + " loses.");
					boolean keepGoing = false;
				}
			}
		} else {
			if (dealer.peek()) {
				System.out.println("Dealer peeks and does not have a BlackJack");
			}

			for (int i = 0; i < users; i++) {
				if (player[i].getTotal() == 21) {
					System.out.println(player[i].getName() + " has blackjack!");
					System.out.println("Winner, winner chicken dinner.");

				}
			}
		}
	}

	public void hitOrStay() {
		String play;
		char c;
		for (int i = 0; i < users; i++) {
			System.out.println();
			System.out.println(player[i].getName() + " has " + player[i].getHandString());

			do {
				do {
					System.out.print(player[i].getName() + " (H)it or (S)tay? ");
					play = kb.next();
					c = play.toUpperCase().charAt(0);
				} while (!(c == 'H' || c == 'S'));
				if (c == 'H') {
					player[i].addCard(deck.dealCard());
					System.out.println(player[i].getName() + " has " + player[i].getHandString());
					if (player[i].getTotal() > 21 ) {
						System.out.println("You have busted. Better luck next time.");
					}
				}
			} while (c != 'S' && player[i].getTotal() <= 21);
				
		}
	}

	public void dealersTurn() {
		boolean isSomePlayerStillInTheGame = false;
		for (int i = 0; i < users && isSomePlayerStillInTheGame == false; i++) {
			if (player[i].getTotal() <= 21) {
				isSomePlayerStillInTheGame = true;
			}
		}
		if (isSomePlayerStillInTheGame) {
			dealer.dealerPlay(deck);
		}
	}

	public void displayHands() {
		for (int i = 0; i < users; i++) {
			System.out.println(player[i].getName() + " has " + player[i].getHandString());

		}
		System.out.println("Dealer has " + dealer.getHandString(true, true));

	}

}
