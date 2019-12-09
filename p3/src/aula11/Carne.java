package aula11;

public class Carne extends Alimento{
	private Const.VariedadeCarne tipo;

	public Carne(Const.VariedadeCarne tipo, double proteina, double calorias, double peso) {
		super(proteina, calorias, peso);
		this.tipo = tipo;
		this.setVegetariano(false);
	}

	public Const.VariedadeCarne getTipo() {
		return tipo;
	}
	
	@Override 
	public String toString() {
		return "Carne "+this.getTipo()+super.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Carne other = (Carne) obj;
		if (tipo != other.tipo)
			return false;
		return true;
	}
	
	
}
