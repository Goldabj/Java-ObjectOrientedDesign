package problem;

import java.util.Iterator;

public class NullIterator implements Iterator<Command> {

	public NullIterator() {
	}
	
	@Override
	public boolean hasNext() {
		return false;
	}

	@Override
	public Command next() {
		return null;
	}
	
	@Override
	public void remove() {
		// do nothing
	}

}
