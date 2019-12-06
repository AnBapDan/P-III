package aula11;

import java.util.List;

public class Ex11_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	private static Figura maiorFiguraJ7(List<Figura> figs) {
		Figura maior = figs.get(0);
		for (Figura f : figs) {
			if (f.compareTo(maior) >= 1)
				maior = f;
		}
		return maior;
	}

}
