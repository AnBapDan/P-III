package aula6;

public class Prato implements Comparable<Prato>{
	private String nome;
	private LinkedList<Alimento>composicao;
	private double totalCal, totalProt, pesoTotal;
	
	public Prato(String nome) {
		this.nome=nome;
		this.composicao=new LinkedList<Alimento>();
		this.totalCal=0;
		this.totalProt=0;
		this.pesoTotal=0;
	}

	public String getNome() {
		return nome;
	}

	public LinkedList<Alimento> getComposicao() {
		return composicao;
	}
	
	public Alimento[] getComposicaotoArray() {
		return composicao.toArray(new Alimento[0]);
	}

	public double getTotalCal() {
		return totalCal;
	}
	
	public double getTotalProt() {
		return totalProt;
	}
	
	public double getPesoTotal() {
		return pesoTotal;
	}
	
	public void setTotalCal(double s, int num) {
		if(num==1)this.totalCal += s;
		if(num==2)this.totalCal -= s;
	}
	
	public void setTotalProt(double s, int num) {
		if(num==1)this.totalProt += s;
		if(num==2)this.totalProt -= s;
	}
	
	public void setPesoTotal(double s, int num) {
		if(num==1)this.pesoTotal += s;
		if(num==2)this.pesoTotal -= s;
		
	}
	
	public boolean addIngrediente(Alimento a) {
		if(a==null)return false;
		composicao.insert(a);
		this.setTotalCal(a.getCalorias(),1);
		this.setTotalProt(a.getProteina(),1);
		this.setPesoTotal(a.getPeso(),1);
		return true;
	}
	
	public boolean remIngrediente(Alimento a) {
		if(a==null)return false;
		for(int i=0;i<composicao.size();i++) {
			if(getComposicaotoArray()[i].equals(a)) {
				composicao.remove(i);
			}
		}
		this.setTotalCal(a.getCalorias(),2);
		this.setTotalProt(a.getProteina(),2);
		this.setPesoTotal(a.getPeso(),2);
		return true;
	}
	

	@Override
	public String toString() {
		return "Prato '"+nome+ "' composto por " + composicao.size() + " ingredientes";
	}

	@Override
	public int compareTo(Prato p) {
		if(this.getTotalCal()>p.getTotalCal())return 1;
		else if(this.getTotalCal()<p.getTotalCal())return -1;
		else {return 0;}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		Prato other = (Prato) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	
	
}
