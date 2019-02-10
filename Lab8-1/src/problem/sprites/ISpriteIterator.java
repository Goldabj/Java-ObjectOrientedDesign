package problem.sprites;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class ISpriteIterator<E> implements Iterator<ISprite> {
	Stack<Iterator<ISprite>> stack = new Stack<>();
	   
	public ISpriteIterator(Iterator<ISprite> iterator) {
		stack.push(iterator);
	}
   
	public ISprite next() {
		if (hasNext()) {
			Iterator<ISprite> iterator = stack.peek();
			ISprite component = iterator.next();
			stack.push(component.getIterator());
			return component;
		} else {
			return null;
		}
	}
  
	public boolean hasNext() {
		if (stack.empty()) {
			return false;
		} else {
			Iterator<ISprite> iterator = stack.peek();
			if (!iterator.hasNext()) {
				stack.pop();
				return hasNext();
			} else {
				return true;
			}
		}
	}

}
