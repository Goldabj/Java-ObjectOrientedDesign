package problem.factories;

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
	public static final String WINDOWS = "Windows";
	public static final String LINUX = "Linux";
	public static final String OSX = "OSX";
	
	private static boolean test = true;
	private static String defaultOS = LINUX;
	private static Configuration instance; 
	
	
	public static Configuration getInstance() {
		if (instance == null) {
			instance = new Configuration();
		}
		return instance;
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
}
