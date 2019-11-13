package aula3;

import java.util.*;

public class Ex3_4 {
	static LinkedList<Video> Lista = new LinkedList<Video>();
	static LinkedList<Video> videosAl = new LinkedList<Video>();
	static LinkedList<Cliente> clientes = new LinkedList<Cliente>();
	static Hashtable<Integer, Integer> videosR = new Hashtable<Integer, Integer>();
	private static int numSoc=0, nVids;
	private static boolean firstSeen = false;
	static Scanner sc = new Scanner(System.in);
	static Scanner kb = new Scanner(System.in);
	static Scanner ler = new Scanner(System.in);
	static Scanner scf = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("Numero maximo de videos p/cliente: ");
		nVids = sc.nextInt();
		int option;
		do {
			System.out.println("__________________Menu_____________________");
			System.out.println("|1-  Adicionar Video-----------------------|");
			System.out.println("|2-  Remover Video-------------------------|");
			System.out.println("|3-  Mostrar Lista de Videos Completa------|");
			System.out.println("|4-  Registar Cliente----------------------|");
			System.out.println("|5-  Remover Cliente-----------------------|");
			System.out.println("|6-  Requisitar Video----------------------|");
			System.out.println("|7-  Devolucao Video-----------------------|");
			System.out.println("|8-  Ver estado de um Video----------------|");
			System.out.println("|9-  Clientes por Video--------------------|");
			System.out.println("|10- Rating por Video----------------------|");
			System.out.println("|0-  Sair----------------------------------|");
			System.out.println("‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾\n");
			do {
				System.out.print("Escolha: ");
				option = sc.nextInt();
				ler.nextLine();											//<-- Esta linha foi introduzida porque o java costuma
			}while(option<0 || option > 11);							//dar skip num nextLine() se antes estiver um nextInt
			switch(option) {											//Por isso, às vezes, é preciso carregar uma vez a mais 					
			case 0: System.exit(0);										//no Enter

			case 1:
				addV();
				break;

			case 2:
				remV();
				break;

			case 3:
				showList();
				break;

			case 4:
				registerClient();	
				break;
				
			case 5:
				remClient();
				break;

			case 6:		
				checkOut();
				break;
			
			case 7:
				checkIn();
				break;
				
			case 8:
				requestState();
				break;
				
			case 9:
				showClientsPerVideo();
				break;
				
			case 10:
				showRating();
				break;

			}
		}while(option != 0);

	}
	
	private static void checkIn() {
		if(videosAl.size()>0){
			firstSeen = true;
			int id, numSoc;
			do{
				System.out.print("Introduza o número de sócio: ");
				numSoc = sc.nextInt();
			}
			while(numSoc<0 || numSoc>clientes.size());
			do{
				System.out.print("Introduza o ID do vídeo a devolver: ");
				id = ler.nextInt();
			}
			while(id<1 || id>Lista.size());
			boolean found = false;
			Video v;
			for(int i=0; i<videosAl.size(); i++){
				if(videosAl.get(i).getID()==id){
					v = videosAl.get(i);
					videosAl.remove(i);
					if(getNumVids(numSoc)-2==0) {
						videosR.put(numSoc, 0);
					}
					else {
						videosR.put(numSoc, getNumVids(numSoc)-2);
					}
					found =true;
					double rat;
					do {
						System.out.print("De 1 a 10, quanto gostou do vídeo que requisitou?");
						rat = scf.nextDouble();
					}
					while(rat<0 || rat>10);
					int rating = (int) rat;
					v.getRating().add(rating);
				}
			}
			if(found){
				System.out.println("Vídeo devolvido com sucesso!");
			}
			else{
				System.out.println("Vídeo não encontrado!");
			}
		}
		else{
			System.out.println("Não existem vídeos requisitados!");
		}
	}

	private static void checkOut() {
		if(Lista.size()>0 && clientes.size()>0){
			int id, numSoc;
			boolean restricted = false;
			do{
				System.out.print("Introduza o número de sócio: ");
				numSoc = sc.nextInt();
			}
			while(numSoc<0 || numSoc>clientes.size());
			do{
				System.out.print("Introduza o ID do vídeo a requisitar: ");
				id = ler.nextInt();
			}
			while(id<1 || id>Lista.size());
			boolean mRequests = moreRequests(numSoc);
			Const.Age age = Const.Age.ALL;
			for(int j=0; j<Lista.size(); j++){
				if(Lista.get(j).getID()==id){
					age = Lista.get(j).getIdade();
				}
			}
			if(clientes.size()>0){
				for(int i=0; i<clientes.size(); i++){
					if(clientes.get(i).getNumSoc()==numSoc){
						int idade = clientes.get(i).getIdade();
						if(!canRequest(idade, age) && mRequests){restricted=true;}
					}
				}
			}
			boolean found = false, req = false;
			Video v;
			for(int i=0; i<videosAl.size(); i++){
				if(videosAl.get(i).getID()==id && !restricted && mRequests){
					req = true;
					break;
				}
			}
			for(int j=0;j<Lista.size();j++){
				if(Lista.get(j).getID()==id && !req && mRequests && !restricted){
					v = Lista.get(j);
					videosAl.add(v);
					videosR.put(numSoc, getNumVids(numSoc));
					found =true;
					if(clientes.size()>0){
						for(int k=0;k<clientes.size();k++){
							if(clientes.get(k).getNumSoc()==numSoc){
								v.getClientes().add(clientes.get(k));
							}
						}
					}					
				}
			}
			
			if(found){
				System.out.println("Vídeo requisitado com sucesso!");
			}
			else if(req){
				System.out.println("Vídeo não disponível de momento!");
			}
			else if(restricted){
				System.out.println("Vídeo não adequado à sua idade!");
			}
			else if(!mRequests) {
				System.out.println("Já chegou ao máximo de vídeos que pode requisitar!");
			}
			else{
				System.out.println("Vídeo não encontrado!");
			}
		}
		else{
			System.out.println("De momento, não há vídeos registados!");
		}
		
	}
	
	private static void showClientsPerVideo(){
		int id;
		do{
			System.out.print("Introduza o ID do vídeo: ");
			id = scf.nextInt();
		}
		while(id<1 || id>Lista.size());
		boolean found = false;
		for(int i=0;i<Lista.size();i++){
			if(Lista.get(i).getID()==id){
				Video v = Lista.get(i);
				found = true;
				if(v.getClientes().size()>0){
					for(int j=0;j<v.getClientes().size();j++){
						System.out.println(v.getClientes().get(i).toString());
					}
				}				
			}
		}
		if(!found){
			System.out.println("Vídeo não encontrado!");
		}
	}
	
	private static void showRating(){
		if(firstSeen){
			for(int i=0;i<Lista.size();i++){
					System.out.println(Lista.get(i).showRating());
			}
		}
		else{
			System.out.println("Ainda não foi atribuído rating a nenhum vídeo!");
		}
	}

	private static void registerClient() {
		System.out.print("Primeiro nome?");
		String nome = scf.next();
		System.out.print("Último nome?");
		String sNome = kb.next();
		int cc;
		do{
			System.out.print("CC?");
			cc = ler.nextInt();
		}
		while(!checkNums(cc, 8) || numExists(cc, "cc", true));
		numSoc++;
		System.out.print("Data de inscrição?(dd/mm/aaaa)");
		String dataIns = kb.next();
		int dia, mes, ano;
		dia = Integer.parseInt(dataIns.split("/")[0]);
		mes = Integer.parseInt(dataIns.split("/")[1]);
		ano = Integer.parseInt(dataIns.split("/")[2]);
		Data inscricao = new Data(dia, mes, ano);
		System.out.print("Data de nascimento?(dd/mm/aaaa)");
		String dNasc = sc.next();
		int dia1, mes1, ano1;
		dia1 = Integer.parseInt(dNasc.split("/")[0]);
		mes1 = Integer.parseInt(dNasc.split("/")[1]);
		ano1 = Integer.parseInt(dNasc.split("/")[2]);
		Data bDay = new Data(dia1, mes1, ano1);
		String type;
		do{
			System.out.print("Estudante ou Funcionário?(e/f)");
			type = kb.next();
			type=type.toLowerCase();
			if(type.charAt(0)=='e'){
				int nMec;
				do{
					System.out.print("Número mecanográfico?");
					nMec = scf.nextInt();
				}
				while(numExists(nMec, "nMec", true));
				System.out.print("Curso(sigla/acrónimo)?");
				String curso = kb.next();
				Estudante e = new Estudante(nome+" "+sNome, cc, numSoc, inscricao, bDay, type.charAt(0), nMec, curso);
				clientes.add(e);
			}
			else if(type.charAt(0)=='f'){
				int numFunc;
				do{
					System.out.print("Número de funcionário?");
					numFunc = scf.nextInt();
				}
				while(numExists(numFunc, "numFunc", true));
				int nif;
				do{
					System.out.print("NIF?");
					nif = ler.nextInt();
				}
				while(!checkNums(nif, 9) && numExists(nif, "nif", true));
				Funcionario f = new Funcionario(nome+" "+sNome, cc, numSoc, inscricao, bDay, type.charAt(0), numFunc, nif);
				clientes.add(f);

			}
		}
		while(type.charAt(0)!='e' && type.charAt(0)!='f');
		System.out.println("O seu número de sócio é "+numSoc+"!");
		System.out.println("Sucesso!");
	}
	
	private static void remClient(){
		if(clientes.size()>0){
			int numSoc;
			do{
				System.out.print("Introduza o número de sócio do cliente a remover:");
				numSoc = ler.nextInt();
			}
			while(numSoc<0 || numSoc>clientes.size());
			boolean found = false;
			do{
				for(int i=0;i<clientes.size();i++){
					if(clientes.get(i).getNumSoc()==numSoc){
						clientes.remove(i);
						found = true;
					}
				}
				if(found){
					System.out.println("Cliente removido com sucesso!");
					numSoc=0;
				}
				else{
					System.out.println("Cliente não encontrado! Por favor, tente novamente ou volte para o menu(0)!");
					System.out.print("->");
					numSoc = sc.nextInt();
				}
			}
			while(numSoc!=0);
		}
		else{
			System.out.println("Ainda não há clientes registados!");
		}
	}

	private static void addV() {
		int categorySel=0;
		int ageSel;
		int cont =0;
		Const.Category category = null;
		Const.Age age = null;
		System.out.print("Nome do Video: ");
		String name = ler.nextLine();
		
		System.out.println("Categoria: ");
		System.out.print("1-Acao,\n2-Comedia,\n3-Infantil,\n4-Drama,\n5-Outros\nOpcao: ");
		
		do {
			if(cont!=0) {
				System.out.print("Categoria nao definida. Por favor tente de novo: ");
			}
			categorySel = sc.nextInt();
			cont++;
		}while(categorySel<1 || categorySel >5);
		
		switch(categorySel) {
		case 1: 
			category = Const.Category.Acao;
			break;	
		case 2:
			category = Const.Category.Comedia;
			break;
		case 3:
			category = Const.Category.Infantil;
			break;
		case 4:
			category = Const.Category.Drama;
			break;
		case 5:
			category = Const.Category.Outros;
			break;
		}
		cont=0;
		
		System.out.println("Idade: ");
		System.out.print("1-ALL,\n2-M6,\n3-M12,\n4-M16,\n5-M18\nOpcao: ");
		
		do {
			if(cont!=0) {
				System.out.print("Idade nao definida. Por favor tente de novo: ");
			}
			ageSel = sc.nextInt();
			cont++;
		}while(ageSel<1 || ageSel >5);
		
		switch(ageSel) {
		case 1: 
			age = Const.Age.ALL;
			break;	
		case 2:
			age = Const.Age.M6;
			break;
		case 3:
			age = Const.Age.M12;
			break;
		case 4:
			age= Const.Age.M16;
			break;
		case 5:
			age = Const.Age.M18;
			break;
		}
		
		
		
		Video v= new Video(name, category, age, Lista.size());
		Lista.add(v);
		
		System.out.println("Novo Video adicionado.");
		System.out.println(v.toString());
		System.out.println();	
	}
	
	private static void remV() {
		if(Lista.size()>0){
			int find=0;
			int cont=0;
			int siz = Lista.size();
			showList();
			System.out.println("Digite o ID do vídeo que pretende remover: ");
			do {
				if(cont!=0) {
					System.out.print("ID nao encontrado. Por favor tente de novo: ");
				}
				find=sc.nextInt();
				cont++;
			}while(find<0 || find>Lista.size());
			Lista.remove(find-1);
			if(Lista.size() ==siz-1){
				System.out.println("Video removido!\n ");
			}
		}
		else{
			System.out.println("De momento, ainda não há vídeos registados!");
		}
	}
	
	private static void showList() {
		if(Lista.size()>0){
			System.out.printf("\n Lista de Videos:\n");
			for(int i = 0; i < Lista.size(); i++){
				System.out.println(Lista.get(i).toString());
			}
			System.out.println();	
		}
		else{
			System.out.println("De momento, não há vídeos registados!");
		}
	}
	
	private static boolean checkNums(int num, int size){
		String check = Integer.toString(num);
		if(check.length()==size){return true;}
		else{return false;}
	}
	
	private static boolean numExists(int num, String comp, boolean b) {
		for(int i=0;i<clientes.size();i++){
			if(comp.equals("cc")){
				if(clientes.get(i).getCc()==num && b){
					System.out.println("Esse número já existe!");
					return true;}
				else{return false;}
			}
			else if(comp.equals("numSoc")){
				if(clientes.get(i).getNumSoc()==num && b){
					System.out.println("Esse número já existe!");
					return true;}
				else{return false;}
			}
			else if(comp.equals("nMec")){
				if(clientes.get(i).getType()=='e' && b){
					Estudante e = (Estudante) clientes.get(i);
					if(e.getNmec()==num) {
						System.out.println("Esse número já existe!");
						return true;}
				}	
				else{return false;}
			}
			else if(comp.equals("numFunc")){
				if(clientes.get(i).getType()=='f' && b){
					Funcionario f = (Funcionario) clientes.get(i);
					if(f.getNumFunc()==num) {
						System.out.println("Esse número já existe!");
						return true;}
				}
				else{return false;}
			}
			else if(comp.equals("nif")){
				if(clientes.get(i).getType()=='f' && b){
					Funcionario f = (Funcionario) clientes.get(i);
					if(f.getNif()==num) {
						System.out.println("Esse número já existe!");
						return true;}
				}
				else{return false;}
			}
			else{return false;}
		}
		return false;
	}
	
	
	
	private static boolean canRequest(int idade, Const.Age age){
		if(age == Const.Age.ALL){return true;}
		else if(age == Const.Age.M6){ return idade>=6;}
		else if(age == Const.Age.M12){ return idade>=12;}
		else if(age == Const.Age.M16){ return idade>=16;}
		else if(age == Const.Age.M18){ return idade>=18;}
		else{return false;}
	}
	
	private static boolean isRequested(int id){
		for(int i=0; i<videosAl.size(); i++){
			if(videosAl.get(i).getID()==id){
				return true;
			}
		}
		return false;
	}
	
	private static void requestState(){
		if(Lista.size()>0){
			int id;
			do{
				System.out.print("Introduza o ID do vídeo: ");
				id = sc.nextInt();
			}
			while(id<1 || id>Lista.size());
			if(isRequested(id)){
				System.out.println("O vídeo não se encontra disponível!");
			}
			else{
				System.out.println("O vídeo está disponível!");
			}
		}
		else{
			System.out.println("De momento, não há vídeos registados!");
		}
	}
	
	private static boolean moreRequests(int numSoc){
		return getNumVids(numSoc)<=nVids;
	}
	
	private static int getNumVids(int numSoc) {
		int num=1;
		if(videosR.containsKey(numSoc)) {
			num = videosR.get(numSoc)+1;
		}
		return num;
	}
}










