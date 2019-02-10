package problem.sprites;

import java.awt.Dimension;

public class FanSprite extends ComplexSprite {

	public FanSprite(double x, double y, double width, double height) {
		super(x, y, width, height);
		this.addSprite(new CircleSprite(x, y, width, height));
		this.addSprite(new RectangleSprite(x+ width, y, width, height));
		this.addSprite(new RectangleSprite(x-width, y, width, height));
	}
	
	@Override
	public void move(Dimension d) {
		for (ISprite s : this.getSprites()) {
			s.move(d);
		}
	}
	

}
