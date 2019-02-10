package problem.client;

import java.util.Enumeration;
import java.util.Iterator;

public class IteratorToEnumAdapter<E> implements Enumeration<E> {
	Iterator<E> iter;

	public IteratorToEnumAdapter(Iterator<E> iter) {
		this.iter = iter;
	}

	@Override
	public boolean hasMoreElements() {
		return this.iter.hasNext();
	}

	@Override
	public E nextElement() {
		return this.iter.next();
	}

}
