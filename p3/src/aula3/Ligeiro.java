package aula3;

public class Ligeiro extends Viatura{
	
	
	
	public Ligeiro(int cilindrada, int potencia, int lotacao, int pesoBruto, Condutor c) {
		super(cilindrada, potencia, lotacao, pesoBruto, c);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Ligeiro"+super.toString();
	}
	
}
