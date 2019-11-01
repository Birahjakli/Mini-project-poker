package view;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.Card;


/**
 * Class Card Label 
 * @author hbira
 *
 */
public class CardLabel extends Label {
	public CardLabel() {
		super();
		this.getStyleClass().add("card");
	}

	/**
	 * 
	 * @param card
	 * @return card path
	 */
	public String cardPics(Card card) {
		
		String type = card.getType().toString();
		Integer cardValue = card.getCardValue();
		return cardValue + type+".png";
	
	}
	
	
	/**
	 * 
	 * @param card
	 * attach cards to pics 
	 */
	
	public void setCard(Card card) {
		if (card != null) {
			String cardImage = cardPics(card);
			Image image = new Image("./imagess/" + cardImage);
			ImageView imagev = new ImageView(image);
			imagev.fitWidthProperty().bind(this.widthProperty());
			imagev.fitHeightProperty().bind(this.heightProperty());
			imagev.setPreserveRatio(true);
			this.setGraphic(imagev);
		} else {
			this.setGraphic(null);
		}
	}

	
	
}
