package aula13;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Ex13_3 {

	private static List<Funcionario> geral = new ArrayList<>();
	private static List<Pair> par = new ArrayList<>();
	private static Set<String> ugeral = new HashSet<>();
	private static Set<Brinquedo> brinquedos = new HashSet<>();
	private static int indicator = -1;
	private static Scanner sc= new Scanner(System.in);
	private static Scanner nome= new Scanner(System.in);
	private static final int pop =((int) (Math.random()*3))+3; 
	private static final int numTickets = ((int) (Math.random()*2))+3;
	private static int geralIndex = 0;
	
	public static void main(String[] args) {
		do {
			geral.stream().forEach(func -> ugeral.add(func.getNome()));
			menu();
			System.out.print("Opcao -> ");
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
				brinquedos.clear();
				break;

			case 5:
//				ugeral = geral.stream().filter(s-> s.getApelido() == null).collect(Collectors.toSet());
				for(String a: ugeral) {
					brinquedos.add(new Brinquedo(a));
				}
				System.out.println("Nomes dos brinquedos:");
				Brinquedo[] brin = brinquedos.toArray(new Brinquedo[0]);
				for(int i=0;i<brinquedos.size();i++) {
					System.out.println((i+1)+" - "+brin[i].toString());
				}
				brinquedos.clear();
				System.out.println("\n\n");
				break;
				
			case 6:
//				ugeral = geral.stream().filter(s-> s.getApelido() == null).collect(Collectors.toSet());
				Hashtable<String,Integer> numNomes = new Hashtable<String,Integer>();
				for(Funcionario a: geral) {
//					brinquedos.add(new Brinquedo(a.getNome()));
					if(!numNomes.containsKey(a.getNome())) {
						numNomes.put(a.getNome(), 1);
					}
					else {
						int cont = numNomes.get(a.getNome());
						cont++;
						numNomes.put(a.getNome(), cont);
					}
				}
				for(String nome:numNomes.keySet()) {
					if(numNomes.get(nome)>=pop) {
						brinquedos.add(new Brinquedo(nome));
					}
				}
				System.out.println("Índice de popularidade = "+pop);
				System.out.println("Nomes dos brinquedos:");
				Brinquedo[] brin1 = brinquedos.toArray(new Brinquedo[0]);
				for(int i=0;i<brinquedos.size();i++) {
					System.out.println((i+1)+" - "+brin1[i]);
				}
				brinquedos.clear();
				System.out.println("\n\n");
				break;
			case 7:
				rotation();
				break;
			case 8:
				par.clear();
				break;
			}
		}while(true);

	}


	private static void rotation() {
		System.out.println("Numero de bilhetes obtidos = "+numTickets);
		System.out.println("Proximos funcionarios a ir ao jogo: ");
		ArrayList<Funcionario> check = new ArrayList<Funcionario>();
		for(int i=0;i<numTickets;i++) {
			if(geralIndex>=geral.size())geralIndex=0;
			Funcionario f = geral.get(geralIndex);
			if(check.contains(f))continue;
			System.out.println(f);
			check.add(f);
			geralIndex++;
		}
		System.out.println("\n\n");
	}

	private static void rem(String nome) {
		String[] split;
		split = nome.split(" ");


		if(split.length <= 2 && split.length >0) {
			if(split.length==1) {
				for(Funcionario f : geral) {
					if(f.getNome().equals(nome.toUpperCase()) && f.getApelido() == null) {
						System.out.println("Funcionario "+f.toString()+" Removido\n\n");
						geral.remove(f);
						break;
					}
				}
			} else {
				for(Funcionario f : geral) {
					if(f.getNome().equals(split[0].toUpperCase()) && f.getApelido().equals(split[1].toUpperCase())) {
						System.out.println("Funcionario "+f.toString()+" Removido\n\n");
						geral.remove(f);
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
		System.out.println("7 - Verificar as rotações dos bilhetes");
		System.out.println("8 - Apagar sorteios");
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
