package windowsRenderers;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import problem.AbstractRenderer;
import problem.IComponent;
import problem.Label;

public class WindowsLabelRenderer extends AbstractRenderer {

	public WindowsLabelRenderer(IComponent comp) {
		super(comp);
	}

	@Override
	public void render(Graphics2D g) {
		Rectangle bound = this.getComponent().getBounds();
		
		// Draw the title
		g.setFont(new Font("TimesRoman", Font.PLAIN, 12)); 		
		g.setColor(Color.black);
		g.drawString(((Label) this.getComponent()).getText(), bound.x + Label.H_SPACE, bound.y + 16);

	}

}
