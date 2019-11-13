package aula3;

public class Estudante extends Cliente{
	private int nmec;
	private String curso;
	
	public Estudante(String nome, int cc, int numSoc, Data inscricao, Data dNasc, char type, int nmec, String curso) {
		super(nome, cc, numSoc, inscricao, dNasc, type);
		this.nmec = nmec;
		this.curso = curso;
	}

	public int getNmec() {
		return nmec;
	}

	public String getCurso() {
		return curso;
	}
	
	@Override
	public String toString(){
		return "| Estudante: "+this.getNome()+" | Número de sócio -> "+this.getNumSoc()+" |";
	}
}
