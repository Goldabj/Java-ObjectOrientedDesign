package problem;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MacroCommand implements Command{
	private List<Command> childCommands;
	
	public MacroCommand() {
		this.childCommands = new ArrayList<>();
	}

	@Override
	public void execute() {
		for (Command c : this.childCommands) {
			c.execute();
		}
	}

	@Override
	public void undo() {
		for (Command c : this.childCommands) {
			c.undo();
		}
	}

	@Override
	public void addChildCommand(Command child) {
		this.childCommands.add(child);
	}

	@Override
	public void removeChildCommand(Command child) {
		// Internally removing the child 
		Iterator<Command> iter = this.childCommands.iterator();
		while (iter.hasNext()) {
			Command nextC = iter.next();
			if(nextC.equals(child)) {
				iter.remove();
			}else if (nextC instanceof MacroCommand) {
				nextC.removeChildCommand(child); // internally removing from child macro
			}
		}
	}
	
	@Override
	public Iterator<Command> iterator() {
		return new MacroCommandIterator(this.childCommands.iterator());
	}
	
	

}
