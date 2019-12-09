package aula6;

public class Alimento implements Comparable<Alimento>{
	private double proteina, calorias, peso;
	private boolean vegetariano;

	public Alimento(double proteina, double calorias, double peso) {
		super();
		this.proteina = proteina;
		this.calorias = calorias;
		this.peso = peso;
	}

	public double getProteina() {
		return proteina;
	}

	public double getCalorias() {
		return calorias;
	}

	public double getPeso() {
		return peso;
	}
	
	@Override
	public String toString() {
		return ", Proteinas "+this.getProteina()+", calorias "+this.getCalorias()+", Peso "+this.getPeso();
	}

	public boolean isVegetariano() {
		return vegetariano;
	}

	public void setVegetariano(boolean vegetariano) {
		this.vegetariano = vegetariano;
	}
	
	public int compareTo(Alimento a) {
		if(this.calorias>a.calorias)return 1;
		else if(this.calorias<a.calorias)return -1;
		else {return 0;}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(calorias);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alimento other = (Alimento) obj;
		if (Double.doubleToLongBits(calorias) != Double.doubleToLongBits(other.calorias))
			return false;
		return true;
	}
	
	
	
	

}
