package view;

import Game.PokerGame;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.PokerModel;

public class PokerGView {

	private GridPane players;
	public ControlArea controls;
	private PokerModel model;

	public PokerGView(Stage stage, PokerModel model) {
		this.model = model;
		players = new GridPane();

		// Create the control area
		controls = new ControlArea();
		controls.linkDeck(model.getDeck()); // link DeckLabel to DeckOfCards in the logic

		MenuBar menu = new MenuBar();

		Menu mPlayer = new Menu("Players");
		MenuItem mip2 = new MenuItem("2 Players");
		MenuItem mip3 = new MenuItem("3 Players");
		MenuItem mip4 = new MenuItem("4 Players");

		mip2.setOnAction(new EventHandler<ActionEvent>() {

 
			@Override
			public void handle(ActionEvent event) {
				players.getChildren().clear();
				PokerGame.NUM_PLAYERS = 2;

				for (int i = 0; i < PokerGame.NUM_PLAYERS; i++) {

					PlayerPane pp = new PlayerPane();
					pp.setPlayer(PokerModel.getPlayer(i)); // link to player object in the logic
					players.getChildren().add(pp);
					int col = i / 2;
					int row = i % 2;
					GridPane.setConstraints(pp, col, row);
					stage.sizeToScene();
				}
			}
		});
		mip3.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				players.getChildren().clear();
				PokerGame.NUM_PLAYERS = 3;
				for (int i = 0; i < PokerGame.NUM_PLAYERS; i++) {
					PlayerPane pp = new PlayerPane();
					pp.setPlayer(PokerModel.getPlayer(i)); // link to player object in the logic
					players.getChildren().add(pp);
					int col = i / 2;
					int row = i % 2;
					GridPane.setConstraints(pp, col, row);
				   
					stage.sizeToScene();
				}Alert alert = new Alert(AlertType.INFORMATION);
	            alert.setHeaderText(null);
	            alert.setContentText("Get New Deck first and shuffle");
	            alert.showAndWait();
			}
		});
		mip4.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				players.getChildren().clear();
				PokerGame.NUM_PLAYERS = 4;
				for (int i = 0; i < PokerGame.NUM_PLAYERS; i++) {
					PlayerPane pp = new PlayerPane();
					pp.setPlayer(PokerModel.getPlayer(i)); // link to player object in the logic
					players.getChildren().add(pp);
					int col = i / 2;
					int row = i % 2;
					GridPane.setConstraints(pp, col, row);
					stage.sizeToScene();

				}
				Alert alert = new Alert(AlertType.INFORMATION);
	            alert.setHeaderText(null);
	            alert.setContentText("Get New Deck first and shuffle");
	            alert.showAndWait();
			}
		});
		mPlayer.getItems().addAll(mip2, mip3, mip4);
		menu.getMenus().addAll(mPlayer);

		// Put players and controls into a BorderPane

		BorderPane root = new BorderPane();
		root.setTop(menu);
		root.setCenter(players);
		root.setBottom(controls);

		players.getStyleClass().add("player"); // more than one
		stage.setResizable(true);
		stage.setFullScreen(false);

		// Create the scene using our layout; then display it

		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("poker.css").toExternalForm());
		stage.setTitle("Poker Miniproject");
		stage.setScene(scene);
		stage.sizeToScene();
		stage.show();
	}

	public PlayerPane getPlayerPane(int i) {
		return (PlayerPane) this.players.getChildren().get(i);
	}

	public Button getShuffleButton() {
		return controls.btnShuffle;
	}

	public Button getDealButton() {
		return controls.btnDeal;
	}

	public Button getSetCardButton() {
		return controls.setCard;
	}

	public Button getExitB() {
		return controls.exitB;
	}

}
