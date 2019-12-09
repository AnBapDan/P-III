package aula6;

public class PratoVegetariano extends Prato{

	public PratoVegetariano(String nome) {
		super(nome);
	}
	
	public boolean addIngrediente(Alimento a) {
		if(a==null)return false;
		if(a instanceof IsVegetariano) {
			return super.addIngrediente(a);
		}
		return false;
	}
	
	@Override
	public String toString() {
		return "Vegetariano "+super.toString()+" ";
	}
}
