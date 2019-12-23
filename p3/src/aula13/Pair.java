package aula13;

public class Pair {
	private Funcionario f;
	private Brinquedo b;
	
	Pair(Funcionario f, Brinquedo b){
		this.f=f;
		this.b=b;
	}

	@Override
	public String toString() {
		return "O funcionario "+ f.toString()+" ganhou o brinquedo"+b.toString();
	}
	
	
}
