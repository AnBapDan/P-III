package aula5;

import java.io.*;
import java.util.*;

public class Ex5_3{
	
	public static void main(String[] args) throws IOException {
		openFile(args[0]);
		
	}
	

	public static Agenda openFile(String a) throws IOException {
		File f= new File(a);
		Scanner sc = new Scanner(f);
		String type= sc.nextLine();
		sc.close();
		
		if(type.equals("CSV")){
			return new CSV(a);
		}
		else if(type.equals("Nokia")) {
			return new Nokia(a);
		}
		else if(type.equals("vCard")) {
			return new vCard(a);
		}else {
			System.out.println("Type not supported");
			System.exit(1);

		}
		return null;

	}	
	
	
	
}
