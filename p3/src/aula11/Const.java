package aula6;


public class Const{
	public enum VariedadeCarne {
		vaca(1),
		porco(2),
		peru(3),
		frango(4),
		outra(5);
		
		private int index;
		
		VariedadeCarne(int index) {
			this.index=index;
		}
		
		public int getIndex() {
			return index;
		}
	}
	
	public enum TipoPeixe{
		congelado,
		fresco;
	}
	
	public enum DiaSemana{
		segunda(0),
		terca(1),
		quarta(2),
		quinta(3),
		sexta(4),
		sabado(5),
		domingo(6);
		
		private int index;
		
		private DiaSemana(int index){
			this.index=index;
		}
		
		public int getIndex() {
			return index;
		}
		
		public static DiaSemana rand() {
			DiaSemana dia = null;
			int r = (int) (Math.random()*6);
			for(DiaSemana d: DiaSemana.values()) {
				if(d.getIndex()==r) {
					dia=d;
				}
			}
			return dia;
		}
	}
}








