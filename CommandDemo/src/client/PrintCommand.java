package client;

import java.io.Serializable;

public class PrintCommand implements Runnable, Serializable {
	private static final long serialVersionUID = -5555L;
	
	private String message;

	public PrintCommand() {
		this.message = "Crash:";
	}

	@Override
	public void run() {
		
	}

}
