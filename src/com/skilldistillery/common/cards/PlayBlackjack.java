package com.skilldistillery.common.cards;

import java.util.Scanner;

public class PlayBlackjack {
	private Dealer dealer = new Dealer();
	private Blackjack play = new Blackjack();
	private static Scanner kb = new Scanner(System.in);

	public static void main(String[] args) {

		Dealer dealer = new Dealer();
		Blackjack play = new Blackjack();
		
		boolean keepGoing = true;
		while (keepGoing) {
			System.out.println("Welcome to SD Casino. The game is Blackjack.");
			System.out.println("Please pick from the following menu below.");
			System.out.println();
			System.out.println();
			printMenu();
			int choice = kb.nextInt();

			switch (choice) {
			case 1:
//				Method to print out rules.
				dealer.displayRules();
				break;
			case 2:
				dealer.playBlackjack();
			case 3:
				System.out.println("Quit.");
				keepGoing = false;
				break;
			}

		}

	}
	
	public static void printMenu() {
		System.out.println("================== MENU =================");
		System.out.println("|   1. Display rules.                   |");
		System.out.println("|   2. Play Blackjack.                  |");
		System.out.println("|   3. Quit.                            |");
		System.out.println("=========================================");
		System.out.println();
		
	}

}
