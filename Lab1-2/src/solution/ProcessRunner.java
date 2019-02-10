package solution;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public abstract class ProcessRunner {
	
	protected List<Process> processes;
	private String command;
	
	public ProcessRunner(String cmd) {
		this.command = cmd; 
		this.processes = new ArrayList<>();
	}
	
	public List<Process> getProcesses() {
		return this.processes;
	}
	
	public String getCommand() {
		return this.command;
	}
	
	public void addProcess(Process p) {
		this.processes.add(p);
	}
	
	public abstract void execute(Path p);
	

}
