package aula10;

public interface Iterator<T> {
	boolean hasNext();
	Object next();
	void remove();
}
