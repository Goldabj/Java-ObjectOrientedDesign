package windowsRenderers;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import problem.AbstractRenderer;
import problem.IComponent;
import problem.Window;

public class WindowsWindowRenderer extends AbstractRenderer {

	public WindowsWindowRenderer(IComponent comp) {
		super(comp);
	}

	@Override
	public void render(Graphics2D g) {
		// Draw the border
		g.setColor(Color.gray);
		g.draw3DRect(1, 1, this.getComponent().getBounds().width - Window.H_SPACE, (int) this.getComponent().getBounds().height - Window.V_SPACE, true);

		// Draw the title bar
		g.setColor(new Color(49, 68, 176));
		g.fill3DRect(1, 1, this.getComponent().getBounds().width - Window.H_SPACE, Window.TITLE_HEIGHT - 5, true);

		// Draw the title
		g.setFont(new Font("TimesRoman", Font.PLAIN, 15));
		g.setColor(Color.white);
		g.drawString(((Window) this.getComponent()).getTitle(), 5, 17);

	}

}
