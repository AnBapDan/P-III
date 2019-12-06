package aula11;

public interface Iterator<T> {
	boolean hasNext();
	Object next();
	void remove();
}
