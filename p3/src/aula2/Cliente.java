package aula2;

public class Cliente {
	private String nome;
	private int cc;
	private int numSoc;
	private Data inscricao;
	private Data dNasc;
	
	public Cliente(String nome, int cc, int numSoc, Data inscricao, Data dNasc) {
		this.nome = nome;
		this.cc = cc;
		this.numSoc = numSoc;
		this.inscricao = inscricao;
		this.dNasc = dNasc;
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
	
	/*public int getIdade() {
		DateFormat formatoData = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		String data = formatoData.format(cal);
		data = data.split(" ")[0];
		int dia = Integer.valueOf(data.split("/")[2]);
		int mes = Integer.valueOf(data.split("/")[1]);
		int ano = Integer.valueOf(data.split("/")[0]);
		int idade = 0;
		if(this.getdNasc().getDia()<=dia) {
			if(this.getdNasc().getMes()<=mes){
				idade=ano-this.getdNasc().getAno();
			}
			else {
				idade=ano-this.getdNasc().getAno()-1;
			}
		}
		else {
			if(this.getdNasc().getMes()>=mes) {
				idade=ano-this.getdNasc().getAno()-1;
			}
			else {
				idade=ano-this.getdNasc().getAno();
			}
		}
		return idade;
	}*/
}
