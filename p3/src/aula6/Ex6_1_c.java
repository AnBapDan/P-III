package aula6;

import java.util.LinkedList;
import java.util.Scanner;
import java.io.*;

public class Ex6_1_c {
	
	static LinkedList<Alimento> alimentos = new LinkedList<Alimento>();
	static LinkedList<Alimento> alimentosUsados = new LinkedList<Alimento>();
	static LinkedList<Prato> ementa = new LinkedList<Prato>();
	static LinkedList<Prato> pratos = new LinkedList<Prato>();
	static Scanner sc = new Scanner(System.in);
	static Scanner kb = new Scanner(System.in);
	static Scanner ler = new Scanner(System.in);
	static Scanner scf = new Scanner(System.in);
	static File f = new File("Ementas.txt");
	static  final String[] comida = {"carne", "peixe", "cereal", "legume"};

	public static void main(String[] args) throws IOException{
		if(f.exists())load();
		String option;
		do {
			per("__________________Menu_____________________");
			per("|1-  Adicionar Alimento--------------------|");
			per("|2-  Mostrar Todos os Alimentos------------|");
			per("|3-  Criar Prato---------------------------|");
			per("|4-  Remover Prato-------------------------|");
			per("|5-  Selecionar Prato----------------------|");
			per("|6-  Adicionar Ingrediente num Prato-------|");
			per("|7-  Remover Ingrediente de um Prato-------|");
			per("|8-  Adicionar Prato na Ementa-------------|");
			per("|9-  Remover Prato da Ementa---------------|");
			per("|10- Mostrar Ementa------------------------|");
			per("|0-  Sair----------------------------------|");
			per("‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾\n");
			printSave();
			do {
				pr("Escolha: ");
				option = sc.next();														
			}while(!matchInputs(option,"num") && val(option)<0 || val(option) > 10);	
			switch(vali(option)) {																	
			case 0: printSave();System.exit(0);
			case 1: addAlimento();break;
			case 2: showAlimento();break;
			case 3: addPrato();break;
			case 4: remPrato();break;
			case 5: showPrato();break;
			case 6: addPIng();break;
			case 7: remPIng();break;
			case 8: addPEmenta();break;
			case 9: remPEmenta();break;
			case 10: showEmenta();break;
			}
		}
		while(val(option)!=0);
	}

	private static void addAlimento() {
		String tipo, ch;
		do {
			pr("Alimento\n1 - Carne\n2 - Peixe\n3 - Cereal\n4 - Legume");
			tipo = ler.next();
		}while(!matchInputs(tipo,"word") && val(tipo)<1 || val(tipo)>4);
		String[] s = getInfo();
		switch(vali(tipo)) {
			case 1:
				Const.VariedadeCarne var=null;
				do {
					per("Variedade de Carne\n1 - Vaca\n2 - Porco\n3 - Peru\n4 - Frango\n5 - Outra");
					pr("Escolha -> ");
					ch = sc.next();
				}while(!matchInputs(ch,"num") && val(ch)<1 || val(ch)>5);
				switch(vali(ch)) {
					case 1: var=Const.VariedadeCarne.vaca;break;
					case 2: var=Const.VariedadeCarne.porco;break;
					case 3: var=Const.VariedadeCarne.peru;break;
					case 4: var=Const.VariedadeCarne.frango;break;
					case 5: var=Const.VariedadeCarne.outra;break;
				}
				Alimento c = new Carne(var,val(s[0]),val(s[1]),val(s[2]));
				alimentos.add(c);
				break;
			case 2:
				Const.TipoPeixe var1=null;
				do {
					per("Tipo de Peixe\n1 - Congelado\n2 - Fresco");
					pr("Escolha -> ");
					ch = sc.next();
				}while(!matchInputs(ch,"num") && val(ch)<1 || val(ch)>2);
				switch(vali(ch)) {
					case 1: var1=Const.TipoPeixe.congelado;break;
					case 2: var1=Const.TipoPeixe.fresco;break;
				}
				Alimento p = new Peixe(var1,val(s[0]),val(s[1]),val(s[2]));
				alimentos.add(p);
				break;
			case 3:
				String nome;
				do {
					pr("Tipo de cereal -> ");
					nome=kb.next();
				}while(!matchInputs(nome,"word"));
				Alimento c1 = new Cereal(nome,val(s[0]),val(s[1]),val(s[2]));
				alimentos.add(c1);
				break;
			case 4: 
				String nome1;
				do {
					pr("Tipo de legume -> ");
					nome1=kb.next();
				}while(!matchInputs(nome1,"word"));
				Alimento l = new Cereal(nome1,val(s[0]),val(s[1]),val(s[2]));
				alimentos.add(l);
				break;
		}
		
	}
	
	private static void showAlimento() {
		if(alimentos.size()>0) {
			for(Alimento i: alimentos) {
				per(i.toString());
			}
		}
		else {
			per("Não há alimentos registados!");
		}
	}
	
	private static void addPrato() {
		if(alimentos.size()>alimentosUsados.size() && alimentos.size()>0) {
			String num, nome, al;
			int ctrl=0;
			do {
				pr("Nome do prato (1 palavra) -> ");
				nome = kb.next();
			}while(!matchInputs(nome,"word") && nomeExists(nome));
			Prato p = new Prato(nome);
			pratos.add(p);
			do {
				pr("Número de ingredientes -> ");
				num = scf.next();
			}while(!matchInputs(num,"num") && val(num)>0);
			for(int i=0;i<val(num);i++) {
				do {
					ctrl=0;
					do {
						pr("Ingrediente a adicionar\n1 - Carne\n2 - Peixe\n3 - Cereal\n4 - Legume\nEscolha -> ");
						al = ler.next();
					}while(!matchInputs(al,"num") && !alExists(al) && val(al)<1 || val(al)>4);
					switch(vali(al)) {
						case 1: try{p.addIngrediente(alimentos.get(getAl("carne")));}catch(Exception e) {ctrl=1;per("Não há alimentos desse tipo!");};break;
						case 2: try{p.addIngrediente(alimentos.get(getAl("peixe")));}catch(Exception e) {ctrl=1;per("Não há alimentos desse tipo!");};break;
						case 3: try{p.addIngrediente(alimentos.get(getAl("cereal")));}catch(Exception e) {ctrl=1;per("Não há alimentos desse tipo!");};break;
						case 4: try{p.addIngrediente(alimentos.get(getAl("legume")));}catch(Exception e) {ctrl=1;per("Não há alimentos desse tipo!");};break;
					}
				}while(ctrl == 1);
			}
			
		}else {per("Não há alimentos registados!");}
	}
	
	private static void remPrato() {
		if(pratos.size()>0) {
			String nome;
			do {
				pr("Introduza o nome do prato -> ");
				nome = ler.next();
			}while(!matchInputs(nome,"word") && !nomeExists(nome));
			for(Prato p: pratos) {
				if(nome.equals(p.getNome())) {
					Alimento[] al = p.getComposicaotoArray();
					for(Alimento a: al) {
						if(alimentosUsados.contains(a)) {
							alimentosUsados.remove(a);
						}
					}
					pratos.remove(p);
					if(ementa.contains(p))ementa.remove(p);
				}
			}
		}else {per("Não há pratos registados!");}
	}
	
	private static void showPrato() {
		if(pratos.size()>0) {
			String nome;
			do {
				pr("Nome do prato -> ");
				nome = kb.next();
			}while(!matchInputs(nome,"word") && !nomeExists(nome));
			for(Prato p:pratos) {
				if(p.getNome().equalsIgnoreCase(nome)) {
					per(p.toString());
				}
			}
		}else {per("Não há pratos registados!");}
	}

	private static void addPIng(){
		if(pratos.size()>0) {
			String nome, ch;
			int ctrl=0;
			Prato p=null;
			do {
				pr("Nome do prato -> ");
				nome = kb.next();
			}while(!matchInputs(nome,"word") && !nomeExists(nome));
			do {
				ctrl=0;
				do {
					pr("Ingrediente a adicionar\n1 - Carne\n2 - Peixe\n3 - Cereal\n4 - Legume\nEscolha: ");
					ch = sc.next();
				}while(!matchInputs(ch,"num") && !alExists(ch) && val(ch)<1 || val(ch)>4);
				for(Prato p1: pratos) {
					if(p1.getNome().equals(nome)){p=p1;}
				}
				switch(vali(ch)) {
					case 1: try{p.addIngrediente(alimentos.get(getAl("carne")));}catch(Exception e) {ctrl=1;per("Não há alimentos desse tipo!");};break;
					case 2: try{p.addIngrediente(alimentos.get(getAl("peixe")));}catch(Exception e) {ctrl=1;per("Não há alimentos desse tipo!");};break;
					case 3: try{p.addIngrediente(alimentos.get(getAl("cereal")));}catch(Exception e) {ctrl=1;per("Não há alimentos desse tipo!");};break;
					case 4: try{p.addIngrediente(alimentos.get(getAl("legume")));}catch(Exception e) {ctrl=1;per("Não há alimentos desse tipo!");};break;
				}
			}while(ctrl==1);
		}else {per("Não há pratos registados!");}
	}

	private static void remPIng(){
		if(pratos.size()>0) {
			String nome, ch;
			int ctrl=0;
			Prato p=null;
			do {
				pr("Nome do prato -> ");
				nome = kb.next();
			}while(!matchInputs(nome,"word") && !nomeExists(nome));
			do {
				do {
					pr("Ingrediente a remover\n1 - Carne\n2 - Peixe\n3 - Cereal\n4 - Legume\nEscolha: ");
					ch = sc.next();
				}while(!matchInputs(ch,"num") && val(ch)<1 || val(ch)>4);
				for(Prato p1: pratos) {
					if(p1.getNome().equals(nome)){p=p1;}
				}
				switch(vali(ch)) {
				case 1: try{p.remIngrediente(alimentosUsados.get(remAl("carne",p)));alimentosUsados.remove(alimentosUsados.get(remAl("carne",p)));}catch(Exception e) {ctrl=1;per("Não há alimentos desse tipo no prato!");};break;
				case 2: try{p.remIngrediente(alimentosUsados.get(remAl("peixe",p)));alimentosUsados.remove(alimentosUsados.get(remAl("peixe",p)));}catch(Exception e) {ctrl=1;per("Não há alimentos desse tipo no prato!");};break;
				case 3: try{p.remIngrediente(alimentosUsados.get(remAl("cereal",p)));alimentosUsados.remove(alimentosUsados.get(remAl("cereal",p)));}catch(Exception e) {ctrl=1;per("Não há alimentos desse tipo no prato!");};break;
				case 4: try{p.remIngrediente(alimentosUsados.get(remAl("legume",p)));alimentosUsados.remove(alimentosUsados.get(remAl("legume",p)));}catch(Exception e) {ctrl=1;per("Não há alimentos desse tipo no prato!");};break;
				}
			}while(ctrl==1);
		}else {per("Não há pratos registados!");}
	}
	
	private static void addPEmenta() {
		if(pratos.size()>0) {
			String nome;
			do {
				pr("Nome do prato a adicionar à ementa -> ");
				nome = ler.next();
			}while(!matchInputs(nome,"word") && !nomeExists(nome));
			for(Prato p: pratos) {
				if(p.getNome().equals(nome)) {
					ementa.add(p);
				}
			}
		}else {per("Não há pratos registados!");}
	}
	
	private static void remPEmenta(){
		if(ementa.size()>0) {
			String nome;
			do {
				pr("Nome do prato a remover -> ");
				nome = scf.next();
			}while(!matchInputs(nome,"word") && !nomeExists(nome));
			for(Prato p:ementa) {
				ementa.remove(p);
			}
		}else {per("Não há pratos na ementa!");}
	}

	private static void showEmenta(){
		if(ementa.size()>0) {
			for(Prato p: ementa) {
				per(p.toString());
			}
		}else {per("Não há pratos na ementa!");}
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
	
	private static double val(String num) {
		double d;
		try {
			d = Double.parseDouble(num);
		}
		catch(Exception e) {
			d = -1.0;
		}
		return d;
	}
	
	private static int vali(String num) {
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

	private static String[] getInfo() {
		String[] s = new String[3];
		do {
			pr("Proteínas -> ");
			s[0] = sc.next();
		}while(!matchInputs(s[0],"num") && val(s[0])<0);
		do {
			pr("Calorias -> ");
			s[1] = scf.next();
		}while(!matchInputs(s[1],"num") && val(s[1])<0);
		do {
			pr("Peso -> ");
			s[2] = kb.next();
		}while(!matchInputs(s[2],"num") && val(s[2])<=0);
		return s;
	}

	private static boolean alExists(String a) {
		for(int i=0;i<alimentos.size();i++) {
			if(comida[vali(a)].equalsIgnoreCase(alimentos.get(i).getClass().getSimpleName()))return true;
		}
		return false;
	}

	private static int getAl(String s) {
		for(int i=0;i<alimentos.size();i++) {
			if(alimentos.get(i).getClass().getSimpleName().equalsIgnoreCase(s) && !alimentosUsados.contains(alimentos.get(i))) {
				alimentosUsados.add(alimentos.get(i));
				return i;
			}
		}
		return -1;
	}

	private static int remAl(String s,Prato p) {
		int cont = -1;
		for(int j=0;j<p.getComposicaotoArray().length;j++) {
			per(p.getComposicaotoArray()[j].getClass().getSimpleName().equalsIgnoreCase(s)+"");
			if(p.getComposicaotoArray()[j].getClass().getSimpleName().equalsIgnoreCase(s)) {
				cont = j;
			}
		}
		for(int i=0;i<alimentosUsados.size();i++) {
			Alimento a = alimentosUsados.get(i);
			try {
				per(a.equals(p.getComposicaotoArray()[cont])+"");
				if(a.equals(p.getComposicaotoArray()[cont])) {
					return i;
				}
			}catch(Exception e) {break;}
		}
		return -1;
	}
	
	private static boolean nomeExists(String s) {
		for(Prato i:pratos) {
			if(i.getNome().equalsIgnoreCase(s)) {
				return true;
			}
		}
		return false;
	}

	private static void printSave() throws IOException {
		PrintWriter p = new PrintWriter(f.getAbsolutePath());
		for(Alimento a:alimentos) {
			if(a instanceof Carne) {
				p.println("a1-carne-"+((Carne) a).getTipo()+"//"+a.getProteina()+"//"+a.getCalorias()+"//"+a.getPeso());
			}
			else if(a instanceof Peixe) {
				p.println("a1-peixe-"+((Peixe) a).getTipo()+"//"+a.getProteina()+"//"+a.getCalorias()+"//"+a.getPeso());
			}
			else if(a instanceof Cereal) {
				p.println("a1-cereal-"+((Cereal) a).getNome()+"//"+a.getProteina()+"//"+a.getCalorias()+"//"+a.getPeso());
			}
			else if(a instanceof Legume) {
				p.println("a1-legume-"+((Legume) a).getNome()+"//"+a.getProteina()+"//"+a.getCalorias()+"//"+a.getPeso());
			}
		}
		for(Alimento a:alimentosUsados) {
			if(a instanceof Carne) {
				p.println("b1-carne-"+((Carne) a).getTipo()+"//"+a.getProteina()+"//"+a.getCalorias()+"//"+a.getPeso());
			}
			else if(a instanceof Peixe) {
				p.println("b1-peixe-"+((Peixe) a).getTipo()+"//"+a.getProteina()+"//"+a.getCalorias()+"//"+a.getPeso());
			}
			else if(a instanceof Cereal) {
				p.println("b1-cereal-"+((Cereal) a).getNome()+"//"+a.getProteina()+"//"+a.getCalorias()+"//"+a.getPeso());
			}
			else if(a instanceof Legume) {
				p.println("b1-legume-"+((Legume) a).getNome()+"//"+a.getProteina()+"//"+a.getCalorias()+"//"+a.getPeso());
			}
		}
		for(Prato b: pratos) {
			for(Alimento a:b.getComposicaotoArray()) {
				if(a instanceof Carne) {
					p.println("c1-carne-"+b.getNome()+"//"+((Carne) a).getTipo()+"//"+a.getProteina()+"//"+a.getCalorias()+"//"+a.getPeso());
				}
				else if(a instanceof Peixe) {
					p.println("c1-peixe-"+b.getNome()+"//"+((Peixe) a).getTipo()+"//"+a.getProteina()+"//"+a.getCalorias()+"//"+a.getPeso());
				}
				else if(a instanceof Cereal) {
					p.println("c1-cereal-"+b.getNome()+"//"+((Cereal) a).getNome()+"//"+a.getProteina()+"//"+a.getCalorias()+"//"+a.getPeso());
				}
				else if(a instanceof Legume) {
					p.println("c1-legume-"+b.getNome()+"//"+((Legume) a).getNome()+"//"+a.getProteina()+"//"+a.getCalorias()+"//"+a.getPeso());
				}
			}
		}
		for(Prato b: ementa) {
			for(Alimento a:b.getComposicaotoArray()) {
				if(a instanceof Carne) {
					p.println("d1-carne-"+b.getNome()+"//"+((Carne) a).getTipo()+"//"+a.getProteina()+"//"+a.getCalorias()+"//"+a.getPeso());
				}
				else if(a instanceof Peixe) {
					p.println("d1-peixe-"+b.getNome()+"//"+((Peixe) a).getTipo()+"//"+a.getProteina()+"//"+a.getCalorias()+"//"+a.getPeso());
				}
				else if(a instanceof Cereal) {
					p.println("d1-cereal-"+b.getNome()+"//"+((Cereal) a).getNome()+"//"+a.getProteina()+"//"+a.getCalorias()+"//"+a.getPeso());
				}
				else if(a instanceof Legume) {
					p.println("d1-legume-"+b.getNome()+"//"+((Legume) a).getNome()+"//"+a.getProteina()+"//"+a.getCalorias()+"//"+a.getPeso());
				}
			}
		}
		p.close();
	}

	private static void load() throws IOException {
		Scanner s = new Scanner(f);
		while(s.hasNextLine()) {
			String line = s.nextLine();
			String[] a = line.split("//");
			String[] b = a[0].split("-");
			if(b[0].equals("a1")) {
				if(b[1].equals("carne")) {
					if(b[2].equals("vaca")) {
						alimentos.add(new Carne(Const.VariedadeCarne.vaca,val(a[1]),val(a[2]),val(a[3])));
					}
					else if(b[2].equals("porco")) {
						alimentos.add(new Carne(Const.VariedadeCarne.porco,val(a[1]),val(a[2]),val(a[3])));
					}
					else if(b[2].equals("frango")) {
						alimentos.add(new Carne(Const.VariedadeCarne.frango,val(a[1]),val(a[2]),val(a[3])));
					}
					else if(b[2].equals("peru")) {
						alimentos.add(new Carne(Const.VariedadeCarne.peru,val(a[1]),val(a[2]),val(a[3])));
					}
					else if(b[2].equals("outra")) {
						alimentos.add(new Carne(Const.VariedadeCarne.outra,val(a[1]),val(a[2]),val(a[3])));
					}
				}
				else if(b[1].equals("peixe")) {
					if(b[2].equals("congelado")) {
						alimentos.add(new Peixe(Const.TipoPeixe.congelado,val(a[1]),val(a[2]),val(a[3])));
					}
					else if(b[2].equals("fresco")) {
						alimentos.add(new Peixe(Const.TipoPeixe.fresco,val(a[1]),val(a[2]),val(a[3])));
					}
				}
				else if(b[1].equals("cereal")) {
					alimentos.add(new Cereal(b[2],val(a[1]),val(a[2]),val(a[3])));

				}
				else if(b[1].equals("legume")) {
					alimentos.add(new Legume(b[2],val(a[1]),val(a[2]),val(a[3])));

				}
			}
			else if(b[0].equals("b1")) {
				if(b[1].equals("carne")) {
					if(b[2].equals("vaca")) {
						alimentosUsados.add(new Carne(Const.VariedadeCarne.vaca,val(a[1]),val(a[2]),val(a[3])));
					}
					else if(b[2].equals("porco")) {
						alimentosUsados.add(new Carne(Const.VariedadeCarne.porco,val(a[1]),val(a[2]),val(a[3])));
					}
					else if(b[2].equals("frango")) {
						alimentosUsados.add(new Carne(Const.VariedadeCarne.frango,val(a[1]),val(a[2]),val(a[3])));
					}
					else if(b[2].equals("peru")) {
						alimentosUsados.add(new Carne(Const.VariedadeCarne.peru,val(a[1]),val(a[2]),val(a[3])));
					}
					else if(b[2].equals("outra")) {
						alimentosUsados.add(new Carne(Const.VariedadeCarne.outra,val(a[1]),val(a[2]),val(a[3])));
					}
				}
				else if(b[1].equals("peixe")) {
					if(b[2].equals("congelado")) {
						alimentosUsados.add(new Peixe(Const.TipoPeixe.congelado,val(a[1]),val(a[2]),val(a[3])));
					}
					else if(b[2].equals("fresco")) {
						alimentosUsados.add(new Peixe(Const.TipoPeixe.fresco,val(a[1]),val(a[2]),val(a[3])));
					}
				}
				else if(b[1].equals("cereal")) {
					alimentosUsados.add(new Cereal(b[2],val(a[1]),val(a[2]),val(a[3])));

				}
				else if(b[1].equals("legume")) {
					alimentosUsados.add(new Legume(b[2],val(a[1]),val(a[2]),val(a[3])));
				}
			}
			else if(b[0].equals("c1")) {
				Prato p = null;
				if(!nomeExists(b[2])) {
					p = new Prato(b[2]);
				}
				else {
					for(Prato p1: pratos) {
						if(p1.getNome().equals(b[2])) {
							p = p1;
						}
					}
				}
				if(b[1].equals("carne")) {
					if(a[1].equals("vaca")) {
						p.addIngrediente(new Carne(Const.VariedadeCarne.vaca,val(a[2]),val(a[3]),val(a[4])));
					}
					else if(a[1].equals("porco")) {
						p.addIngrediente(new Carne(Const.VariedadeCarne.porco,val(a[2]),val(a[3]),val(a[4])));
					}
					else if(a[1].equals("frango")) {
						p.addIngrediente(new Carne(Const.VariedadeCarne.frango,val(a[2]),val(a[3]),val(a[4])));
					}
					else if(a[1].equals("peru")) {
						p.addIngrediente(new Carne(Const.VariedadeCarne.peru,val(a[2]),val(a[3]),val(a[4])));
					}
					else if(a[1].equals("outra")) {
						p.addIngrediente(new Carne(Const.VariedadeCarne.outra,val(a[2]),val(a[3]),val(a[4])));
					}
				}
				else if(b[1].equals("peixe")) {
					if(a[1].equals("congelado")) {
						p.addIngrediente(new Peixe(Const.TipoPeixe.congelado,val(a[2]),val(a[3]),val(a[4])));
					}
					else if(a[1].equals("fresco")) {
						p.addIngrediente(new Peixe(Const.TipoPeixe.fresco,val(a[2]),val(a[3]),val(a[4])));
					}
				}
				else if(b[1].equals("cereal")) {
					p.addIngrediente(new Cereal(a[1],val(a[2]),val(a[3]),val(a[4])));

				}
				else if(b[1].equals("legume")) {
					p.addIngrediente(new Legume(a[1],val(a[2]),val(a[3]),val(a[4])));
				}
				if(!pratos.contains(p)) {
					pratos.add(p);
				}
			}
			else if(b[0].equals("d1")) {
				Prato p = null;
				if(!nomeExists(b[2])) {
					p = new Prato(b[2]);
				}
				else {
					for(Prato p1: ementa) {
						if(p1.getNome().equals(b[2])) {
							p = p1;
						}
					}
				}
				if(b[1].equals("carne")) {
					if(a[1].equals("vaca")) {
						p.addIngrediente(new Carne(Const.VariedadeCarne.vaca,val(a[2]),val(a[3]),val(a[4])));
					}
					else if(a[1].equals("porco")) {
						p.addIngrediente(new Carne(Const.VariedadeCarne.porco,val(a[2]),val(a[3]),val(a[4])));
					}
					else if(a[1].equals("frango")) {
						p.addIngrediente(new Carne(Const.VariedadeCarne.frango,val(a[2]),val(a[3]),val(a[4])));
					}
					else if(a[1].equals("peru")) {
						p.addIngrediente(new Carne(Const.VariedadeCarne.peru,val(a[2]),val(a[3]),val(a[4])));
					}
					else if(a[1].equals("outra")) {
						p.addIngrediente(new Carne(Const.VariedadeCarne.outra,val(a[2]),val(a[3]),val(a[4])));
					}
				}
				else if(b[1].equals("peixe")) {
					if(a[1].equals("congelado")) {
						p.addIngrediente(new Peixe(Const.TipoPeixe.congelado,val(a[2]),val(a[3]),val(a[4])));
					}
					else if(a[1].equals("fresco")) {
						p.addIngrediente(new Peixe(Const.TipoPeixe.fresco,val(a[2]),val(a[3]),val(a[4])));
					}
				}
				else if(b[1].equals("cereal")) {
					p.addIngrediente(new Cereal(a[1],val(a[2]),val(a[3]),val(a[4])));

				}
				else if(b[1].equals("legume")) {
					p.addIngrediente(new Legume(a[1],val(a[2]),val(a[3]),val(a[4])));
				}
				if(!ementa.contains(p)) {
					ementa.add(p);
				}
			}
		}
		s.close();
	}
}
