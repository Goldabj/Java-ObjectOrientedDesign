package solution;

import java.nio.file.Path;

public class DirectoryEvent {
	private Path file;
	private String event;
	private IDirectoryMonitorService service;
	
	public DirectoryEvent(Path fileName, String eventName, IDirectoryMonitorService serviceName) {
		this.file = fileName;
		this.event = eventName;
		this.service = serviceName;
	}

	public String getEventType() {
		return this.event;
	}
	
	public Path getFile() {
		return this.file;
	}
	
	public IDirectoryMonitorService getSource() {
		return this.service;
	}
}
