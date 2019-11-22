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

		@Override
		public void remove() {
			throw new UnsupportedOperationException("Not supported operation!");
			
		}

		@Override
		public boolean hasPrevious() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public Object previous() {
			// TODO Auto-generated method stub
			return null;
		}
		
	}
}
