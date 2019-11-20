package aula9;

import java.io.IOException;
import java.util.Scanner;

public class Ex9_1 {

	public static void main(String[] args) throws IOException {
		System.out.println("Teste Scanner Abeirense");
		System.out.println("Leitura de teclado");
		Scanner sc = new Scanner(System.in);
		
		ScannerAbeirense a = new ScannerAbeirense(System.in);
		if(a.hasNext()) {
			System.out.println(a.next());
		}
		a.close();
		

	}

}
