package problem.client;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Spliterator;
import java.util.Vector;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class ArrayListToVectorAdapter<E> extends Vector<E> {
	private static final long serialVersionUID = 1L;
	private ArrayList<E> underlying;
	
	public ArrayListToVectorAdapter(ArrayList<E> arr) {
		this.underlying = arr;
		
	}

	@Override
	public synchronized void copyInto(Object[] anArray) {
		Object[] array = this.underlying.toArray();
		anArray = array;
	}

	@Override
	public synchronized void trimToSize() {
		this.underlying.trimToSize();
	}

	@Override
	public synchronized void ensureCapacity(int minCapacity) {
		this.underlying.ensureCapacity(minCapacity);
	}

	@Override
	public synchronized void setSize(int newSize) {
		// Do nothing
	}

	@Override
	public synchronized int capacity() {
		return this.underlying.size();
	}

	@Override
	public synchronized int size() {
		return this.underlying.size();
	}

	@Override
	public synchronized boolean isEmpty() {
		return this.underlying.isEmpty();
	}

	@Override
	public Enumeration<E> elements() {
		Iterator<E> iter = this.underlying.iterator();
		Enumeration<E> enumer = new IteratorToEnumAdapter(iter);
		return enumer;
	}

	@Override
	public boolean contains(Object o) {
		return this.underlying.contains(o);
	}

	@Override
	public int indexOf(Object o) {
		return this.underlying.indexOf(o);
	}

	@Override
	public synchronized int indexOf(Object o, int index) {
		ArrayList<E> ar = new ArrayList<>();
		for(int i = index; i < this.size(); i++) {
			ar.add(this.get(i));
		}
		int dex = ar.indexOf(o);
		return (dex == -1) ? dex : dex + index;
	}

	@Override
	public synchronized int lastIndexOf(Object o) {
		return this.underlying.lastIndexOf(o);
	}

	@Override
	public synchronized int lastIndexOf(Object o, int index) {
		ArrayList<E> ar = new ArrayList<>();
		for(int i = index; i < this.size(); i++) {
			ar.add(this.get(i));
		}
		int dex = ar.lastIndexOf(o);
		return (dex == -1) ? dex : dex + index;
	}

	@Override
	public synchronized E elementAt(int index) {
		return this.underlying.get(index);
	}

	@Override
	public synchronized E firstElement() {
		return this.underlying.get(0);
	}

	@Override
	public synchronized E lastElement() {
		return this.underlying.get(this.size() - 1);
	}

	@Override
	public synchronized void setElementAt(E obj, int index) {
		this.underlying.set(index, obj);
	}

	@Override
	public synchronized void removeElementAt(int index) {
		this.underlying.remove(index);
	}

	@Override
	public synchronized void insertElementAt(E obj, int index) {
		this.underlying.add(index, obj);
	}

	@Override
	public synchronized void addElement(E obj) {
		this.underlying.add(obj);
	}

	@Override
	public synchronized boolean removeElement(Object obj) {
		return this.underlying.remove(obj);
	}

	@Override
	public synchronized void removeAllElements() {
		this.underlying = new ArrayList<>();
	}

	@Override
	public synchronized Object clone() {
		return this.underlying.clone();
	}

	@Override
	public synchronized Object[] toArray() {
		return this.underlying.toArray();
	}

	@Override
	public synchronized <T> T[] toArray(T[] a) {
		return this.underlying.toArray(a);
	}

	@Override
	public synchronized E get(int index) {
		return this.underlying.get(index);
	}

	@Override
	public synchronized E set(int index, E element) {
		return this.underlying.set(index, element);
	}

	@Override
	public synchronized boolean add(E e) {
		return this.underlying.add(e);
	}

	@Override
	public boolean remove(Object o) {
		return this.underlying.remove(o);
	}

	@Override
	public void add(int index, E element) {
		this.underlying.add(index, element);
	}

	@Override
	public synchronized E remove(int index) {
		return this.underlying.remove(index);
	}

	@Override
	public void clear() {
		this.underlying.clear();
	}

	@Override
	public synchronized boolean containsAll(Collection<?> c) {
		return this.underlying.containsAll(c);
	}

	@Override
	public synchronized boolean addAll(Collection<? extends E> c) {
		return this.underlying.addAll(c);
	}

	@Override
	public synchronized boolean removeAll(Collection<?> c) {
		return this.underlying.removeAll(c);
	}

	@Override
	public synchronized boolean retainAll(Collection<?> c) {
		return this.underlying.retainAll(c);
	}

	@Override
	public synchronized boolean addAll(int index, Collection<? extends E> c) {
		return this.underlying.addAll(index, c);
	}

	@Override
	public synchronized boolean equals(Object o) {
		return this.underlying.equals(o);
	}

	@Override
	public synchronized int hashCode() {
		return this.underlying.hashCode();
	}

	@Override
	public synchronized String toString() {
		return this.underlying.toString();
	}

	@Override
	public synchronized List<E> subList(int fromIndex, int toIndex) {
		return this.underlying.subList(fromIndex, toIndex);
	}

	@Override
	protected synchronized void removeRange(int fromIndex, int toIndex) {
		for(int i = 0; i < this.size() && i < toIndex-fromIndex; i++) {
			this.underlying.remove(fromIndex);
		}
	}

	@Override
	public synchronized ListIterator<E> listIterator(int index) {
		return this.underlying.listIterator(index);
	}

	@Override
	public synchronized ListIterator<E> listIterator() {
		return this.underlying.listIterator();
	}

	@Override
	public synchronized Iterator<E> iterator() {
		return this.underlying.iterator();
	}

	@Override
	public synchronized void forEach(Consumer<? super E> action) {
		this.underlying.forEach(action);
	}

	@Override
	public synchronized boolean removeIf(Predicate<? super E> filter) {
		return this.underlying.removeIf(filter);
	}

	@Override
	public synchronized void replaceAll(UnaryOperator<E> operator) {
		this.underlying.replaceAll(operator);
	}

	@Override
	public synchronized void sort(Comparator<? super E> c) {
		this.underlying.sort(c);
	}

	@Override
	public Spliterator<E> spliterator() {
		return this.underlying.spliterator();
	}

}
