package aula2;

public class Estudante extends Cliente{
	private int nmec;
	private String curso;
	
	public Estudante(String nome, int cc, int numSoc, Data inscricao, Data dNasc, int nmec, String curso) {
		super(nome, cc, numSoc, inscricao, dNasc);
		this.nmec = nmec;
		this.curso = curso;
	}

	public int getNmec() {
		return nmec;
	}

	public String getCurso() {
		return curso;
	}
}
