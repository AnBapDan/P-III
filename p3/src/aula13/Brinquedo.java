package aula13;

public class Brinquedo {

		private String boneco;
		
		Brinquedo(){
			boneco = "Boneco Generico";
		}
		
		Brinquedo(String nome){
			this.boneco = nome;
		}

		public String getBoneco() {
			return boneco;
		}

		@Override
		public String toString() {
			return  boneco ;
		}
		
		
}
