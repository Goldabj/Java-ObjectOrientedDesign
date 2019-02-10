package edu.rosehulman.gaming;

public abstract class AbstractGame {

	public AbstractGame() {
		
	}
	
	public void launch() {
		this.initialize();
		
		while(!this.isEndOfGame()) {
			this.makePlay();
		}
		this.showResult();
	}
	
	protected abstract void initialize();
	protected abstract void showResult();
	protected abstract void makePlay();
	protected abstract void readUsers();
	protected abstract boolean isEndOfGame();
	
	
	

}
