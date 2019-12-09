package aula11;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;

public class Ex11_1 {

	public static void main(String[] args) {
		ArrayList<Pessoa> vp = new ArrayList<Pessoa>();
		for (int i=0; i<10; i++)
		vp.add(new Pessoa("Bebé no Vector "+i,1000+i, Data.today()));
		ListIterator<Pessoa> vec = vp.listIterator();
		printSet(vp.listIterator());
		LinkedList<Pessoa> lp = new LinkedList<Pessoa>();
		while ( vec.hasNext() )
		lp.add( vec.next() );
		ListIterator<Pessoa> lista = lp.listIterator();
		while ( lista.hasNext() )
		System.out.println( lista.next() );
		LinkedList<Figura> figList = new LinkedList<Figura>();
		
		figList.add(new Circulo (1,3, 1));
		figList.add(new Quadrado(3,4, 2));
		figList.add(new Retangulo(1,2, 2,5));
		printSet(figList.listIterator());
		System.out.println("Soma da Area de Lista de Figuras: " + sumArea(figList));
		// Partindo do principio que Quadrado extends Rectangulo:
		LinkedList< Retangulo > quadList = new LinkedList<Retangulo>();
		quadList.add(new Quadrado(3,4, 2));
		quadList.add(new Retangulo(1,2, 2,5));
		System.out.println("Soma da Area de Lista de Quadrados: " + sumArea(quadList));
	}

	private static <T> double sumArea(LinkedList<T> lista) {
		ListIterator<T> i = (ListIterator<T>) lista.listIterator();
		double area = 0;
		while(i.hasNext()) {
			Object f = i.next();
			if(f instanceof Figura) {
				area += ((Figura) f).area();
			}
		}
		return area;
	}

	private static <T> void printSet(ListIterator<T> iterator) {
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}

}
