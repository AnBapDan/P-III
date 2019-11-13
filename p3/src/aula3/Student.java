package aula3;

public class Student extends Pessoa{
	private static int num=100;
	private int nMec;
	private Data inscricao;

	public Student(String nome, int cc, Data bday, Data ins) {
		super(nome, cc, bday);
		// TODO Auto-generated constructor stub
		this.nMec=Student.num++;
		this.inscricao = ins;
	}
	public Student(String nome, int cc, Data bday) {
		super(nome, cc, bday);
		this.nMec=Student.num++;
		this.inscricao = Data.getHoje();
	}
	
	public int getnMec() {
		return nMec;
	}

	public Data getInscricao() {
		return inscricao;
	}
	
	@Override
	public String toString() {
		return super.toString() +", NMec: "+this.getnMec()+", inscrito em Data: "
				+ this.getInscricao().dia()+"/"+this.getInscricao().mes()+"/"
				+ this.getInscricao().ano();
	}
}
