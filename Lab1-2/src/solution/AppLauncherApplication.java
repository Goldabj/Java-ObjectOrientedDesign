package solution;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class AppLauncherApplication {

	public static void main(String[] args) throws IOException {
		Path dir = Paths.get("./input_output");
		DirectoryMonitorService service = new DirectoryMonitorService(dir);
		ApplicationLauncher appLauncher = new ApplicationLauncher();
		service.addListener(new DirectoryChangeLogger());
		service.addListener(appLauncher);
		
		service.start();

		System.out.format("Launcher started watching %s ...%nPress the return key to stop ...\n", dir);

		// Wait for an input
		try {
			System.in.read();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		try {
			service.stopGracefully();
			service.join();
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Directory watching stopped ...\n");		

	}

}
