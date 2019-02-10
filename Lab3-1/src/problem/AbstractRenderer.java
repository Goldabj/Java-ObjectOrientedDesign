package problem;

public abstract class AbstractRenderer implements IRenderer {
	private IComponent component;
	
	
	public AbstractRenderer(IComponent comp) {
		this.component = comp;
	}
	
	@Override
	public IComponent getComponent() {
		return this.component;
	}

}
