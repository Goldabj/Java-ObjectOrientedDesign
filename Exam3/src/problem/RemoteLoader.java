package problem;

import headfirst.command.undo.CeilingFan;
import headfirst.command.undo.CeilingFanHighCommand;
import headfirst.command.undo.CeilingFanMediumCommand;
import headfirst.command.undo.CeilingFanOffCommand;
import headfirst.command.undo.Light;
import headfirst.command.undo.LightOffCommand;
import headfirst.command.undo.LightOnCommand;

public class RemoteLoader {

	public static void main(String[] args) {
		MacroMain();
		System.out.println("---------------- Regular main ----------------------------");
		RemoteControl remoteControl = new RemoteControl();

		Light livingRoomLight = new Light("Living Room");

		LightOnCommand livingRoomLightOn = new LightOnCommand(livingRoomLight);
		LightOffCommand livingRoomLightOff = new LightOffCommand(livingRoomLight);

		remoteControl.setCommand(0, livingRoomLightOn, livingRoomLightOff);

		remoteControl.onButtonWasPushed(0);
		remoteControl.offButtonWasPushed(0);
		System.out.println(remoteControl);
		remoteControl.undoButtonWasPushed();
		remoteControl.offButtonWasPushed(0);
		remoteControl.onButtonWasPushed(0);
		System.out.println(remoteControl);
		remoteControl.undoButtonWasPushed();

		CeilingFan ceilingFan = new CeilingFan("Living Room");

		CeilingFanMediumCommand ceilingFanMedium = new CeilingFanMediumCommand(ceilingFan);
		CeilingFanHighCommand ceilingFanHigh = new CeilingFanHighCommand(ceilingFan);
		CeilingFanOffCommand ceilingFanOff = new CeilingFanOffCommand(ceilingFan);

		remoteControl.setCommand(0, ceilingFanMedium, ceilingFanOff);
		remoteControl.setCommand(1, ceilingFanHigh, ceilingFanOff);

		remoteControl.onButtonWasPushed(0);
		remoteControl.offButtonWasPushed(0);
		System.out.println(remoteControl);
		remoteControl.undoButtonWasPushed();

		remoteControl.onButtonWasPushed(1);
		System.out.println(remoteControl);
		remoteControl.undoButtonWasPushed();
	}

	public static void MacroMain() {
		RemoteControl remoteControl = new RemoteControl();

		Light livingRoomLight = new Light("Living Room");

		LightOnCommand livingRoomLightOn = new LightOnCommand(livingRoomLight);
		LightOffCommand livingRoomLightOff = new LightOffCommand(livingRoomLight);

		remoteControl.setCommand(0, livingRoomLightOn, livingRoomLightOff);

		CeilingFan ceilingFan = new CeilingFan("Living Room");

		CeilingFanMediumCommand ceilingFanMedium = new CeilingFanMediumCommand(ceilingFan);
		CeilingFanOffCommand ceilingFanOff = new CeilingFanOffCommand(ceilingFan);

		remoteControl.setCommand(1, ceilingFanMedium, ceilingFanOff);

		// adding macro command tests
		remoteControl.addToMacro(1, 5);
		remoteControl.addToMacro(0, 5);
		
		remoteControl.addToMacro(5, 6);

		// pushing macro commands
		remoteControl.onButtonWasPushed(5);
		System.out.println(remoteControl);
		remoteControl.offButtonWasPushed(5);
		System.out.println(remoteControl);

		remoteControl.onButtonWasPushed(6);
		System.out.println(remoteControl);
		remoteControl.offButtonWasPushed(6);
		System.out.println(remoteControl);

		// removing from macro command
		remoteControl.removeFromMacro(0, 6);
		remoteControl.onButtonWasPushed(6);
		System.out.println(remoteControl);
		remoteControl.removeFromMacro(0, 5);
		remoteControl.onButtonWasPushed(5);
		System.out.println(remoteControl);
	}

}
