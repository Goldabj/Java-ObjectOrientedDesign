package problem;

import java.awt.Graphics2D;

public interface IRenderer {
	public void render(Graphics2D g2);
	public IComponent getComponent();
}
