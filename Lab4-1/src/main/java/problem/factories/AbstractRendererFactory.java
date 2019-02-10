package problem.factories;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import edu.rosehulman.csse374.wired.annotations.Autowired;
import edu.rosehulman.csse374.wired.core.AbstractFactory;
import problem.components.IComponent;
import problem.components.Label;
import problem.components.TextBox;
import problem.components.Window;
import problem.renderers.IRenderer;

public abstract class AbstractRendererFactory extends AbstractFactory {
	
	public AbstractRendererFactory() {
		super();
	}
	

}
