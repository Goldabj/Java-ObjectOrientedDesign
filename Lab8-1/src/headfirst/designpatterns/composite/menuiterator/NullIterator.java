package headfirst.designpatterns.composite.menuiterator;
 
import java.util.Iterator;

import problem.sprites.ISprite;
  
public class NullIterator implements Iterator<ISprite> {
   
	public ISprite next() {
		return null;
	}
  
	public boolean hasNext() {
		return false;
	}
   
	/*
	 * No longer needed as of Java 8
	 * 
	 * (non-Javadoc)
	 * @see java.util.Iterator#remove()
	 * 
	public void remove() {
		throw new UnsupportedOperationException();
	}
	*/
}
