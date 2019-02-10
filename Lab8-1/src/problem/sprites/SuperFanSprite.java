package problem.sprites;

import java.awt.Dimension;

public class SuperFanSprite extends ComplexSprite {

	public SuperFanSprite(double x, double y, double width, double height) {
		super(x, y, width, height);
		this.addSprite(new FanSprite(x, y, width, height));
		this.addSprite(new FanSprite(x+ width, y+height, width, height));
	}
	
	@Override
	public void move(Dimension d) {
		for (ISprite s: this.getSprites()) {
			s.move(d);
		}
	}

}
