package aula2;

public class Funcionario extends Cliente {
	private int numFunc;
	private int nif;
	
	public Funcionario(String nome, int cc, int numSoc, Data inscricao, Data dNasc, int numFunc, int nif) {
		super(nome, cc, numSoc, inscricao, dNasc);
		this.numFunc = numFunc;
		this.nif = nif;
	}

	public int getNumFunc() {
		return numFunc;
	}

	public int getNif() {
		return nif;
	}
}
