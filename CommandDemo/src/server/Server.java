package server;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

import client.CommandPacket;
import client.PrintCommand;

public class Server {

	public static void main(String... strings) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		@SuppressWarnings("resource")
		ServerSocket server = new ServerSocket(3838);
		
		System.setSecurityManager(new SecurityManager(){
			
		
		});
		
		while(true) {
			Socket socket = server.accept();
			InputStream in = socket.getInputStream();
			ObjectInputStream objectIn = new ObjectInputStream(in);
			
			CommandPacket packet = (CommandPacket) objectIn.readObject();
			Runnable command = packet.toCommand();
			command.run();
		}
	}

}
