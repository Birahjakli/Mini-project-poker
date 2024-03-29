
package controller;

import Game.PokerGame;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import model.Card;
import model.CardDeck;
import model.Player;
import model.PokerModel;
import view.PlayerPane;
import view.PokerGView;

public class Controller {

	/**
	 * PkerModeol PokerModel
	 */
	private static PokerModel model;
	private PokerGView view;
	/**
	 *  Constructor 
	 * @param model
	 * @param view
	 */
	public Controller(PokerModel model, PokerGView view) {
		this.model = model;
		this.view = view;

		view.getShuffleButton().setOnAction(e -> shuffle());
		view.getDealButton().setOnAction(e -> deal());
		view.getSetCardButton().setOnAction(e -> NewDeck());
		view.getExitB().setOnAction(e -> Platform.exit());
		view.getExitB().setOnAction(e -> Platform.exit());
		view.controls.lblDeck.setOnMouseExited(mouseExited);
	}

/**
 * 
 */
	public void NewDeck() {
		this.view.controls.lblDeck.getDeckLabelAnim();
		model.getDeck().NewDeck();

	}

EventHandler<MouseEvent> mouseExited = new EventHandler<MouseEvent>() {
	@Override
	public void handle(MouseEvent e) {
		NewDeck();
		view.controls.lblDeck.onMouseDragExitedProperty(); 
	}
};

	/**
	 * Remove all cards from players hands
	 *  and shuffle the deck
	 */
	private void shuffle() {
		for (int i = 0; i < PokerGame.NUM_PLAYERS; i++) {
			Player p = this.model.getPlayer(i);
			p.discardHand();
			PlayerPane pp = this.view.getPlayerPane(i);
			pp.updatePlayerDisplay();
		}

		model.getDeck().shuffle();
	}

	/**
	 * Deal each player five cards, then evaluate
	 */
	private void deal() {

		int cardsRequired = PokerGame.NUM_PLAYERS * Player.HAND_SIZE;
		CardDeck deck = model.getDeck();
		if (cardsRequired <= deck.LeftCards()) {
			for (int i = 0; i < PokerGame.NUM_PLAYERS; i++) {

				Player p = PokerModel.getPlayer(i);
				p.discardHand();
				for (int j = 0; j < Player.HAND_SIZE; j++) {
					Card card = deck.DealACard();
					p.addCard(card);
				}
				p.evaluateHand();

				PlayerPane pp = view.getPlayerPane(i);
				pp.updatePlayerDisplay();

			}

			int basePlayer = 0;
			for (int i = basePlayer + 1; i < PokerGame.NUM_PLAYERS; i++) {
				PlayerPane baseP = view.getPlayerPane(basePlayer);
				PlayerPane www = view.getPlayerPane(i);
				int win = PokerModel.getPlayer(basePlayer).compareTo(PokerModel.getPlayer(i));
				System.out.println(i + ":" + win);
				if (win ==1) {
					baseP.lblwin.setText("Winner");
					www.lblwin.setText("Loser");
				} else if (win == -1) {
					basePlayer = i;
						baseP.lblwin.setText("Loser");
						www.lblwin.setText("Winner");
						

				} else if (win == 0) {
					basePlayer = i;
					baseP.lblwin.setText("Split");
					www.lblwin.setText("Split");
				}

			}
		} else {

			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setHeaderText(null);
			alert.setContentText("Not enough cards - Get New Deck first and shuffle");
			alert.showAndWait();

		}

	}
}
