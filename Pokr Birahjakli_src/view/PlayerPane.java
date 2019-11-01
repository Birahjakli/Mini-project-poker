package view;


import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import model.Card;
import model.Hand;
import model.Player;


public class PlayerPane extends VBox {
	private ParallelTransition parallelTransition;
    private Label lblName = new Label();
    private HBox hboxCards = new HBox();
    private Label lblEvaluation = new Label("--");
    public Label lblwin = new Label("--");
    
    // Link to player object
    private Player player;
    
    public PlayerPane() {
        super(); 
        this.getStyleClass().add("player"); // CSS style class
        
        // Add child nodes
        this.getChildren().addAll(lblName, hboxCards, lblEvaluation,lblwin);
        
        // Add CardLabels for the cards
        for (int i = 0; i < 5; i++) {
            Label lblCard = new CardLabel();
            hboxCards.getChildren().add(lblCard);
        }
    }
    
    public void setPlayer(Player player) {
    	this.player = player;
    	updatePlayerDisplay(); // Immediately display the player information
    }
    
    public void updatePlayerDisplay() {
    	this.lblName.setText(this.player.getPlayerName());
    	for (int i = 0; i < Player.HAND_SIZE; i++) {
    		Card card = null;
    		if (this.player.getCards().size() > i) 
    			card = this.player.getCards().get(i);
    		 CardLabel cl = (CardLabel) this.hboxCards.getChildren().get(i);
    		if(card !=null) {
    			
    		cl.cardPics(card);
    		cl.setCard(card);
    		}
    		//
    		FadeTransition fadeTransition = 
    	            new FadeTransition(Duration.millis(1000), cl);
    	        fadeTransition.setFromValue(2.0f);
    	        fadeTransition.setToValue(0.02f);
    	        fadeTransition.setCycleCount(2);
    	        fadeTransition.setAutoReverse(true);
    	        
    	        parallelTransition = new ParallelTransition();
    	        parallelTransition.getChildren().addAll(
    	                fadeTransition
    	                
    	        );
    	        parallelTransition.play();
    		//
    		Hand evaluation = player.evaluateHand();
    		if (evaluation != null)
    			lblEvaluation.setText(evaluation.toString());
    		
    		else
    			lblEvaluation.setText("--");
    		
    	}
    	
    	
	
    }
    
}