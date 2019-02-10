package problem;

import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Test;

import solution.ApplicationLauncher;
import solution.DirectoryMonitorService;

public class AppLauncherBaseCaseTest {
	@Test
	public final void testStart() throws IOException, InterruptedException {
			
		// Register directory to the launcher
		Path dir = Paths.get("./input_output");
		DirectoryMonitorService service = new DirectoryMonitorService(dir);
		ApplicationLauncher appLauncher = new ApplicationLauncher();
		service.addListener(appLauncher);
		
		service.start();

		// Sleep a little
		Thread.sleep(500);
		
		// Check it if is running
		assertEquals("The launcher did not run in normal configuration!", true, service.isRunning());
		
		// Check that the base case for process is also ok
		assertEquals("Unexpected number of processes running!", 0, appLauncher.getApplicationsCount());
		
		service.stopGracefully();
		
		// Check it if is running
		assertEquals("The launcher did not gracefully stop!", false, service.isRunning());
	}
}
