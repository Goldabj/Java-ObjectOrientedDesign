package problem.sprites;

import java.awt.Dimension;
import java.awt.Shape;
import java.util.Iterator;

public abstract class AbstractSpriteComponent implements ISprite {

	public AbstractSpriteComponent() {
		// nothing
	}

	@Override
	public void move(Dimension space) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Shape getShape() {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public void addSprite(ISprite s) {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public void removeSprite(ISprite s) {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public Iterator<ISprite> getIterator() {
		throw new UnsupportedOperationException();
	}

}
