package solution;

import java.io.IOException;
import java.nio.file.Path;

public interface IDirectoryMonitorService {
	
	public Path getDirectory();
	public boolean isRunning();
	public void stopGracefully() throws IOException;
	public void addListener(IDirectoryListener l);
	public void removeListener(IDirectoryListener l);
	public void notifyListener(DirectoryEvent e);

}
