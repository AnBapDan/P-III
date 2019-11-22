package aula9;

public class VectorPessoas {
	private int totalPessoas;
	private static final int cont = 1;
	Pessoa[] pessoas = new Pessoa[10];
	
	
	public boolean addPessoa(Pessoa p) {
		extend();
		pessoas[totalPessoas]=p;
		totalPessoas++;
		return true;
	}
	
	public boolean removePessoa(Pessoa p) {
		
		totalPessoas--;
		return true;
	}
	
	public int totalPessoas() {
		return totalPessoas;
	}
	
	private void extend() {
		if(totalPessoas==pessoas.length-1) {
			Pessoa[] copy = pessoas;
			pessoas=new Pessoa[copy.length+cont];
			System.arraycopy(copy, 0, pessoas, 0, copy.length);
		}
	}
}
