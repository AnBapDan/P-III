package aula13;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Ex13_3 {

	private static List<Funcionario> geral = new ArrayList<>();
	private static List<Pair> par = new ArrayList<>();
	private static Set<Funcionario> ugeral = new HashSet<>();
	private static Set<Brinquedo> brinquedos = new HashSet<>();
	private static int indicator = -1;
	private static Scanner sc= new Scanner(System.in);
	private static Scanner nome= new Scanner(System.in);
	public static void main(String[] args) {
		do {
			menu();
			indicator = sc.nextInt();
			switch(indicator) {
			case 0:
				System.exit(0);
				break;

			case 1:
				System.out.print("Nome Completo do Funcionário: ");
				add(nome.nextLine());
				break;

			case 2:
				geral.stream().forEach(s -> System.out.println(s.toString()));
				System.out.println("\n\n");
				break;

			case 3:
				System.out.print("Nome Completo do Funcionário a remover: ");
				rem(nome.nextLine());
				break;

			case 4:
				sortBrinquedo();
				System.out.println("\n\n");
				break;

			case 5:
				ugeral = geral.stream().filter(s-> s.getApelido() == null).collect(Collectors.toSet());
				for(Funcionario a: ugeral) {
					brinquedos.add(new Brinquedo(a.getNome()));
				}

			case 6:


			case 7:
				par.clear();
				break;
			}
		}while(true);

	}




	private static void rem(String nome) {
		String[] split;
		split = nome.split(" ");


		if(split.length <= 2 && split.length >0) {
			if(split.length==1) {
				for(Funcionario f : geral) {
					if(f.getNome() == nome.toUpperCase() && f.getApelido() == null) {
						System.out.println("Funcionario "+f.toString()+" Removido\n\n");
						break;
					}
				}
			} else {
				for(Funcionario f : geral) {
					if(f.getNome() == split[0].toUpperCase() && f.getApelido() == split[1].toUpperCase()) {
						System.out.println("Funcionario "+f.toString()+" Removido\n\n");
						break;
					}
				}
			}
		}else {
			System.out.println("Nome invalido. Tente de novo\n\n");
		}	

	}

	private static void sortBrinquedo() {
		Brinquedo b = new Brinquedo();
		Pair p;
		int win = (int) (Math.random()*geral.size())+1;

		if(par.size()<13) {
			p = new Pair(geral.get(win-1),b);
			System.out.println("O vencedor deste mes -> "+ geral.get(win-1));
			par.add(p);
		}else {System.out.println("Ocorreu um erro ao encontrar vencedor. Ja foram atribuidos os 12 premios do ano");}		

	}



	private static void menu() {
		System.out.println("1 - Adicionar Funcionario"); //
		System.out.println("2 - Listar (alinea a)"); //
		System.out.println("3 - Remover Funcionario"); //
		System.out.println("4 - Sorteio do brinquedo (alinea b)");
		System.out.println("5 - Dar nome unico dos empregados aos brinquedos (alinea c)");
		System.out.println("6 - Dar nome popular dos empregados aos brinquedos (alinea d)");
		System.out.println("7 - Apagar sorteios");
		System.out.println("0 - Sair do Programa");
	}

	private static void add(String nome) {
		String[] split;
		split = nome.split(" ");
		Funcionario f;
		if(split.length <= 2 && split.length >0) {

			if(split.length==1) {

				f = new Funcionario(nome , null);

			} else {

				f = new Funcionario(split[0],split[1]);	

			}
			System.out.println("Funcionario "+f.toString()+" Adicionado\n\n");
			geral.add(f);

		}else {System.out.println("Nome invalido. Tente de novo\n\n");}	
	}

}
