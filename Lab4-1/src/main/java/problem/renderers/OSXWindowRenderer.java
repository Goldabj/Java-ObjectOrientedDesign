package problem.renderers;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import problem.components.IComponent;
import problem.components.Window;


public class OSXWindowRenderer extends AbstractRenderer {

	public OSXWindowRenderer() {
		super();
	}

	@Override
	public void render(Graphics2D g) {
		g.setColor(Color.GREEN);
		g.draw3DRect(1, 1, this.getComponent().getBounds().width - Window.H_SPACE, this.getComponent().getBounds().height - Window.V_SPACE, true);

		// Draw the title bar
		g.setColor(Color.yellow);
		g.fill3DRect(1, 1, (int)this.getComponent().getBounds().width - Window.H_SPACE , Window.TITLE_HEIGHT, true);
		
		// Draw the title
		g.setFont(new Font("Arial", Font.PLAIN, 17)); 		
		g.setColor(Color.white);
		g.drawString(((Window) this.getComponent()).getTitle(), 5, 20);

	}

}
