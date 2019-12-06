package aula11;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Ex11_2 {

	private static Figura maiorFiguraJ7(List<Figura> figs) {
		Optional<Figura> maior = figs.stream().max(Comparator.comparing(Figura :: area));
		if(maior.isPresent()) {
			return maior.get();
		}
		return null;
	}
	
	private static Figura maiorFiguraJ8(List<Figura> figs) {
		Optional<Figura> maior = figs.stream().max(Comparator.comparing(Figura :: perimetro));
		if(maior.isPresent()) {
			return maior.get();
		}
		return null;
	}

	private static double areaTotalJ8(List<Figura> figs) {
//		double a =0;
//		for(Figura f : figs) {
//			a += f.area();
//		}
//		return a;
		return figs.stream().mapToDouble(Figura::area).sum();
	}
	private static double areaTotalJ8(List<Figura> figs,String subtipoNome){
		return figs.stream().filter(f -> f.getClass().getSimpleName().equals(subtipoNome)).mapToDouble(Figura::area).sum();	
	}
	
	
	
	
}
