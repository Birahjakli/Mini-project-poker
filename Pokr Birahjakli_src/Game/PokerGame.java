 package Game;

import controller.Controller;

import javafx.application.Application;
import javafx.stage.Stage;
import model.PokerModel;
import view.PokerGView;

public class PokerGame extends Application{
	public static int NUM_PLAYERS;
	PokerModel model;
	PokerGView view;
	Controller controller;
	
	
	
	public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
    	
    	// Create and initialize the MVC components
    	model = new PokerModel();
    	view = new PokerGView(primaryStage, model);
    	controller = new Controller(model, view);
    }
}
