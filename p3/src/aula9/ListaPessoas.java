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

	
	public Iterator iterator() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	class ListaIterator implements Iterator<Pessoa>{
		private int c = 0;
		
		@Override
		public boolean hasNext() {
			if(p.size()>p.indexOf(arg0)) {
				return true;
			}
			return false;
		}

		
		@Override
		public Pessoa next() {
			return p.get(c++); 
		}
		
	}
}
