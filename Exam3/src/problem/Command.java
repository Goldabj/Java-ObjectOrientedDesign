package problem;

import java.util.Iterator;

public interface Command {
	// Preserve these method signatures.
	public void execute();
	public void undo();
	// Add methods with default implementations below as needed.
	
	public default void addChildCommand(Command  child) {
		throw new UnsupportedOperationException();
	}
	
	public default void removeChildCommand(Command child) {
		throw new UnsupportedOperationException();
	}
	
	// A part iterator
	public default Iterator<Command> iterator() {
		return new NullIterator();
	}
}
