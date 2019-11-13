package aula1;
import java.util.Scanner;
import java.util.LinkedList;
import java.util.Comparator;

public class Ex2 {
	
	static LinkedList<Pessoa> Lista = new LinkedList<Pessoa>();
	static Scanner sc = new Scanner(System.in);
	static Scanner kb = new Scanner(System.in);
	public static void main(String[] args) {

		int option;
		do {
			System.out.println("_____________Menu_____________");
			System.out.println("|1- Adicionar pessoa na lista|");
			System.out.println("|2- Remover pessoa da lista--|");
			System.out.println("|3- Mostrar lista completa---|");
			System.out.println("|4- Ordenar lista por nome---|");
			System.out.println("|5- Ordenar lista por C.C.---|");
			System.out.println("|0- Sair---------------------|");
			System.out.println("‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾\n");
			System.out.print("Escolha: ");
			option = sc.nextInt();
			switch(option) {
				case 0: System.exit(0);
				case 1:
					addP();
					System.out.println();
					break;
			
				case 2:
					rmvP();
					System.out.println();
					break;
				case 3:
					System.out.printf("\n Lista de pessoas:\n");
					for(int i = 0; i < Lista.size(); i++){
						System.out.println(Lista.get(i).toString());
					}
					System.out.println();
					break;
					
				case 4:
					oNome();
					System.out.println();
					break;
					
				case 5:
					oCC();
					System.out.println();
					break;
			}
		}while(option != 0);
		
	}
	
	public static void addP() {
		System.out.print("Nome da Pessoa: ");
		String name = kb.nextLine();
		
		System.out.print("C.C.(Verifique se tem apenas 8 digitos): ");
		int cc = sc.nextInt();
		
		System.out.print("Data de nascimento(Ex: 11-05-2002): ");
		String data = kb.nextLine();
		
		String[] Data = data.split("-");
		assert Data.length == 3: "Formato de data invalido";
		int[] Datai = new int[Data.length];
		for(int i = 0; i< Data.length; i++) {
			Datai[i]= Integer.parseInt(Data[i]);
		}	
		Data dNasc = new Data(Datai[0],Datai[1],Datai[2]); 
		Pessoa p = new Pessoa(name, cc, dNasc);
		Lista.add(p);
		
		System.out.print("Nova pessoa adicionada.");
		System.out.println();	
	}
	
	public static void rmvP() {
		System.out.print("C.C. a eliminar(Verifique se tem apenas 8 digitos): ");
		int ccdel = sc.nextInt();
		for(int i =0; i< Lista.size();i++) {
			if(Lista.get(i).cc()== ccdel) {
				Lista.remove(i);
				System.out.printf("C.C.%d removido.\n", ccdel);
				break;	
			}
			else {System.out.println("C.C. nao encontrado...");}
		}
		System.out.println();
		
	}
	
	public static void oNome() {
		Lista.sort(Comparator.comparing(Pessoa::nome));
		System.out.println("Lista ordenada por nome. Opcao 3 para analisar.");
		
	}
	
	public static void oCC() {
		Lista.sort(Comparator.comparing(Pessoa::cc));
		System.out.println("Lista ordenada por C.C. Opcao 3 para analisar.");
	}
}
