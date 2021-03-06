package problem.renderers;

import java.awt.Graphics2D;

import problem.components.IComponent;

public interface IRenderer {
	public void render(Graphics2D g2);
	public IComponent getComponent();
	void setComponent(IComponent comp);
}
