package solution;

import static java.nio.file.StandardWatchEventKinds.ENTRY_CREATE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_DELETE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_MODIFY;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DirectoryMonitorService extends Thread implements IDirectoryMonitorService {
	private Path dir;
	private boolean isRunning;
	private List<IDirectoryListener> listeners;
	private WatchService watcher;
	
	
	public DirectoryMonitorService(Path directory) throws IOException {
		this.dir = directory;
		this.isRunning = false;
		this.listeners = new ArrayList<>();
		this.watcher = FileSystems.getDefault().newWatchService();
		dir.register(watcher, ENTRY_CREATE, ENTRY_DELETE, ENTRY_MODIFY);
	}

	@Override
	public Path getDirectory() {
		return this.dir;
	}

	@Override
	public boolean isRunning() {
		return this.isRunning;
	}

	@Override
	public void stopGracefully() throws IOException {
		this.listeners = new ArrayList<>();
		
		this.isRunning = false;
		File file = new File(dir.toFile() + "/.temp");

		// Let's force the while loop in the run method to come out of the
		// blocking watcher.take() call here
		// You can also create a directory by calling file.mkdir()
		file.createNewFile();
	}

	@Override
	public void addListener(IDirectoryListener l) {
		this.listeners.add(l);

	}

	@Override
	public void removeListener(IDirectoryListener l) {
		this.listeners.remove(l);

	}

	@Override
	public void notifyListener(DirectoryEvent e) {
		for (IDirectoryListener listener : this.listeners) {
			listener.directoryChanged(e);
		}
		
	}
	
	@Override 
	public void run() {
		this.isRunning = true;
		while(isRunning) {
			// Wait for key to be signalled
			WatchKey key;
			try {
				key = watcher.take();
			} catch (InterruptedException x) {
				return;
			}

			// Context for directory entry event is the file name of entry
			List<WatchEvent<?>> events = key.pollEvents();
			if(!events.isEmpty()) {
				@SuppressWarnings("unchecked")
				WatchEvent<Path> event = (WatchEvent<Path>)events.get(0);
				Path name = event.context();
				Path child = dir.resolve(name);

				// Call the handler method
				notifyListener(new DirectoryEvent(child, event.kind().name(), this));
			}

			// Reset key and remove from set if directory no longer accessible
			if (!key.reset()) {
				break;
			}
		}

		File file = new File(dir.toFile() + "/.temp");
		file.delete();
	}

}
