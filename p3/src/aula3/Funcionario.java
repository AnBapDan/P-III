package aula3;

public class Funcionario extends Cliente {
	private int numFunc;
	private int nif;
	
	public Funcionario(String nome, int cc, int numSoc, Data inscricao, Data dNasc, char type, int numFunc, int nif) {
		super(nome, cc, numSoc, inscricao, dNasc, type);
		this.numFunc = numFunc;
		this.nif = nif;
	}

	public int getNumFunc() {
		return numFunc;
	}

	public int getNif() {
		return nif;
	}
	
	@Override
	public String toString(){
		return "| Funcionário: "+this.getNome()+" | Número de sócio -> "+this.getNumSoc()+" |";
	}
}
