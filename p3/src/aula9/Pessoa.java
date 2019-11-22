package aula9;

public class Pessoa {
	private String nome;
	private int cc;
	private Data dataNasc;
	
	public Pessoa(String nome, int cc, Data dataNasc) {
		this.cc = cc;
//		checkDigits();
		this.dataNasc= dataNasc;
		this.nome = nome;
//		checkName();
		
		
	}
	
//	private void checkName() {
//		String check = this.nome; 
//		for(int i = 0; i< check.length();i++) {
//			if(!Character.isLetter(check.charAt(i))&& !Character.isWhitespace(check.charAt(i))) {
//				System.out.println("Verifique o nome, este nao pode conter numeros");
//				System.exit(1); //invalid name
//			}
//		}
//	}
//	
//	
//	
//	private void checkDigits() {
//		int c= 0;
//		String check = Integer.toString(this.cc) ; 
//		for(int i = 0; i< check.length();i++) {
//			if(Character.isDigit(check.charAt(i))) {
//				c++;
//			}
//		}
//		assert c==8 : "Numero de cc invalido. Confirme se tem 8 digitos";
//	}
//	
	
	public String nome(){
		return nome;
	}
	
	public int cc(){
		return cc;
	}
	
	public Data dataNasc() {
		return dataNasc();
	}
	public String toString()
	{
		return "Nome: "+ this.nome + " -C.C: " + this.cc + " - Data: " + this.dataNasc.toString();
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cc;
		result = prime * result + ((dataNasc == null) ? 0 : dataNasc.hashCode());
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
		Pessoa other = (Pessoa) obj;
		if (cc != other.cc)
			return false;
		if (dataNasc == null) {
			if (other.dataNasc != null)
				return false;
		} else if (!dataNasc.equals(other.dataNasc))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
}
