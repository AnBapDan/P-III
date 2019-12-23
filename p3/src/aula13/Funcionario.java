package aula13;

public class Funcionario {
	
	private String nome;
	private String apelido;
	
	Funcionario(String nome, String apelido){
		this.nome = nome.toUpperCase();
		this.apelido = apelido.toUpperCase();
	}

	public String getNome() {
		return nome;
	}
	
	public String getApelido() {
		return apelido;
	}

	@Override
	public String toString() {
		return getNome()+" "+getApelido();
	}
	
}
