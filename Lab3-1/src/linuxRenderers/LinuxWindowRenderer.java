package linuxRenderers;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import problem.AbstractRenderer;
import problem.IComponent;
import problem.Window;

public class LinuxWindowRenderer extends AbstractRenderer {

	public LinuxWindowRenderer(IComponent comp) {
		super(comp);
	}

	@Override
	public void render(Graphics2D g) {
		// Draw the border
				g.setColor(new Color(48,0,0));
				g.draw3DRect(1, 1, this.getComponent().getBounds().width - Window.H_SPACE, this.getComponent().getBounds().height - Window.V_SPACE, true);

				// Draw the title bar
				g.setColor(new Color(96,0,0));
				g.fill3DRect(1, 1, (int)this.getComponent().getBounds().width - Window.H_SPACE , Window.TITLE_HEIGHT, true);
				
				// Draw the title
				g.setFont(new Font("Arial", Font.PLAIN, 17)); 		
				g.setColor(Color.white);
				g.drawString(((Window) this.getComponent()).getTitle(), 5, 20);

	}

}
