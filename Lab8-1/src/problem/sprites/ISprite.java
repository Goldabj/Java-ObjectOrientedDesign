package problem.sprites;

import java.awt.Dimension;
import java.awt.Shape;
import java.util.Iterator;

public interface ISprite {
	public void move(Dimension space);
	public Shape getShape();
	public void addSprite(ISprite s);
	public void removeSprite(ISprite s);
	public Iterator getIterator();
}
