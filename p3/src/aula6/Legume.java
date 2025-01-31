package aula6;

public class Legume extends Alimento implements IsVegetariano{
	private String nome;

	public Legume(String nome ,double proteina, double calorias, double peso) {
		super(proteina, calorias, peso);
		this.nome = nome;
		this.setVegetariano(true);
	}

	public String getNome() {
		return nome;
	}
	
	@Override
	public String toString() {
		return this.getClass().getSimpleName()+" "+this.getNome()+super.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		Legume other = (Legume) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	
	
}
