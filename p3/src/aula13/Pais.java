package aula13;

import java.util.ArrayList;

public class Pais {
	private String name;
	private Localidade capital;
	private ArrayList<Regiao> distritos;
	private int popSize;
	
	public Pais(String name, Localidade capital) {
		this.name=name;
		if(capital!=null) {
			if(capital.getType()==TipoLocalidade.Cidade) {
				this.capital = capital;
			}
			else {
				this.capital=null;
				//throw new IllegalArgumentException("Capital Inválida");
			}
		}
		distritos = new ArrayList<Regiao>();
		this.popSize=0;
	}
	
	public Pais(String name) {
		this.name=name;
		this.capital=null;
		distritos = new ArrayList<Regiao>();
		this.popSize=0;
	}

	public String getName() {
		return name;
	}

	public Localidade getCapital() {
		return capital;
	}

	public ArrayList<Regiao> getDistritos() {
		return distritos;
	}
	
	public void addRegiao(Regiao x) {
		if(!distritos.contains(x)) {
			distritos.add(x);
			popSize+=x.getPopSize();
		}
	}
	
	@Override
	public String toString() {
		return "Pais: "+name+", Populacao: "+popSize+" (Capital: "+((capital==null)?"*Indefinida*":capital.toString())+")";
	}
}
