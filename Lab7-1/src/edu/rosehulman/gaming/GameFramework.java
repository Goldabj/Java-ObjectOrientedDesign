package edu.rosehulman.gaming;

import java.io.IOException;
import java.util.HashMap;

import edu.rosehulman.client.wordguessing.WordGuessingGame;
import edu.rosehulman.numberguessing.HangmanGame;
import edu.rosehulman.numberguessing.NumberGuessingGame;

public class GameFramework {
	private HashMap<String, AbstractGame> games;
	
	public GameFramework() {
		this.games = new HashMap<>();
		this.games.put("numberguessing", new NumberGuessingGame());
		this.games.put("wordguessing", new WordGuessingGame(3));
		this.games.put("hangman", new HangmanGame());
	}
	
	public void play(String gameType) throws IOException {
		AbstractGame game = this.games.get(gameType);
		if (game != null) {
			game.launch();
		}
		else {
			System.err.println("Undefined game type.");
		}
	}
	
	public void addNewGame(String name, AbstractGame game) {
		this.games.put(name, game);
	}
}
