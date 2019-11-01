package model;

/**
 * Card Model.
 * @author hbira
 */
public class Card {
	//private String cardName;
	public String type;
	public Integer cardValue;
	
	/**
	 * Constructor.
	 * @param Integer cardValue
	 * @param String type
	 */
	public Card( Integer cardValue,String type) {
		// Variables initialization.
		this.type = type;
		this.cardValue = cardValue;
	}

	/**
	 * Card value getter.
	 * @return Integer.
	 */
	public Integer getCardValue() {
		return cardValue;
	}

	/**
	 * Card type getter.
	 * @return String.
	 */
    public String getType() {
		return type;
	}
	
	/**
	 * To String Method.
	 */
	@Override
    public String toString() {
        return type.toString() + cardValue.toString();
    }
}