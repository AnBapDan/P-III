package aula5;


public class UtilCompare {
	@SuppressWarnings("unchecked")
	public static <T> Comparable<T> findMax(Comparable<T>[] a){
		
		
		int maxIndex = 0;
		for ( int i = 1; i < a.length; i++ ) {
			if (a[i] != null && a[i].compareTo((T) a[maxIndex]) > 0)
				maxIndex = i;
		}
		return a[maxIndex];
		
	}
	
	
	@SuppressWarnings("unchecked")
	public static <T> void sortArray(Comparable<T>[] lista) {
		for(int i=lista.length-1;i>=0;i--) {
			for(int j=0;j<i;j++) {
				if(lista[j].compareTo((T) lista[j+1])>0) {
					Comparable<T> tmp = lista[j];
					lista[j]=lista[j+1];
					lista[j+1]=tmp;
				}
			}
		}
	}

}
