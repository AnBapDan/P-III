package aula9;

import java.util.*;

public class ListaPessoas{
	
	List<Pessoa>  p = new LinkedList<>();
	public boolean addPessoa(Pessoa pessoa) {
		return p.add(pessoa);
		
	}
	
	public boolean removePessoa(Pessoa pessoa) {
		return p.remove(pessoa);
		
	}

	
	public BFIterator iterator() {
		return (this).new ListaIterator();
	}
	
	
	class ListaIterator implements BFIterator{
		private int c;
		
		ListaIterator(){
			c=0;
		}
		
		public boolean hasNext() {
			return p.size()>c;
		}

		
		public Pessoa next() {
			if(hasNext()) {
				Pessoa r = p.get(c);
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
