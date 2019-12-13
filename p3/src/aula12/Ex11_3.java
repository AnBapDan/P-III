package aula12;

import java.io.*;
import java.util.*;

import aula12.plgs12_3.CSV;
import aula12.plgs12_3.Nokia;
import aula12.plgs12_3.vCard;

abstract class PluginManager2 {
	
	public static IPlugin2 load(String name) throws Exception {
		Class<?> c = Class. forName (name);
		return (IPlugin2) c.newInstance();
	}
}

public class Ex11_3 {
	public static void main(String[] args) throws Exception {
		File proxyList = new File("src/aula12/plgs12_3");
		ArrayList<IPlugin2> plgs = new ArrayList<IPlugin2>();
		for (String f: proxyList.list()) {
			try {
				plgs.add(PluginManager2. load ("aula12.plgs12_3."+f.substring(0,f.lastIndexOf('.'))));
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		Iterator<IPlugin2> it = plgs.iterator();
		
		while (it.hasNext()) {
			it.next().fazQualQuerCoisa(null); //TODO
		}
	}
}
//
//	public static Agenda openFile(String a) throws IOException {
//		File f= new File(a);
//		Scanner sc = new Scanner(f);
//		String type= sc.nextLine();
//		sc.close();
//		
//		if(type.equals("CSV")){
//			return new CSV(a);
//		}
//		else if(type.equals("Nokia")) {
//			return new Nokia(a);
//		}
//		else if(type.equals("vCard")) {
//			return new vCard(a);
//		}else {
////			System.out.println("Type not supported");
////			System.exit(1);
////
////		}
////		return null;
////
////	}	
////	
////	
//
//}
