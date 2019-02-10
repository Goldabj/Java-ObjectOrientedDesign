package client;

public class CommandLoader extends ClassLoader {

	public CommandLoader() {
	}

	public CommandLoader(ClassLoader parent) {
		super(parent);
	}

	public Runnable loadCommand(CommandPacket packet) throws InstantiationException, IllegalAccessException {
		String className = packet.getClassName();
		byte[] classBytes = packet.getClassBytes();

		Class<? extends Runnable> clazz = (Class<? extends Runnable>) this.defineClass(className, classBytes, 0,
				classBytes.length);
		this.resolveClass(clazz);

		Runnable runnable = clazz.newInstance();
		return runnable;
	
	}

}
