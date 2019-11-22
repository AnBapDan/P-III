package aula9;

public interface BFIterator {
	boolean hasPrevious();
	Object previous();
	boolean hasNext();
	Object next();
	void remove();
}
