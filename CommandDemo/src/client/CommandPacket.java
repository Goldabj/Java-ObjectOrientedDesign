package client;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;

public class CommandPacket implements Serializable{
	private static final long serialVersionUID = 5130471141985425576L;
	
	private byte[] classBytes;
	private String className;
	
	public CommandPacket() {
	}
	
	public void from(Class<?> clazz) throws IOException {
		this.className = clazz.getName();
		
		InputStream in = clazz.getResourceAsStream(clazz.getSimpleName() + ".class");
		
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		
		int aByte;
		while ((aByte = in.read()) != -1) {
			out.write(aByte);
		}
		
		this.classBytes = out.toByteArray();
	}
	
	public Runnable toCommand() throws InstantiationException, IllegalAccessException {
		CommandLoader loader = new CommandLoader();
		return loader.loadCommand(this);
	}

	public String getClassName() {
		return this.className;
	}
	
	public byte[] getClassBytes() {
		return this.classBytes;
	}

}
