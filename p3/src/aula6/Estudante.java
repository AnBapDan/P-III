package aula6;

public class Estudante extends Pessoa{
	private static int num=100;
	private int nMec;
	private Data inscricao;

	public Estudante(String nome, int cc, Data bday, Data ins) {
		super(nome, cc, bday);
		// TODO Auto-generated constructor stub
		this.nMec=Estudante.num++;
		this.inscricao = ins;
	}
	public Estudante(String nome, int cc, Data bday) {
		super(nome, cc, bday);
		this.nMec=Estudante.num++;
		this.inscricao = Data.getHoje();
	}
	
	public int getNMec() {
		return nMec;
	}

	public Data getInscricao() {
		return inscricao;
	}
	
	@Override
	public String toString() {
		return super.toString() +", NMec: "+this.getNMec()+", inscrito em Data: "+ this.getInscricao().toString();
	}
}
