package problem.renderers;

import edu.rosehulman.csse374.wired.annotations.Autowired;
import problem.components.IComponent;

public abstract class AbstractRenderer implements IRenderer {
	private IComponent component;
	
	public AbstractRenderer() {
		super();
	}
	
	@Override
	public IComponent getComponent() {
		return this.component;
	}
	
	@Override
	public void setComponent(IComponent comp) {
		this.component = comp;
	}

}
