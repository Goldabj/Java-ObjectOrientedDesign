package edu.rosehulman.client.wordguessing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Random;
import java.util.Scanner;

import edu.rosehulman.gaming.AbstractGame;

public class WordGuessingGame extends AbstractGame {
	private boolean isEndOfGame;
	private int winner;
	private int users;
	private int currentUser;
	
	private int maxAttempts;
	private int[] userAttempts;
	
	private String plainTextWord;
	private String maskedWord;
	
	private Scanner scanner;
	
	
	public WordGuessingGame(int maxAttempts) {
		this.winner = -1;
		scanner = new Scanner(System.in);
		this.maxAttempts = maxAttempts;
	}
	
	@Override
	protected void readUsers() {
		System.out.println("Enter how many players: ");
		this.users = Integer.parseInt(scanner.nextLine());
	}
	
	private void retrieveWordOnline() throws IOException {
		URL url = new URL("http://randomword.setgetgo.com/get.php");
		InputStream inStream = url.openStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(inStream));
		this.plainTextWord = reader.readLine().toLowerCase();
		reader.close();
	}
	
	private void codify() {
		StringBuffer buffer = new StringBuffer();
		buffer.append(this.plainTextWord.charAt(0));
		Random random = new Random();
		for(int i = 1; i < this.plainTextWord.length(); ++i) {
			if(random.nextBoolean()) 
				buffer.append(this.plainTextWord.charAt(i));
			else
				buffer.append('_');
		}
		this.maskedWord = buffer.toString();
	}
	
	@Override
	protected void initialize() {
		this.isEndOfGame = false;
		System.out.println("Welcome to the Word Guessing game!");
		this.readUsers();
		try {
			this.retrieveWordOnline();
		} catch (IOException e) {
			System.err.println("Could not load new Word");
			e.printStackTrace();
		}
		this.codify();

		this.currentUser = 1;
		this.userAttempts = new int[this.users];
	}

	@Override
	protected void makePlay() {
		int user = (this.currentUser++ % this.users);
		int attempt = this.userAttempts[user];
		
		System.out.println("Here is the partly completed word: " + this.maskedWord);
		System.out.format("[User %d, Guess %d of %d]%nWhat is the word? ", user, ++attempt, this.maxAttempts);
		String option = scanner.nextLine();
		option = option.toLowerCase();
		
		this.userAttempts[user] = attempt;
		
		if (this.userAttempts[user] >= this.maxAttempts) {
			this.isEndOfGame = true;
		}
		
		if(option.equals(this.plainTextWord)) {
			this.winner = user;
			this.isEndOfGame = true;
		}
		else {
			System.out.println("Not quite right!");
		}

		System.out.println();
	}
	
	@Override
	protected void showResult() {
		if(this.winner >= 0) {
			System.out.println("Well done, User" + this.winner + "!");
		}
		else {
			System.out.println("Oops, nobody won! The correct answer is: " + this.plainTextWord);
		}
	}

	@Override
	protected boolean isEndOfGame() {
		return this.isEndOfGame;
	}
}
