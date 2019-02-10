package problem;

import java.lang.reflect.Proxy;

public class UniversalObjectFactory {
	/**
	 * Generates implementation of all getter, setters, numerical incrementers, and collection appenders 
	 * for the specified interface.
	 * 
	 * @param <T> The type of interface whose concrete class needs to be created.
	 * @param interfaze The interface to implement. See the assignment spec.
	 * @return Returns an instance of the newly created class.
	 */
	@SuppressWarnings("unchecked")
	public static <T> T create(Class<T> interfaze){		
		if (!interfaze.isInterface()) {
			System.err.println("Error: create method takes and interface");
			return null;
		}
		
		return (T) Proxy.newProxyInstance(interfaze.getClassLoader(), new Class[] { interfaze }, new DynamicInvocationHandler(interfaze));
	}
}
