package aula6;

public class PratoDieta extends Prato{
	private double maxCal;

	public PratoDieta(String nome, double maxCal) {
		super(nome);
		this.maxCal = maxCal;
	}

	public double getMaxCal() {
		return maxCal;
	}
	
	@Override
	public String toString() {
		return "Dieta ("+this.getTotalCal()+") "+super.toString()+" ";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		long temp;
		temp = Double.doubleToLongBits(maxCal);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		PratoDieta other = (PratoDieta) obj;
		if (Double.doubleToLongBits(maxCal) != Double.doubleToLongBits(other.maxCal))
			return false;
		return true;
	}

	public boolean addIngrediente(Alimento a) {
		if(a==null)return false;
		if(this.getTotalCal()+a.getCalorias()<=maxCal) {
			return super.addIngrediente(a);
		}
		return false;
	}
}
