package aula9;

import java.io.IOException;

public class Ex9_1 {

	public static void main(String[] args) throws IOException {
		System.out.println("Teste Scanner Abeirense");
		System.out.println("Leitura de teclado");
		ScannerAbeirense a = new ScannerAbeirense(System.in);	
		String x= a.nextLine();
		
		System.out.println("Resultado: "+ x);
		a.close();

		

	}

}
