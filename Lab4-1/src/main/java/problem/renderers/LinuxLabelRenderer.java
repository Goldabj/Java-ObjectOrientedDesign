package problem.renderers;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import problem.components.IComponent;
import problem.components.Label;


public class LinuxLabelRenderer extends AbstractRenderer {

	public LinuxLabelRenderer() {
		super();
	}

	@Override
	public void render(Graphics2D g) {
		Rectangle bound = this.getComponent().getBounds();

		// Draw the title
		g.setFont(new Font("Arial", Font.PLAIN, 14));
		g.setColor(Color.black);
		g.drawString(((Label) this.getComponent()).getText(), bound.x + Label.H_SPACE, bound.y + 16);

	}

}
