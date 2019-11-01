package model;

import java.util.ArrayList;

public class PokerModel {
	public  final static  ArrayList<Player> playersArray = new ArrayList<>();
	private CardDeck deck;

	public PokerModel() {
		// only 4 players, and possible to make it for 10
		for (int i = 1; i <=4 ; i++) {
			playersArray.add(new Player("Player " +i));
		}

		deck = new CardDeck();
	}

	public static Player getPlayer(int i) {
		return playersArray.get(i);
	}

	public CardDeck getDeck() {
		return deck;
	}
}
