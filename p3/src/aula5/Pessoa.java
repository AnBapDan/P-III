package aula5;


public class Pessoa {
	private String nome;
	private int cc;
	private Data dataNasc;
	
	public Pessoa(String nome, int cc, Data dataNasc) {
		this.cc = cc;
//		checkDigits();									Nem todos os cc têm 8 digitos!
		this.dataNasc= dataNasc;
		this.nome = nome;
		checkName();
		
		
	}
	
	private void checkName() {
		String check = this.nome; 
		for(int i = 0; i< check.length();i++) {
			if(!Character.isLetter(check.charAt(i))&& !Character.isWhitespace(check.charAt(i))) {
				System.out.println("Verifique o nome, este nao pode conter numeros");
				System.exit(1); //invalid name
			}
		}
	}
	
	
	
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
}
