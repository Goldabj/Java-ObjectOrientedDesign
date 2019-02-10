package solution;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class ApplicationLauncher implements IApplicationLauncher {
	
	private static HashMap<String, ProcessRunner> runners = new HashMap<>();
	static {
		runners.put("txt", new DataFileRunner());
		runners.put("html", new ExecutableFileRunner());
	}
		

	@Override
	public void directoryChanged(DirectoryEvent e) {
		if (!e.getEventType().equals("ENTRY_CREATE")) {
			return;
		}
		String path = e.getFile().toAbsolutePath().toString();
		String[] pathSplit = path.split("\\.");
		String extension = pathSplit[pathSplit.length - 1];
		ProcessRunner runner = null;
		for (String key : runners.keySet()) {
			if (key.equals(extension)) {
				runner = runners.get(key);
				System.out.println("Running " + runner.getCommand() +  " with "+ e.getFile());
				runner.execute(e.getFile());
			}
		}
		if (runner == null) {
			System.err.println("system does not support launching this file type");
		}

	}

	@Override
	public void shutDown() {
		for(ProcessRunner runner : runners.values()) {
			for (Process process : runner.getProcesses()) {
				process.destroy();
			}
		}

	}

	@Override
	public Collection<ProcessRunner> getRunners() {
		return runners.values();
	}

	@Override
	public void addRunner(String extension, ProcessRunner runner) {
		runners.put(extension, runner);
		
	}

	public int getApplicationsCount() {
		int count = 0;
		for (ProcessRunner runner : runners.values()) {
			List<Process> process = runner.getProcesses();
			count+=process.size();
		}
		return count;
	}
	
	

}
