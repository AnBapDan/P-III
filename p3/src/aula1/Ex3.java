package aula1;
import java.util.Scanner;

public class Ex3 {
	static Scanner sc = new Scanner(System.in);
	static Scanner r = new Scanner(System.in);
	static Scanner kb = new Scanner(System.in);
	public static void main(String[] args) {

		int option;
		do {
			System.out.println("__________________Menu____________________");
			System.out.println("|1- Area e perimetro de um quadrado------|");
			System.out.println("|2- Area e perimetro de um retangulo-----|");
			System.out.println("|3- Area e perimetro de um circulo-------|");
			System.out.println("|4- Verificar igualdade de dois circulos-|");
			System.out.println("|5- Verificar intersecao de dois circulos|");
			System.out.println("|0- Sair---------------------------------|");
			System.out.println("‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾\n");
			System.out.print("Escolha: ");
			option = sc.nextInt();
			switch(option) {
				case 0: System.exit(0);
					
				case 1:
					String[] p=dPontos();
					Quadrado q1=new Quadrado(Double.parseDouble(p[0]),Double.parseDouble(p[1]),Double.parseDouble(p[2]),Double.parseDouble(p[3]));
					System.out.println(q1.toString());
					break;
					
				case 2:
					String[] p1=dPontos();
					Rectangulo r1=new Rectangulo(Double.parseDouble(p1[0]),Double.parseDouble(p1[1]),Double.parseDouble(p1[2]),Double.parseDouble(p1[3]));
					System.out.println(r1.toString());
					break;
					
				case 3:
					Ponto centro = c();
					System.out.print("Comprimento do raio: ");
					double raio = r.nextDouble();
					Circulo a = new Circulo(centro, raio);
					System.out.println(a.toString());
					break;
					
				case 4:
					Ponto centro1 = c();
					System.out.print("Comprimento do raio1: ");
					double raio1 = r.nextDouble();
					Circulo circulo1 = new Circulo(centro1, raio1);
					Ponto centro2 = c();
					System.out.print("Comprimento do raio2: ");
					double raio2 = r.nextDouble();
					Circulo circulo2 = new Circulo(centro2, raio2);
					if(circulo1.equalCircles(circulo2)==false) {
						System.out.println("Os circulos não sao iguais");
					}
					else {System.out.println("Os circulos sao iguais");}
					break;
					
				case 5:
					centro1 = c();
					System.out.print("Comprimento do raio1: ");
					raio1 = r.nextDouble();
					circulo1 = new Circulo(centro1, raio1);
					centro2 = c();
					System.out.print("Comprimento do raio2: ");
					raio2 = r.nextDouble();
					circulo2 = new Circulo(centro2, raio2);
					if(circulo1.intCircles(circulo2)== true) {
						System.out.println("Os circulos intersetam-se");
					}
					else {System.out.println("Os circulos nao se intersetam");}
					
					
					break;
					
			}
		}while(option != 0);
	}
	
	public static String[] dPontos() {
		System.out.println("Os pontos dados devem formar uma diagonal.");
		System.out.println("Coordenadas do ponto 1: ");
		System.out.print("x-");
		String s = kb.nextLine();
		System.out.print("y-");
		s = s+"-"+kb.nextLine() ; 
		System.out.println("Coordenadas do ponto 2: ");
		System.out.print("x-");
		s = s+"-"+kb.nextLine() ; 
		System.out.print("y-");
		s = s+"-"+kb.nextLine() ; 
		String[] p = s.split("-");
		return p;
	}
	public static Ponto c() {

		System.out.println("Coordenadas do ponto : ");
		System.out.print("x-");
		double x = kb.nextDouble();
		System.out.print("y-");
		double y = kb.nextDouble();
		Ponto p = new Ponto(x, y);
		return p;
	}

}
