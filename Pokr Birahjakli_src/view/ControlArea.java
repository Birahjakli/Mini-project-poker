package view;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import model.CardDeck;


public class ControlArea extends HBox{
    public DeckLabel lblDeck = new DeckLabel();
    private Region spacer = new Region(); // Empty spacer
    Button btnShuffle = new Button("Shuffle");
    Button btnDeal = new Button("Deal");
    Button setCard = new Button("New Deck");
    Button exitB = new Button("Exit");
    
    
    
    public ControlArea() {
    	super(); // 
    	
    	this.getChildren().addAll(lblDeck, spacer, btnShuffle, btnDeal,setCard,exitB);
    	
    	
 
        HBox.setHgrow(spacer, Priority.ALWAYS); // Use region to absorb resizing
        this.setId("controlArea"); // Unique ID in the CSS
        setCard.getStyleClass().add("button1");
        btnDeal.getStyleClass().add("button1");
        btnShuffle.getStyleClass().add("button1");
        exitB.getStyleClass().add("button2");
    }
    
    
    public void linkDeck(CardDeck deck) {
    	lblDeck.setDeck(deck);
    }
}
