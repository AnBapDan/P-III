package aula12;

import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.Scanner;

import java.lang.Class;


public class Ex12_1 {
	
	static final Scanner sc =new Scanner(System.in);
	static ArrayList<Object> lista = new ArrayList<Object>();

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		String option;
		
		do {
			System.out.println("__________________Menu_____________________");
			System.out.println("|1-  Novo objeto---------------------------|");
			System.out.println("|2-  Mostrar todos os objetos--------------|");
			System.out.println("|3-  Chamar um metodo de um objeto---------|");
			System.out.println("|0-  Sair----------------------------------|");
			System.out.println("‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾\n");
			do {
				System.out.print("Opcao -> ");
				option = sc.next();
			}while(!matchInputs(option,"num") && val(option)<0 || val(option)>3);
			switch(val(option)) {
				case 0:
					System.exit(0);
					break;
				case 1:
					makeNewObject();
					break;
				case 2:
					displayToString();
					break;
				case 3:
					invokeMethods();
					break;
			}
		}while(val(option)!=0);
		
	}
	
	private static void display() {
		if(lista.size()>0) {
			int cont=0;
			for(Object obj:lista) {
				System.out.println(cont+" - "+obj.getClass().getSimpleName());
				cont++;
			}
		}
		else {
			System.out.println("Não há objetos registados!");
		}
	}
	
	private static void invokeMethods() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		if(lista.size()>0) {
			String option;
			display();
			do {
				System.out.print("Em que objeto pretende chamar um método?");
				option = sc.next();
			}
			while(!matchInputs(option,"num") && val(option)>=lista.size() || val(option)<0);
			Object obj = lista.get(val(option));
			Class<?> a = obj.getClass();
			Method[] meth = a.getMethods();
			int cont=0;
			for(Method m:meth) {
				System.out.print(cont+" - ");
				cont++;
				int mod = m.getModifiers();
				if(mod==Modifier.PUBLIC) {
					System.out.print("public ");
				}
				else if(mod==Modifier.PROTECTED) {
					System.out.print("protected ");
				}
				else if(mod==Modifier.PRIVATE) {
					System.out.print("private ");
				}
				if(Modifier.isStatic(mod)) {
					System.out.print("static ");
				}
				System.out.print(m.getReturnType().getName()+" ");
				System.out.print(m.getName()+"(");
				Parameter[] p1 = m.getParameters();
				for(Parameter p:p1) {
					if(p.equals(p1[p1.length-1])) {
						System.out.print(p.getType()+" "+p.getName());
					}
					else {
						System.out.print(p.getType()+" "+p.getName()+", ");
					}
				}
				System.out.print(")");
				System.out.println();
			}
			do {
				do {
					System.out.print("Qual o metodo?");
					option = sc.next();
				}while(!matchInputs(option,"num") && val(option)<0 || val(option)>cont);
				if(meth[val(option)].getParameters().length>0) {
					System.out.println("O metodo nao pode depender de variaveis!");
				}
				if(meth[val(option)].getReturnType().getName().equals("void")) {
					System.out.println("O metodo nao pode ser do tipo void!");
				}
			}
			while(meth[val(option)].getParameters().length>0 || meth[val(option)].getReturnType().getName().equals("void"));
			Method m = meth[val(option)];
			Object result = m.invoke(obj, null);
			System.out.println(result.toString());
		}
		else {
			System.out.println("Não há objetos registados!");
		}
	}
	
	private static void makeNewObject() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		System.out.println("Qual a classe a testar?(Package aula12)");
		String myClass = sc.next();
		Class<?> teste = Class.forName("aula12."+myClass);
		
		System.out.println("------------Classe----------------\n");
		
		System.out.print("public class "+teste.getSimpleName()+" ");
		
		System.out.print("extends "+teste.getSuperclass().getSimpleName()+" ");
		
		Class<?>[] ifc = teste.getInterfaces();
		if(ifc.length>0) {
			System.out.print("implements ");
			for(int i=0;i<ifc.length;i++) {
				System.out.print(ifc[i].getName()+" ");
			}
		}		
		
		System.out.println();
		System.out.println();
		
		System.out.println("------------Atributos----------------\n");
		Field[] fields = teste.getDeclaredFields();
		for(Field f:fields) {
			int mod = f.getModifiers();
			if(mod==Modifier.PUBLIC) {
				System.out.print("public ");
			}
			else if(mod==Modifier.PROTECTED) {
				System.out.print("protected ");
			}
			else if(mod==Modifier.PRIVATE) {
				System.out.print("private ");
			}
			if(Modifier.isStatic(mod)) {
				System.out.print("static ");
			}
			System.out.print(f.getType().getName()+" ");
			System.out.print(f.getName()+" ");
			System.out.println();
		}
		
		System.out.println();
		
		System.out.println("------------Construtores----------------\n");
		Constructor<?>[] c1 = teste.getConstructors();
		for(Constructor<?> c:c1) {
			System.out.println(c.toString());
		}
		System.out.println();
		
		System.out.println("------------Métodos----------------\n");
		Method[] methods = teste.getDeclaredMethods();
		for(Method m:methods) {
			int mod = m.getModifiers();
			if(mod==Modifier.PUBLIC) {
				System.out.print("public ");
			}
			else if(mod==Modifier.PROTECTED) {
				System.out.print("protected ");
			}
			else if(mod==Modifier.PRIVATE) {
				System.out.print("private ");
			}
			if(Modifier.isStatic(mod)) {
				System.out.print("static ");
			}
			System.out.print(m.getReturnType().getName()+" ");
			System.out.print(m.getName()+"()");
			System.out.println();
		}
		System.out.println();
		
		System.out.println("----------------------------------\n");
		
		System.out.println("Qual o construtor a utilizar?");
		Constructor<?>[] ct = teste.getConstructors();
		for(int i=0;i<ct.length;i++) {
			System.out.println(i+" - "+ct[i].toString());
		}
		System.out.print("Opcao -> ");
		int construtor = sc.nextInt();
		sc.nextLine();
		Parameter[] param = ct[construtor].getParameters();
		Object[] obj = new Object[param.length];
		for(int i=0;i<param.length;i++) {
			Type t = param[i].getType();
			System.out.print("Introduza um "+t.getTypeName()+" -> ");
			if(t.getTypeName().equals("int")){
				obj[i] = sc.nextInt();
			}
			else if(t.getTypeName().equals("double")) {
				obj[i] = sc.nextDouble();
			}
			else if(t.getTypeName().equals("char")) {
				obj[i] = sc.next();
			}
			else if(t.getTypeName().equals("java.lang.String")) {
				obj[i] = sc.nextLine();
			}
			else if(t.getTypeName().equals("float")) {
				obj[i] = sc.nextFloat();
			}
			else if(t.getTypeName().equals("long")) {
				obj[i] = sc.nextLong();
			}
			else {
				if(!t.getTypeName().contains("$")) {
					obj[i] = makeAnotherObject(t.getTypeName().split("\\.")[1]);
				}
				else {
					System.out.println(" null");
					obj[i]=null; 
					sc.nextLine();
				}
			}
			
		}
		Object newObj = ct[construtor].newInstance(obj);
		lista.add(newObj);
	}
	
	private static Object makeAnotherObject(String myClass) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, ClassNotFoundException {
		Class<?> teste = Class.forName("aula12."+myClass);
		
		System.out.println("------------Classe----------------\n");
		
		System.out.print("public class "+teste.getSimpleName()+" ");
		
		System.out.print("extends "+teste.getSuperclass().getSimpleName()+" ");
		
		Class<?>[] ifc = teste.getInterfaces();
		if(ifc.length>0) {
			System.out.print("implements ");
			for(int i=0;i<ifc.length;i++) {
				System.out.print(ifc[i].getName()+" ");
			}
		}		
		
		System.out.println();
		System.out.println();
		
		System.out.println("------------Atributos----------------\n");
		Field[] fields = teste.getDeclaredFields();
		for(Field f:fields) {
			int mod = f.getModifiers();
			if(mod==Modifier.PUBLIC) {
				System.out.print("public ");
			}
			else if(mod==Modifier.PROTECTED) {
				System.out.print("protected ");
			}
			else if(mod==Modifier.PRIVATE) {
				System.out.print("private ");
			}
			if(Modifier.isStatic(mod)) {
				System.out.print("static ");
			}
			System.out.print(f.getType().getName()+" ");
			System.out.print(f.getName()+" ");
			System.out.println();
		}
		
		System.out.println();
		
		System.out.println("------------Construtores----------------\n");
		Constructor<?>[] c1 = teste.getConstructors();
		for(Constructor<?> c:c1) {
			System.out.println(c.toString());
		}
		System.out.println();
		
		System.out.println("------------Métodos----------------\n");
		Method[] methods = teste.getDeclaredMethods();
		for(Method m:methods) {
			int mod = m.getModifiers();
			if(mod==Modifier.PUBLIC) {
				System.out.print("public ");
			}
			else if(mod==Modifier.PROTECTED) {
				System.out.print("protected ");
			}
			else if(mod==Modifier.PRIVATE) {
				System.out.print("private ");
			}
			if(Modifier.isStatic(mod)) {
				System.out.print("static ");
			}
			System.out.print(m.getReturnType().getName()+" ");
			System.out.print(m.getName()+"()");
			System.out.println();
		}
		System.out.println();
		
		System.out.println("----------------------------------\n");
		
		System.out.println("Qual o construtor a utilizar?");
		Constructor<?>[] ct = teste.getConstructors();
		for(int i=0;i<ct.length;i++) {
			System.out.println(i+" - "+ct[i].toString());
		}
		System.out.print("Opcao -> ");
		int construtor = sc.nextInt();
		sc.nextLine();
		Parameter[] param = ct[construtor].getParameters();
		Object[] obj = new Object[param.length];
		for(int i=0;i<param.length;i++) {
			Type t = param[i].getType();
			System.out.print("Introduza um "+t.getTypeName()+" -> ");
			if(t.getTypeName().equals("int")){
				obj[i] = sc.nextInt();
			}
			else if(t.getTypeName().equals("double")) {
				obj[i] = sc.nextDouble();
			}
			else if(t.getTypeName().equals("char")) {
				obj[i] = sc.next();
			}
			else if(t.getTypeName().equals("java.lang.String")) {
				obj[i] = sc.nextLine();
			}
			else if(t.getTypeName().equals("float")) {
				obj[i] = sc.nextFloat();
			}
			else if(t.getTypeName().equals("long")) {
				obj[i] = sc.nextLong();
			}
			else {
				if(!t.getTypeName().contains("$")) {
					obj[i] = makeAnotherObject(t.getTypeName().split("\\.")[1]);
				}
				else {
					obj[i]=null;
				}
			}
			
		}
		return ct[construtor].newInstance(obj);
	}
	
	private static void displayToString() {
		if(lista.size()>0) {
			for(Object obj:lista) {
				System.out.println(obj.getClass().getSimpleName()+" - "+obj.toString());
			}
		}
		else {
			System.out.println("Não há objetos registados!");
		}
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

}