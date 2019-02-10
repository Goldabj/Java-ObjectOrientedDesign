package problem.renderers;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import problem.components.IComponent;
import problem.components.Label;


public class OSXLabelRenderer extends AbstractRenderer {

	public OSXLabelRenderer() {
		super();
	}

	@Override
	public void render(Graphics2D g) {
		Rectangle bound = this.getComponent().getBounds();

		// Draw the title
		g.setFont(new Font("Arial", Font.BOLD, 14));
		g.setColor(Color.black);
		g.drawString(((Label) this.getComponent()).getText(), bound.x + Label.H_SPACE, bound.y + 16);

	}

}
