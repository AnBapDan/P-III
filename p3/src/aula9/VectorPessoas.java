package aula9;

import java.util.Iterator;

public class VectorPessoas {
	private int totalPessoas;
	private final int cont = 50;
	private int dimClasse = cont;
	Pessoa[] pessoas = new Pessoa[10];
	
	public VectorPessoas() {
		pessoas=new Pessoa[cont];
		totalPessoas=0;
	}
	
	public boolean addPessoa(Pessoa p) {
		if(p==null) {
			return false;
		}
		extend();
		pessoas[totalPessoas]=p;
		totalPessoas++;
		return true;
	}
	
	public boolean removePessoa(Pessoa p) {
		for(int i=0;i<totalPessoas;i++) {
			Pessoa p1 = pessoas[i];
			if(p1.equals(p)) {
				totalPessoas--;
				for(int j=i;j<totalPessoas;j++) {
					pessoas[j]=pessoas[j+1];
				}
				return true;
			}
		}
		return false;
	}
	
	public int totalPessoas() {
		return totalPessoas;
	}
	
	public Pessoa getPessoa(int index) {
		return pessoas[index];
	}
	
	private void extend() {
		if(totalPessoas>=dimClasse) {
			dimClasse+=cont;
			Pessoa[] copy = pessoas;
			pessoas=new Pessoa[dimClasse];
			System.arraycopy(copy, 0, pessoas, 0, totalPessoas);
		}
	}
	
	Iterator<Pessoa> iterator() {
		return (this).new VectorIterator();
	}
	
	class VectorIterator implements Iterator<Pessoa>{
		private int index;
		
		VectorIterator(){
			this.index=0;
		}
		
		
		@Override
		public boolean hasNext() {
			return index<totalPessoas;
		}

		@Override
		public Pessoa next() {
			if(hasNext()) {
				Pessoa r = pessoas[index];
				index++;
				return r;
			}
			else {
				throw new IndexOutOfBoundsException(index+" elements for range "+totalPessoas);
			}
		}
		
	}
}
