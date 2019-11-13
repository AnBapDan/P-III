package aula6;

import java.util.function.Predicate;
import java.util.ArrayList;
import java.util.List;

public interface ListsProcess{
	
    public static <T> List<T> filter(List<T> lista, Predicate<T> p){
        List<T> filtered = new ArrayList<T>();
        for(T t : lista) { 
        	if(p.test(t)){
        		filtered.add(t);
        	}
        }
        return filtered; 
    }
}