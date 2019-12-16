package aula12;

import aula5.Const.Color;

public class Veiculo implements Comparable<Veiculo>{
	private int ano, nRodas, velMax;
	private Const.Color color;
	private static int num=1;
	private int id;
	
	public Veiculo(int ano, int nRodas, int velMax, Const.Color color) {
		super();
		this.ano = ano;
		this.nRodas = nRodas;
		this.velMax = velMax;;
		this.color = color;
		this.id=Veiculo.num++;
	}
	
	public String getID() {
		return id+"";
	}

	public int getAno() {
		return ano;
	}

	public int getnRodas() {
		return nRodas;
	}

	public int getVelMax() {
		return velMax;
	}

	public Const.Color getColor() {
		return color;
	}
	
	@Override
	public String toString() {
		return " -> Ano: "+this.getAno()+",Cor: "+this.getColor()+", Número de rodas: "+this.getnRodas()
		+", Velocidade máxima: "+this.getVelMax()+" km/h";
	}
	
	
	public int compareTo(Veiculo a) {
		if(a == null || this == null) {throw new NullPointerException("Veiculo null");}
		if(this.getAno() > a.getAno()) {return 1;}
		else if(this.getAno()<a.getAno()) {return -1;}
		else {return 0;}
		
	}
	
	
}
