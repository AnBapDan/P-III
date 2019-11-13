package aula5;

import java.util.*;

public class Ex5_2 {
	
	static LinkedList<Veiculo> lista = new LinkedList<Veiculo>();
	static Scanner sc = new Scanner(System.in);
	static Scanner kb = new Scanner(System.in);
	static Scanner ler = new Scanner(System.in);
	static Scanner scf = new Scanner(System.in);
	

	public static void main(String[] args) {
		String option;
		do {
			per("__________________Menu_____________________");
			per("|1-  Adicionar Veiculo Normal--------------|");
			per("|2-  Remover Veiculo Normal----------------|");
			per("|3-  Mostrar Lista de Veiculos Normais-----|");
			per("|4-  Adicionar Veiculo policial------------|");
			per("|5-  Remover Veiculo policial--------------|");
			per("|6-  Mostrar lista de veiculos da policia--|");
			per("|7-  Mostrar Tipo de Policia---------------|");
			per("|8-  Ordenar todos os veiculos por ano-----|");
			per("|9-  Mostrar lista de specs dos normais----|");
			per("|10- Mostrar lista de specs dos policiais--|");
			per("|11- Mostrar lista completa de veiculos----|");
			per("|0-  Sair----------------------------------|");
			per("‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾\n");
			do {
				pr("Escolha: ");
				option = sc.next();														//<-- Esta linha foi introduzida porque o java costuma
			}while(!matchInputs(option,"num") && val(option)<0 || val(option) > 11);	//dar skip num nextLine() se antes estiver um next
			ler.nextLine();																//Por isso, às vezes, é preciso carregar uma vez a mais 					
			switch(val(option)) {														//no Enter			
			case 0: System.exit(0);
			case 1: addV();break;
			case 2: remV();break;
			case 3: showList();break;
			case 4: addP();break;
			case 5: remP();break;
			case 6: showPList();break;
			case 7: showPType();break;
			case 8: 
				if(lista.size()>0) {
					Veiculo[] listaV = sortYear();
					UtilCompare.sortArray(listaV);
					for(int i=0;i<listaV.length;i++) {
						Veiculo v= listaV[i];
						if(v.getClass().getSimpleName().equalsIgnoreCase("automovelpolicia")) {
							per(v.getID()+") Automóvel da Policia -> "+v.getAno()+" - "+v.getColor());
						}
						else if(v.getClass().getSimpleName().equalsIgnoreCase("motopolicia")) {
							per(v.getID()+") Moto da Polícia -> "+v.getAno()+" - "+v.getColor());
						}
						else if(v.getClass().getSimpleName().equalsIgnoreCase("bicicletapolicia")) {
							per(v.getID()+") Bicicleta da Polícia -> "+v.getAno()+" - "+v.getColor());
						}
						else {
							per(v.getID()+") "+v.getClass().getSimpleName()+" -> "+v.getAno()+" - "+v.getColor());
						}
					}
				}
				else {per("Não há veículos registados!");}break;
			case 9: showSpecList();break;
			case 10: showPSpecList();break;
			case 11: showAll();break;
			}
		}
		while(val(option)!=0);
	}
	
	private static void addV() {
		String option;
		String[] s;
		Const.Color cor=null;
		do {
			pr("Tipo de Carro?");
			per("\n1-Automovel\n2-Moto\n3-Bicicleta");
			pr("Option -> ");
			option = scf.next();
		}while(!matchInputs(option, "num") && val(option)<7 && val(option)>0);
		switch(val(option)) {
		case 1: 
			s=getInfo(9, 1);
			for(Const.Color c: Const.Color.values()) {
				if(c.name().equals(s[1])) {
					cor = c;
				}
			}
			Veiculo a = new Automovel(val(s[0]),val(s[2]),val(s[3]),cor,s[8],val(s[4]),val(s[5]),val(s[6]),val(s[7]));
			lista.add(a);
			per("Veiculo adicionado com o ID "+a.getID());
			per("\n");
			break;
		case 2: 
			s=getInfo(9, 2);
			for(Const.Color c: Const.Color.values()) {
				if(c.name().equals(s[1])) {
					cor = c;
				}
			}
			Veiculo m = new Moto(val(s[0]),val(s[2]),val(s[3]),cor,s[8],val(s[4]),val(s[5]),val(s[6]),val(s[7]));
			lista.add(m);
			per("Veiculo adicionado com o ID "+m.getID());
			per("\n");
			break;
		case 3: 
			s=getInfo(4, 3);
			for(Const.Color c: Const.Color.values()) {
				if(c.name().equals(s[1])) {
					cor = c;
				}
			}
			Veiculo b = new Bicicleta(val(s[0]),val(s[2]),val(s[3]),cor);
			lista.add(b);
			per("Veiculo adicionado com o ID "+b.getID());
			per("\n");
			break;
		}
	}
	
	private static void remV() {
		if(lista.size()>0) {
			String mat;
			boolean found=false;
			do {
				pr("Introduza o ID do veiculo: ");
				mat=sc.next();
			}while(!matchInputs(mat,"word") && !strExists(mat));
			for(int i=0;i<lista.size();i++) {
				Veiculo v = lista.get(i);
				if(v.getID().equals(mat)) {
					lista.remove(i);
					found=true;
				}
			}
			if(found) {per("Removido!");}
			else {per("Veículo não encontrado!");}
		}
		else {
			per("Não há veículos registados!");
		}
	}

	private static void showList() {
		if(lista.size()>0) {
			for(int i=0;i<lista.size();i++) {
				Veiculo v = lista.get(i);
				if(v.getClass().getSimpleName().equalsIgnoreCase("automovel") || v.getClass().getSimpleName().equalsIgnoreCase("moto") || v.getClass().getSimpleName().equalsIgnoreCase("bicicleta")) {
					per(v.getID()+") "+v.getClass().getSimpleName()+" -> "+v.getAno()+" - "+v.getColor());
				}
			}
		}
		else {per("Não há veículos registados!");}
	}
	
	private static void addP() {
		String option;
		String[] s;
		Const.Color cor=null;
		Const.Emergency e=null;
		do {
			pr("Tipo de Carro?");
			per("\n1-Automovel Policial\n2-Moto Policial\n3-Bicicleta Policial");
			pr("Option -> ");
			option = scf.next();
		}while(!matchInputs(option, "num") && val(option)<7 && val(option)>0);
		switch(val(option)) {
		case 1: 
			String ans;
			s=getInfo(9,1);
			for(Const.Color c: Const.Color.values()) {
				if(c.name().equals(s[1])) {
					cor = c;
				}
			}
			do {
				per("Tipo de Unidade?\n1-INEM\n2-Bombeiros\n3-GNR\n4-PSP\n5-PJ");
				pr("Option -> ");
				ans=scf.next();
				switch(val(ans)) {
				case 1:e=Const.Emergency.INEM;break;
				case 2:e=Const.Emergency.Bombeiro;break;
				case 3:e=Const.Emergency.GNR;break;
				case 4:e=Const.Emergency.PSP;break;
				case 5:e=Const.Emergency.PJ;break;
				}
			}while(!matchInputs(ans,"num") && val(ans)<1 || val(ans)>5);
			Veiculo ap = new AutomovelPolicia(val(s[0]),val(s[2]),val(s[3]),cor,s[8],val(s[4]),val(s[5]),val(s[6]),val(s[7]),e);
			lista.add(ap);
			per("Veiculo adicionado com o ID "+ap.getID());
			per("\n");
			break;
		case 2: 
			String ans1;
			s=getInfo(9,2);
			for(Const.Color c: Const.Color.values()) {
				if(c.name().equals(s[1])) {
					cor = c;
				}
			}
			do {
				per("Tipo de Unidade?\n1-INEM\n2-Bombeiros\n3-GNR\n4-PSP\n5-PJ");
				ans1=scf.next();
				switch(val(ans1)) {
				case 1:e=Const.Emergency.INEM;break;
				case 2:e=Const.Emergency.Bombeiro;break;
				case 3:e=Const.Emergency.GNR;break;
				case 4:e=Const.Emergency.PSP;break;
				case 5:e=Const.Emergency.PJ;break;
				}
			}while(!matchInputs(ans1,"num") && val(ans1)<1 || val(ans1)>5);
			Veiculo mp = new MotoPolicia(val(s[0]),val(s[2]),val(s[3]),cor,s[8],val(s[4]),val(s[5]),val(s[6]),val(s[7]),e);
			lista.add(mp);
			per("Veiculo adicionado com o ID "+mp.getID());
			per("\n");
			break;
		case 3: 
			String ans11;
			s=getInfo(4,3);
			for(Const.Color c: Const.Color.values()) {
				if(c.name().equals(s[1])) {
					cor = c;
				}
			}
			do {
				per("Tipo de Unidade?\n1-INEM\n2-Bombeiros\n3-GNR\n4-PSP\n5-PJ");
				ans11=scf.next();
				switch(val(ans11)) {
				case 1:e=Const.Emergency.INEM;break;
				case 2:e=Const.Emergency.Bombeiro;break;
				case 3:e=Const.Emergency.GNR;break;
				case 4:e=Const.Emergency.PSP;break;
				case 5:e=Const.Emergency.PJ;break;
				}
			}while(!matchInputs(ans11,"num") && val(ans11)<1 || val(ans11)>5);
			Veiculo bp = new BicicletaPolicia(val(s[0]),val(s[2]),val(s[3]),cor,e);
			lista.add(bp);
			per("Veiculo adicionado com o ID "+bp.getID());
			per("\n");
			break;
		}
	}

	private static void remP() {
		if(lista.size()>0) {
			boolean found=false;
			String id;
			do {
				pr("Introduza o ID: ");
				id=kb.next();
			}while(!matchInputs(id,"num") && !strExists(id));
			for(int i=0;i<lista.size();i++) {
				Veiculo v = lista.get(i);
				if(v.getID().equals(id)) {
					lista.remove(i);
					found = true;
				}
			}
			if(found) {
				per("Removido!");
			}
			else {
				per("Veículo não encontrado!");
			}
		}
		else {per("Não há lista da polícia registados!");}
	}
	
	private static void showPList() {
		if(lista.size()>0) {
			for(int i=0;i<lista.size();i++) {
				Veiculo v = lista.get(i);
				if(v.getClass().getSimpleName().equalsIgnoreCase("automovelpolicia")) {
					per(v.getID()+") Automóvel da Polícia -> "+v.getAno()+" - "+v.getColor());
				}
				else if(v.getClass().getSimpleName().equalsIgnoreCase("motopolicia")) {
					per(v.getID()+") Moto da Polícia -> "+v.getAno()+" - "+v.getColor());
				}
				else if(v.getClass().getSimpleName().equalsIgnoreCase("bicicletapolicia")) {
					per(v.getID()+") Bicicleta da Polícia -> "+v.getAno()+" - "+v.getColor());
				}
			}
		}
		else {
			per("Não há veículos da polícia registados!");
		}
	}
	
	private static void showPType() {
		if(lista.size()>0) {
			for(int i=0;i<lista.size();i++) {
				Veiculo v = lista.get(i);
				if(v instanceof AutomovelPolicia) {
					per("Veiculo "+v.getID()+" -> "+((AutomovelPolicia) v).getTipo());
				}
				else if(v instanceof MotoPolicia) {
					per("Veiculo "+v.getID()+" -> "+((MotoPolicia) v).getTipo());
				}
				else if(v instanceof BicicletaPolicia) {
					per("Veiculo "+v.getID()+" -> "+((BicicletaPolicia) v).getTipo());
				}
			}
		}
		else {
			per("Não há veículos da polícia registados!");
		}
	}

	private static Veiculo[] sortYear() {
		Veiculo[] listaV;
		if(lista.size()>0) {
			listaV = new Veiculo[lista.size()];
			for(int i=0;i<lista.size();i++) {
				listaV[i]=lista.get(i);
			}
			return listaV;
		}
		else {return null;}
	}
	
	private static void showSpecList() {
		if(lista.size()>0) {
			for(int i=0;i<lista.size();i++) {
				Veiculo v = lista.get(i);
				if(v.getClass().getSimpleName().equalsIgnoreCase("automovel") || v.getClass().getSimpleName().equalsIgnoreCase("moto") || v.getClass().getSimpleName().equalsIgnoreCase("bicicleta")) {
					per(v.getID()+") "+v.toString());
				}
			}
		}
		else {
			per("Não há veículos registados!");
		}
	}
	
	private static void showPSpecList() {

		if(lista.size()>0) {
			for(int i=0;i<lista.size();i++) {
				Veiculo v = lista.get(i);
				if(v.getClass().getSimpleName().equalsIgnoreCase("automovelpolicia") || v.getClass().getSimpleName().equalsIgnoreCase("motopolicia") || v.getClass().getSimpleName().equalsIgnoreCase("bicicletapolicia")) {
					per(v.getID()+") "+v.toString());
				}
			}
		}
		else {
			per("Não há veículos registados!");
		}
	}

	private static void showAll() {
		if(lista.size()>0) {
			for(int i=0;i<lista.size();i++) {
				Veiculo v= lista.get(i);
				if(v.getClass().getSimpleName().equalsIgnoreCase("automovelpolicia")) {
					per(v.getID()+") Automóvel da Policia -> "+v.getAno()+" - "+v.getColor());
				}
				else if(v.getClass().getSimpleName().equalsIgnoreCase("motopolicia")) {
					per(v.getID()+") Moto da Polícia -> "+v.getAno()+" - "+v.getColor());
				}
				else if(v.getClass().getSimpleName().equalsIgnoreCase("bicicletapolicia")) {
					per(v.getID()+") Bicicleta da Polícia -> "+v.getAno()+" - "+v.getColor());
				}
				else {
					per(v.getID()+") "+v.getClass().getSimpleName()+" -> "+v.getAno()+" - "+v.getColor());
				}
			}
		}
		else {
			per("Não há veículos registados!");
		}
	}
	
	private static String[] getInfo(int n, int num) {
		String[] s = new String[n];
		switch(n) {
		case 4:
			String a;
			do {
				pr("Ano?");
				s[0] = sc.next();
			}while(!matchInputs(s[0],"num"));
			do {
				per("Cor?\n1-Vermelho\n2-Verde\n3-Azul\n4-Preto\n5-Branco\n6-Cinzento\n7-Amarelo");
				pr("Option -> ");
				a = kb.next();
				switch(val(a)) {
				case 1:
					s[1]=Const.Color.Vermelho.name();break;
				case 2:
					s[1]=Const.Color.Verde.name();break;
				case 3:
					s[1]=Const.Color.Azul.name();break;
				case 4:
					s[1]=Const.Color.Preto.name();break;
				case 5:
					s[1]=Const.Color.Branco.name();break;
				case 6:
					s[1]=Const.Color.Cinzento.name();break;
				case 7:
					s[1]=Const.Color.Amarelo.name();break;
				}
			}while(!matchInputs(a,"num") && val(a)<1 || val(a)>7);
			do {
				pr("Velocidade Máxima?");
				s[3] = ler.next();
			}while(!matchInputs(s[3],"num") && val(s[3])<100);
			break;
		case 9:
			String a1;
			do {
				pr("Ano?");
				s[0] = sc.next();
			}while(!matchInputs(s[0],"num"));
			do {
				per("Cor?\n1-Vermelho\n2-Verde\n3-Azul\n4-Preto\n5-Branco\n6-Cinzento\n7-Amarelo");
				pr("Option -> ");
				a1 = kb.next();
				switch(val(a1)) {
				case 1:
					s[1]=Const.Color.Vermelho.name();break;
				case 2:
					s[1]=Const.Color.Verde.name();break;
				case 3:
					s[1]=Const.Color.Azul.name();break;
				case 4:
					s[1]=Const.Color.Preto.name();break;
				case 5:
					s[1]=Const.Color.Branco.name();break;
				case 6:
					s[1]=Const.Color.Cinzento.name();break;
				case 7:
					s[1]=Const.Color.Amarelo.name();break;
				}
			}while(!matchInputs(a1,"num") && val(a1)<1 || val(a1)>7);
			do {
				pr("Velocidade Máxima?");
				s[3] = ler.next();
			}while(!matchInputs(s[3],"num") && val(s[3])<100);
			do {
				pr("Cilindrada?");
				s[4]=scf.next();
			}while(!matchInputs(s[4],"num") && val(s[4])<0);
			do {
				pr("Potência?");
				s[5]=kb.next();
			}while(!matchInputs(s[5],"num") && val(s[5])<0);
			do {
				pr("Consumo(l/100km)?");
				s[6]=sc.next();
			}while(!matchInputs(s[6],"num") && val(s[6])<0);
			do {
				pr("Combustive(l)?");
				s[7]=ler.next();
			}while(!matchInputs(s[7],"num") && val(s[7])<25);
			do {
				pr("Matrícula?");
				s[8]=scf.next();
			}while(!matchInputs(s[8],"word") && strExists(s[8]));
		}
		if(num==1) {s[2]="4";}
		else if(num==2 || num==3) {s[2]="2";}
		else return null;
		return s;
	}
	
	private static boolean matchInputs(String s, String type) {

		for(int i=0;i<s.length();i++) {
			char p=s.charAt(i);
			if(type.equals("num")) {
				if(Character.isLetter(p) || Character.isWhitespace(p)) {
					return false;
				}
			}
			else if(type.equals("word")) {
				if(Character.isDigit(p) || Character.isWhitespace(p)) {
					return false;
				}
			}
		}
		return true;
	}
	
	private static boolean strExists(String s) {
		if(lista.size()>0) {
			for(int i=0;i<lista.size();i++) {
				Veiculo v=lista.get(i);
				if(v.getID().equals(s)) {
					return true;
				}
			}
			return false;
		}else {return false;}
	}
	
	private static int val(String num) {
		int d;
		try {
			d = Integer.parseInt(num);
		}
		catch(Exception e) {
			d = -1;
		}
		return d;
	}
	
	private static void per(String s) {
		System.out.println(s);
	}

	private static void pr(String s) {
		System.out.print(s);
	}
}
