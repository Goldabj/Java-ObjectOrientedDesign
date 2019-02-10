package problem;

import java.util.Iterator;

import headfirst.command.undo.NoCommand;

//
// This is the invoker
//
public class RemoteControl {
	Command[] onCommands;
	Command[] offCommands;
	Command undoCommand;

	public RemoteControl() {
		onCommands = new Command[10];
		offCommands = new Command[10];

		Command noCommand = new NoCommand();
		for (int i = 0; i < 5; i++) {
			onCommands[i] = noCommand;
			offCommands[i] = noCommand;
		}
		// added this
		for (int i = 5; i < 10; i++) {
			onCommands[i] = new MacroCommand();
			offCommands[i] = new MacroCommand();
		}
		undoCommand = noCommand;
	}

	public void setCommand(int slot, Command onCommand, Command offCommand) {
		onCommands[slot] = onCommand;
		offCommands[slot] = offCommand;
	}

	public void onButtonWasPushed(int slot) {
		// Do not change this code.
		onCommands[slot].execute();
		undoCommand = onCommands[slot];
	}

	public void offButtonWasPushed(int slot) {
		// Do not change this code.
		offCommands[slot].execute();
		undoCommand = offCommands[slot];
	}

	public void addToMacro(int slot_to_add, int macro_slot) {
		if (macro_slot < 5 || macro_slot > 9) {
			System.err.println("this is not a macro slot. need to be slots 6-10");
			return;
		}

		Command onMacroCommand = onCommands[macro_slot];
		Command offMacroCommand = offCommands[macro_slot];
		Command onToAddCommand = onCommands[slot_to_add];
		Command offToAddCommand = offCommands[slot_to_add];

		onMacroCommand.addChildCommand(onToAddCommand);
		offMacroCommand.addChildCommand(offToAddCommand);

	}

	public void removeFromMacro(int slot_to_remove, int macro_slot) {
		if (macro_slot < 5 || macro_slot > 9) {
			System.err.println("this is not a macro slot. need to be slots 6-10");
			return;
		}

		Command onMacroCommand = onCommands[macro_slot];
		Command offMacroCommand = offCommands[macro_slot];
		Command onToAddCommand = onCommands[slot_to_remove];
		Command offToAddCommand = offCommands[slot_to_remove];

		
		// B part implementation
		//onMacroCommand.removeChildCommand(onToAddCommand);
		//offMacroCommand.removeChildCommand(offToAddCommand);
		
		// A part implementation
		Iterator<Command> onIter = onMacroCommand.iterator();
		while (onIter.hasNext()) {
			Command next = onIter.next();
			if (next.equals(onToAddCommand)) {
				onIter.remove();
			}
		}

		Iterator<Command> offIter = offMacroCommand.iterator();
		while (offIter.hasNext()) {
			Command next = offIter.next();
			if (next.equals(offToAddCommand)) {
				offIter.remove();
			}
		}

	}

	public void undoButtonWasPushed() {
		// Do not change this code.
		undoCommand.undo();
	}

	public String toString() {
		StringBuffer stringBuff = new StringBuffer();
		stringBuff.append("\n------ Remote Control -------\n");
		for (int i = 0; i < onCommands.length; i++) {
			stringBuff.append("[slot " + i + "] " + onCommands[i].getClass().getName() + "    "
					+ offCommands[i].getClass().getName() + "\n");
		}
		stringBuff.append("[undo] " + undoCommand.getClass().getName() + "\n");
		return stringBuff.toString();
	}
}
