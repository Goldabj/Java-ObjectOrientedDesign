package linuxRenderers;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

import problem.AbstractRenderer;
import problem.IComponent;
import problem.TextBox;

public class LinuxTextBoxRenderer extends AbstractRenderer {

	public LinuxTextBoxRenderer(IComponent comp) {
		super(comp);
	}

	@Override
	public void render(Graphics2D g) {
		Rectangle bound = this.getComponent().getBounds();
		
		
		// Draw the boarder after setting the thickness
		g.setColor(new Color(48,0,0));
		Rectangle2D border = new Rectangle2D.Float(bound.x, bound.y, bound.width, bound.height);
		g.setStroke(new BasicStroke(5));
		g.draw(border);
		
		// Draw the white fill
		g.setColor(Color.white);
		Rectangle2D fill = new Rectangle2D.Float(bound.x+2, bound.y+2, bound.width-2, bound.height-2);
		g.fill(fill);;
		
		// Draw the Fill
		g.setFont(new Font("Arial", Font.PLAIN, 12)); 		
		g.setColor(Color.black);
		g.drawString(((TextBox) this.getComponent()).getText(), bound.x + TextBox.H_SPACE, bound.y + 16);

	}

}
