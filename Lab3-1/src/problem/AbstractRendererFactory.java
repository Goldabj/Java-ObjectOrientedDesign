package problem;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractRendererFactory implements IRendererFactory {
	private Map<Class<IRenderer>, Class> componenetToRenderer;
	
	
	public AbstractRendererFactory() {
		this.componenetToRenderer = new HashMap<>();
	}
	
	protected void addRenderer(Class comp, Class renderer) {
		this.componenetToRenderer.put(comp, renderer);
	}
	
	@Override
	public IRenderer createRenderer(IComponent comp) {
		Class<IRenderer> rendClass = this.componenetToRenderer.get(comp.getClass());
		Constructor rendConstructor = null;
		IRenderer renderer = null;
		try {
			rendConstructor = rendClass.getDeclaredConstructor(IComponent.class);
			renderer = (IRenderer) rendConstructor.newInstance(comp);
		} catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
		
			e.printStackTrace();
		}
		return renderer;
		
	}
	
	protected abstract void populate();
	
	

}
