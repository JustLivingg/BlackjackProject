package com.skilldistillery.common.cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	// Create a class that holds a List of cards.
	private List<Card> cards; // List of cards
	private int nextCardIndex;
	//Intializing list with 52 cards.
	public Deck() {
		cards = createDeck();
		nextCardIndex = 0;
	}

	//Method that passes the list of cards and adds to deck.
	private List<Card> createDeck() {
		List<Card> deck = new ArrayList<>(52);
		for (Suit s : Suit.values()) {
			for (Rank r : Rank.values()) {
				deck.add(new Card(r, s));
			}
		}
		return deck;
	}

	public int checkDeckSize() {
		return cards.size();
	}

	public void shuffle() {
		Collections.shuffle(cards);
	}

	public Card dealCard() {
		return cards.remove(0);
	}
	

	
	
	
	
	
	
	
	
	
	
}