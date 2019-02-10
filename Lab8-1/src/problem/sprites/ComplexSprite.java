package problem.sprites;

import java.awt.Dimension;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import headfirst.designpatterns.composite.menuiterator.CompositeIterator;

class ComplexSprite extends AbstractSpriteComponent {
	private List<ISprite> sprites;
	protected double dx;
	protected double dy;
	protected SpriteFactory factory;
	private Iterator<ISprite> iterator = null;

	// Subclasses need to chain this constructor
	public ComplexSprite(double x, double y, double width, double height) {
		this.factory = SpriteFactory.getInstance();
		this.dx = factory.getDX();
		this.dy = factory.getDY();
		this.sprites = new ArrayList<>();
	}

	@Override
	public void addSprite(ISprite s) {
		this.sprites.add(s);
	}

	@Override
	public void removeSprite(ISprite s) {
		this.sprites.remove(s);
	}

	@Override
	public Iterator<ISprite> getIterator() {
		iterator = new ISpriteIterator<ISprite>((Iterator<ISprite>) this.sprites.iterator());
		return iterator;
	}

	public List<ISprite> getSprites() {
		return this.sprites;
	}

}
