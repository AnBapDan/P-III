package aula11;

public class Peixe extends Alimento{
	private Const.TipoPeixe tipo;

	public Peixe(Const.TipoPeixe tipo, double proteina, double calorias, double peso) {
		super(proteina, calorias, peso);
		this.tipo = tipo;
		this.setVegetariano(false);
	}

	public Const.TipoPeixe getTipo() {
		return tipo;
	}
	
	@Override
	public String toString() {
		return "Peixe "+this.getTipo()+super.toString();
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
		Peixe other = (Peixe) obj;
		if (tipo != other.tipo)
			return false;
		return true;
	}
	
	
}
