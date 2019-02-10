package problem;

import java.util.HashMap;
import java.util.Map;

/**
 * This class provides utility methods to run the application 
 * in either test or release mode.
 * 
 * In test mode, user can supply the default operating system
 * to get corresponding look and feel.
 *  
 * @author Chandan R. Rupakheti (chandan.rupakheti@rose-hulman.edu)
 */
public class Configuration {
	public static final String WINDOWS = "windows";
	public static final String LINUX = "ubuntu";
	public static final String OSX = "osx";
	
	private static boolean test = false;
	private static String defaultOS = LINUX;
	
	static Map<String, IRendererFactory> osToFactories = new HashMap<>();
	static {
		osToFactories.put(WINDOWS, new WindowsRendererFactory());
		osToFactories.put(LINUX, new LinuxRendererFactory());
		osToFactories.put(OSX, new OSXRendererFactory());
	}
	
	public static void setTestMode(boolean mode) {
		test = mode;
	}

	public static void setDefaultOS(String os) {
		defaultOS = os;
	}
	

	public static String getOS() {
		if(test)
			return defaultOS.toLowerCase();
		else
			return System.getProperty("os.name").toLowerCase();
	}
	
	public static IRendererFactory getRendererFactory() {
		return osToFactories.get(getOS());
	}
}
