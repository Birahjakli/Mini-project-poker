package view;
import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;

import javafx.util.Duration;

import javafx.scene.control.Label;
import model.CardDeck;


public class DeckLabel extends Label {
	
	
	
		DeckLabel dl = this;
		
	
	private ParallelTransition parallelTransition;
	public DeckLabel() {
		super();
		this.getStyleClass().add("deck");
		this.setStyle("-fx-background-image:url(\"./imagess/yellow_back.PNG\");");

		
		FadeTransition f1 = 
	            new FadeTransition(Duration.millis(3000), dl);
	        f1.setFromValue(2.0f);
	        f1.setToValue(0.02f);
	        f1.setCycleCount(2);
	        f1.setAutoReverse(true);
	        TranslateTransition t1 =
	            new TranslateTransition(Duration.millis(5000), dl);
	        t1.setFromX(700);
	        t1.setToX(1);
	        
	        t1.setCycleCount(1);
	        t1.setAutoReverse(true);
	        RotateTransition r1 = 
	            new RotateTransition(Duration.millis(3000), dl);
	        r1.setByAngle(180f);
	        r1.setCycleCount(2);
	        r1.setAutoReverse(true);
	        /**   ScaleTransition s1 = 
	            new ScaleTransition(Duration.millis(3000), dl);
	        s1.setToX(2f);
	        s1.setToY(2f);
	        s1.setCycleCount(2);
	        s1.setAutoReverse(true);
	    */    
	        parallelTransition = new ParallelTransition();
	        parallelTransition.getChildren().addAll(
	                f1,
	                t1,
	                r1
	               
	        );
	        parallelTransition.play();
		
	
	}
	
	
		
	
	
		
	
	
	// Bind the label to the CardsRemaining property of the deck
	public void setDeck(CardDeck deck) {
		this.textProperty().bind(deck.getCardsRemainingProperty().asString());
		
	}

	/**
	 * Get deck label Animation
	 */
	public void getDeckLabelAnim() {
		FadeTransition f1 = 
	            new FadeTransition(Duration.millis(2000), this);
	        f1.setFromValue(2.0f);
	        f1.setToValue(0.02f);
	        f1.setCycleCount(2);
	        f1.setAutoReverse(true);
	        TranslateTransition t1 =
	            new TranslateTransition(Duration.millis(1900), dl);
	        t1.setFromX(700);
	        t1.setToX(1);
	        
	        t1.setCycleCount(1);
	        t1.setAutoReverse(true);
	        RotateTransition r1 = 
	            new RotateTransition(Duration.millis(1800), dl);
	        r1.setByAngle(180f);
	        r1.setCycleCount(2);
	        r1.setAutoReverse(true);
	        ScaleTransition s1 = 
	            new ScaleTransition(Duration.millis(1500), dl);
	        s1.setToX(2f);
	        s1.setToY(2f);
	        s1.setCycleCount(2);
	        s1.setAutoReverse(true);
	        
	        parallelTransition = new ParallelTransition();
	        parallelTransition.getChildren().addAll(
	                f1,
	                t1,
	                r1,
	                s1
	        );
	        parallelTransition.play();
	}


}
