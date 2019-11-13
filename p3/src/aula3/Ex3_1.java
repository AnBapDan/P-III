package aula3;

public class Ex3_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student est = new Student ("Andreia", 9855678, new Data(18, 7, 1974));
		Bolseiro bls = new Bolseiro ("Maria", 8976543, new Data(11, 5, 1976));
		bls.setBolsa(745);
		
		System.out.println("Estudante:" + est.getNome());
		System.out.println(est);
		
		System.out.println("Bolseiro:" + bls.getNome() + ", NMec: " + bls.getnMec()
		+ ", Bolsa:" + bls.getBolsa());
		System.out.println(bls);
	}

}
