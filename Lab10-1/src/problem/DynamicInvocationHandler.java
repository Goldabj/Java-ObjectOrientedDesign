package problem;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DynamicInvocationHandler implements InvocationHandler {
	private UniversalObject obj;
	Class interfaze;

	public DynamicInvocationHandler(Class interfaze) {
		this.obj = new UniversalObject();
		this.interfaze = interfaze;
		setUniversalObject(interfaze);
		
	}
	
	private void setUniversalObject(Class interfaze) {
		// This method just sets the fields names, and give the objects generic value types
		Method[] mets = interfaze.getMethods();
		for (int i = 0; i < mets.length; i++) {
			if (mets[i].getName().startsWith("get")) {
				String fName = mets[i].getName().substring(3).toLowerCase();
				Class<?> valueType = mets[i].getReturnType();
				Object value = null;
				try {
					value = valueType.newInstance();
				} catch (InstantiationException | IllegalAccessException e) {
					value = null;
				}				
				obj.set(fName, value);
			}
			
		}
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object value = null;
		if (method.getName().startsWith("get")) {
			String fName = method.getName().substring(3).toLowerCase();
			value = obj.get(fName); 
			return value;
		} else if (method.getName().startsWith("set")) {
			String fName = method.getName().substring(3).toLowerCase();
			obj.set(fName, args[0]);
			return null;
		} else if (method.getName().startsWith("add")) {
			int index = method.getName().toLowerCase().indexOf("to");
			String fName = method.getName().substring(index+2).toLowerCase();
			obj.addTo(fName, args[0]);
			return null;
		} else if (method.getName().startsWith("increment")) {
			String fName = method.getName().substring(9).toLowerCase();
			obj.increment(fName);
			return null;
		} else if (method.getName().equals("toString")) {
			value = obj.toString(interfaze);
			return value;
		} // else
		throw new UnsupportedOperationException();

	}

}
