package aula3;

public class Cliente {
	private String nome;
	private int cc;
	private int numSoc;
	private Data inscricao;
	private Data dNasc;
	private char type;
	
	public Cliente(String nome, int cc, int numSoc, Data inscricao, Data dNasc, char type) {
		this.nome = nome;
		this.cc = cc;
		this.numSoc = numSoc;
		this.inscricao = inscricao;
		this.dNasc = dNasc;
		this.type = type;
	}

	public String getNome() {
		return nome;
	}

	public int getCc() {
		return cc;
	}

	public int getNumSoc() {
		return numSoc;
	}

	public Data getInscricao() {
		return inscricao;
	}

	public Data getdNasc() {
		return dNasc;
	}
	
	public char getType(){
		return type;
	}
	
	public int getIdade() {
		Data data = Data.getHoje();
		int dia = data.dia();
		int mes = data.mes();
		int ano = data.ano();
		int idade = 0;
		if(this.getdNasc().dia()<=dia) {
			if(this.getdNasc().mes()<=mes){
				idade=ano-this.getdNasc().ano();
			}
			else {
				idade=ano-this.getdNasc().ano()-1;
			}
		}
		else {
			if(this.getdNasc().mes()>=mes) {
				idade=ano-this.getdNasc().ano()-1;
			}
			else {
				idade=ano-this.getdNasc().ano();
			}
		}
		return idade;
	}
}
