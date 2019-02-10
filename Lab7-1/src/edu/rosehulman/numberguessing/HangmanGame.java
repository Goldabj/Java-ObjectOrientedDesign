package edu.rosehulman.numberguessing;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import edu.rosehulman.gaming.AbstractGame;

public class HangmanGame extends AbstractGame {
	private final int maxTurns = 5;
	private boolean isEndOfGame;
	private int currentTurn;
	private String user;
	private String word;
	private Scanner scan;
	private StringBuffer currentWord;
	private List<String> guesses;
	private final String possibleWords[] = new String[]{"dog", "mouse", "horse", "hangman", "trump", "elephant", "hourglass"};

	public HangmanGame() {
		this.scan = new Scanner(System.in);
	}

	@Override
	protected void initialize() {
		this.currentTurn = 0;
		this.guesses = new ArrayList<>();
		this.isEndOfGame = false;
		this.word = possibleWords[new Random().nextInt(possibleWords.length)];
		this.currentWord = new StringBuffer();
		for (int i = 0; i< this.word.length(); i++) {
			this.currentWord.append("_ ");
		}
		System.out.println("Welcome to Hangman!");
		System.out.println(this.currentWord);
	}

	@Override
	protected void showResult() {
		if(this.currentWord.toString().equals(this.word)) {
			System.out.println("Congrats you won " + this.user);
		}else {
			System.out.println("Sorry, you lose " + this.user);
		}

	}

	@Override
	protected void makePlay() {
		System.out.println("make a guess:");
		String guess = this.scan.next();
		guess = guess.toLowerCase();
		char character = guess.charAt(0);
		String cGuess = guess.substring(0, 1);
		
		if (this.guesses.contains(cGuess)) {
			System.out.println("you already tried that: try again");
			makePlay();
			return;
		}else {
			this.guesses.add(cGuess);
		}
		
		if (this.word.contains(cGuess)) {
			StringBuffer newWord = new StringBuffer();
			for (int i = 0; i < this.word.length(); i++) {
				if (this.word.charAt(i) == character) {
					newWord.append(cGuess + " ");
				}else {
					newWord.append(this.currentWord.subSequence(2*i, 2*i+2));
				}
			}
			this.currentWord = newWord;
			System.out.println("Congrats that works");
		}else {
			this.currentTurn++;
			System.out.println("Sorry that character is not in their");
		}
		System.out.println(this.currentWord);
		
		if (this.currentWord.toString().equals(this.word)) {
			this.isEndOfGame = true;
		}		
		
		if(this.currentTurn == this.maxTurns) {
			this.isEndOfGame = true;
		}

	}

	@Override
	protected void readUsers() {
		System.out.println("Enter user's name: ");
		this.user = this.scan.nextLine();
	}

	@Override
	protected boolean isEndOfGame() {
		return this.isEndOfGame;
	}

}
