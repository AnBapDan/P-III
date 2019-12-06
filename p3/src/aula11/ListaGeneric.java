package aula11;

import java.util.LinkedList;
import java.util.List;

public class ListaGeneric<T>{
	List<Object>  p;
	
	public ListaGeneric() {
		p = new LinkedList<Object>();
	}
	
	public boolean addElem(Object elem) {
		return p.add(elem);
		
	}
	
	public boolean removeElem(Object elem) {
		return p.remove(elem);
		
	}
	
	public int totalElem() {
		return p.size();
	}
	
	public Iterator<T> iterator() {
		return (this).new ListaIterator();
	}
	
	
	class ListaIterator implements Iterator<T>{
		private int c;
		
		ListaIterator(){
			c=0;
		}
		
		public boolean hasNext() {
			return p.size()>c;
		}

		public Object next() {
			if(hasNext()) {
				Object r = p.get(c);
				c++;
				return r;
			}
			else {
				throw new IndexOutOfBoundsException(c+" elements for range "+p.size());
			}
		}

		public void remove() {
			throw new UnsupportedOperationException("Not supported operation!");
			
		}

		public boolean hasPrevious() {
			return c>0;
		}

		public Object previous() {
			if(hasPrevious()) {
				c--;
				Object r = p.get(c);
				return r;
			}
			else {
				throw new IndexOutOfBoundsException("Reached and passed 0");

			}
		}
		
	}
}
