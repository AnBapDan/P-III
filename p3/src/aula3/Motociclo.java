package aula3;

public class Motociclo extends Viatura{
	
	public Motociclo(int cilindrada, int potencia, int lotacao, int pesoBruto, Condutor c) {
		super(pesoBruto, pesoBruto, pesoBruto, pesoBruto, c);
	}

	@Override
	public String toString() {
		return "Motociclo"+super.toString();
	}
	
}
