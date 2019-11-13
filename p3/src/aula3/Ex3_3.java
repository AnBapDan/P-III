package aula3;

import java.util.*;

public class Ex3_3 {
	
	static final Scanner ler = new Scanner(System.in);
	static final Scanner sc = new Scanner(System.in);
	static final Scanner cs = new Scanner(System.in);
	private static LinkedList<Viatura> viaturas = new LinkedList<Viatura>();
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int option;
		do {
			System.out.println("__________________Menu_____________________");
			System.out.println("|1-  Adicionar Ligeiro---------------------|");
			System.out.println("|2-  Adicionar Motociclo-------------------|");
			System.out.println("|3-  Adicionar Pesado de Passageiros-------|");
			System.out.println("|4-  Adicionar Pesado de Mercadorias-------|");
			System.out.println("|5-  Remover Viatura-----------------------|");
			System.out.println("|6-  Remover todas as Viaturas-------------|");
			System.out.println("|7-  Ver todas as viaturas-----------------|");
			System.out.println("|0-  Sair----------------------------------|");
			System.out.println("‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾\n");
			do {
				System.out.print("Opção-> ");
				option = sc.nextInt();
				ler.nextLine();											
			}while(option<0 || option > 7);	
			switch(option) {
			case 0:
				System.exit(0);
				break;
				
			case 1:
				addViatura("ligeiro");
				break;
				
			case 2:
				addViatura("moto");
				break;
				
			case 3:
				addViatura("pesPass");
				break;
			
			case 4:
				addViatura("pesMerc");
				break;
				
			case 5:
				remViatura();
				break;
				
			case 6:
				remAll();
				break;
				
			case 7:
				showViaturas();
				break;
			}
		}
		while(option!=0);
	}
	
	private static void addViatura(String viatura) {
		System.out.print("Cilindrada?");
		int cilindrada = cs.nextInt();
		System.out.print("Potência?");
		int potencia = ler.nextInt();
		int lotacao, pesoBruto;
		if(viatura.equals("ligeiro")) {
			do {
				System.out.print("Lotação?");
				lotacao = sc.nextInt();
				System.out.print("Peso bruto?");
				pesoBruto = cs.nextInt();
			}
			while(lotacao>5 || pesoBruto>3500);
		}
		else if(viatura.equals("moto")) {
			do {
				System.out.print("Lotação?");
				lotacao = sc.nextInt();
				System.out.print("Peso bruto?");
				pesoBruto = cs.nextInt();
			}
			while(lotacao>2 || pesoBruto>300);
		}
		else if(viatura.equals("pesPass")) {
			do {
				System.out.print("Lotação?");
				lotacao = sc.nextInt();
				System.out.print("Peso bruto?");
				pesoBruto = cs.nextInt();
			}
			while(lotacao<1 || pesoBruto<3500);
		}
		else if(viatura.equals("moto")) {
			do {
				System.out.print("Lotação?");
				lotacao = sc.nextInt();
				System.out.print("Peso bruto?");
				pesoBruto = cs.nextInt();
			}
			while(lotacao>2 || pesoBruto<3500);
		}
		else {
			lotacao=0;
			pesoBruto=0;
		}
		System.out.print("Primeiro nome do condutor?");
		String nome = ler.next();
		System.out.print("Último nome do condutor?");
		String sNome = sc.next();
		sNome = " "+sNome;
		int cc;
		do {
			System.out.print("CC?");
			cc = ler.nextInt();
		}
		while(numExists(cc) && !checkLength(cc, 8));
		System.out.print("Data de nascimento?(dd/mm/aaaa)");
		String dNasc = cs.next();
		int dia = Integer.parseInt(dNasc.split("/")[0]);
		int mes = Integer.parseInt(dNasc.split("/")[1]);
		int ano = Integer.parseInt(dNasc.split("/")[2]);
		if(viatura.equals("ligeiro")) {
			Ligeiro l = new Ligeiro(cilindrada, potencia, lotacao, pesoBruto, new Condutor(nome+sNome, cc, new Data(dia, mes, ano), Carta.Tipo.B));
			viaturas.add(l);
		}
		else if(viatura.equals("moto")) {
			Motociclo l = new Motociclo(cilindrada, potencia, lotacao, pesoBruto, new Condutor(nome+sNome, cc, new Data(dia, mes, ano), Carta.Tipo.A));
			viaturas.add(l);
		}
		else if(viatura.equals("pesPass")) {
			PesadoDePassageiros l = new PesadoDePassageiros(cilindrada, potencia, lotacao, pesoBruto, new Condutor(nome+sNome, cc, new Data(dia, mes, ano), Carta.Tipo.D));
			viaturas.add(l);
		}
		else if(viatura.equals("pesMerc")) {
			PesadoDeMercadorias l = new PesadoDeMercadorias(cilindrada, potencia, lotacao, pesoBruto, new Condutor(nome+sNome, cc, new Data(dia, mes, ano), Carta.Tipo.C));
			viaturas.add(l);
		}
		System.out.print("Viatura adicionada com sucesso!");
	}
	
	private static void remViatura() {
		if(viaturas.size()>0) {
			int cc;
			boolean found = false;
			System.out.print("CC do condutor do veículo a remover: ");
			cc = ler.nextInt();
			do {
				for(int i=0; i<viaturas.size(); i++) {
					if(viaturas.get(i).getCondutor().getCc()==cc) {
						viaturas.remove(i);
						found=true;
					}
				}
				if(found) {
					System.out.print("Viatura removida com sucesso!");
					cc=0;
				}
				else {
					System.out.print("Viatura não encontrada! Por favor, introduza novamente o CC do condutor ou volte para o menu(0):\n-> ");
					cc = cs.nextInt();
				}
			}
			while(cc!=0);
		}
		else {
			System.out.print("Não há viaturas registadas de momento!");
		}
	}
	
	private static void remAll() {
		if(viaturas.size()>0) {
			for(int i=0; i<viaturas.size(); i++) {
				viaturas.remove(i);
			}
			if(viaturas.size()==0) {
				System.out.print("Todas as viaturas removidas com sucesso!");
			}
			else {
				System.out.print("Não foram removidas todas as viaturas!");
			}
		}
		else {
			System.out.print("Não há viaturas registadas de momento!");
		}
	}
	
	private static void showViaturas() {
		if(viaturas.size()>0) {
			for(int i=0; i<viaturas.size(); i++) {
				System.out.print("Viatura "+i);
				System.out.println(viaturas.get(i).toString());
				System.out.println();
			}
		}
		else {
			System.out.print("Não há viaturas registadas de momento!");
		}
	}
	
	private static boolean numExists(int num) {
		for(int i=0; i<viaturas.size(); i++) {
			if(viaturas.get(i).getCondutor().getCc()==num) {
				return true;
			}
		}
		return false;
	}
	
	private static boolean checkLength(int num, int size) {
		String a = Integer.toString(num);
		if(a.length()==size) {
			return true;
		}
		else {
			return false;
		}
	}
	
	

}

























