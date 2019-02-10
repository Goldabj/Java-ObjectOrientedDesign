package client;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket socket = new Socket("137.112.46.96", 3838);
		OutputStream out = socket.getOutputStream();
		ObjectOutputStream objectOut = new ObjectOutputStream(out);
		
		System.out.println("Sending print command");
		CommandPacket packet = new CommandPacket();
		packet.from(PrintCommand.class);
		objectOut.writeObject(packet);
		socket.close();

	}

}
