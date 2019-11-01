package model;

import java.util.ArrayList;



public class Player implements Comparable<Player> {

	public static final int HAND_SIZE = 5;
	private  String playerName ; 
	private final ArrayList<Card> playerCards = new ArrayList<>();
	private Hand handType;
	
	

	public Player(String playerName) {
		this.playerName = playerName;
	}

	public String getPlayerName() {
		return playerName;
	}

	public ArrayList<Card> getCards() {
		return playerCards;
	}

	public void addCard(Card card) {
		if (playerCards.size() < HAND_SIZE)
			playerCards.add(card);
	}

	public void discardHand() {
		playerCards.clear();
		handType = null;
	}

	public int getNumCards() {
		return playerCards.size();
	}

	public Hand evaluateHand() {
		if (handType == null && playerCards.size() == HAND_SIZE) {
			handType = Hand.evaluateHand(playerCards);
		}
		return handType;
	}

	
	@Override
	public int compareTo(Player o) {
		
		
//		 int result;
//				 result = this.handType.getEvalValue().compareTo(o.handType.getEvalValue());
		if(this.handType.getEvalValue() == o.handType.getEvalValue())
		return 0;
			if(this.handType.getEvalValue() > o.handType.getEvalValue())
		return 1;
			else {
		return -1;
			}
	}
	

}
