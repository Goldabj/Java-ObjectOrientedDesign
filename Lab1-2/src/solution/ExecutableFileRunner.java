package solution;

import java.io.IOException;
import java.nio.file.Path;

public class ExecutableFileRunner extends ProcessRunner {

	public ExecutableFileRunner() {
		super("explorer");
		
	}

	@Override
	public void execute(Path p) {
		String command = getCommand();
		String file = p.toAbsolutePath().toString();
		System.out.println("Processing" + file);
		
		ProcessBuilder builder = new ProcessBuilder(command, file);
		try {
			Process process = builder.start();
			addProcess(process);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
