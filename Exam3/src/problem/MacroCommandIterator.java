package problem;

import java.util.Iterator;
import java.util.Stack;

public class MacroCommandIterator implements Iterator<Command> {
	Stack<Iterator<Command>> stack;
	Iterator<Command> current = null;
	
	public MacroCommandIterator(Iterator<Command> iter) {
		stack = new Stack<>();
		stack.push(iter);
	}

	@Override
	public boolean hasNext() {
		if(stack.isEmpty()) {
			return false;
		}
		Iterator<Command> iter = stack.peek();
		if (iter.hasNext()) {
			return true;
		}
		stack.pop();
		return hasNext();
		
	}

	@Override
	public Command next() {
		if(!hasNext()) {
			return null;
		}
		Iterator<Command> iter = stack.peek();
		Command next = null;
		if (iter.hasNext()) {
			this.current = iter;
			next = iter.next();
			stack.push(next.iterator());
		}else {
			stack.pop();
			return next();
		}
		return next;
	}
	
	@Override 
	public void remove() {
		if (current == null) {
			return;
		}
		current.remove();
	}

}
