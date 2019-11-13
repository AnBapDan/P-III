package aula3;

import java.util.*;

public class Video {
	
	private int ID;
	private String nome;
	private Const.Category categorias;
	private Const.Age idade;
	private LinkedList<Cliente> clientes;
	private LinkedList<Integer> rating;

	public Video(String nome, Const.Category categorias, Const.Age idade, int size) {
		super();
		this.nome = nome;															//Pode existir mais que uma copia do mesmo filme, por esse motivo é possivel entradas duplicadas
		try {
			this.categorias = categorias;
		}
		catch(Exception Invalid_category) {
			System.out.printf("Categoria invalida. Video categorizado como: Outros");
			this.categorias = Const.Category.Outros; 
		}
		
		this.idade = idade;
		
		this.ID = size +1;
		
		this.clientes = new LinkedList<Cliente>();
		
		this.rating = new LinkedList<Integer>();
		
	}

	public int getID() {
		return ID;
	}

	public String getNome() {
		return nome;
	}

	public Const.Category getCategorias() {
		return categorias;
	}

	public Const.Age getIdade() {
		return idade;
	}
	
	public LinkedList<Cliente> getClientes(){
		return clientes;
	}
	
	public LinkedList<Integer> getRating(){
		return rating;
	}
	
	public double averageRating(){
		double media = 0; 
		for(int i=0; i<this.rating.size(); i++){
			media += rating.get(i);
		}
		return media/this.rating.size();
	}

	@Override
	public String toString() {
		return "Video -> ID: " + getID() + " | " + getNome() + " - " + getCategorias()+ " - " + getIdade() + " |";
	}
	
	public String showRating(){
		return "Video -> ID: " + getID() + " | " + getNome() +" -> Rating médio: " + averageRating()+" |";
	}
}
