package aula4;

import java.util.*;

public class ColecaoFiguras {
	
	private LinkedList<Figura> col = new LinkedList<Figura>();
	private double maxArea;
	
	public ColecaoFiguras(double maxArea) {	
		this.maxArea= maxArea;	
	}

	public boolean addFigura(Figura f) {
		if(exists(f)) {
			return false;
		}
		else {
			if((areaTotal()+f.area())>getMaxArea()) {
				return false;
			}
			else {
				col.add(f);
				return true;
			}
		}	
	}

	public boolean delFigura(Figura f) {
		if(!exists(f)) {
			return false;
		}
		else {
			col.remove(col.indexOf(f));
			return true;
		}
	}

	public double areaTotal() {
		double total = 0;
		for(int i =0; i< getCol().size(); i++) {
			total+= col.get(i).area();	
		}
		return total;
	}
	
	public boolean exists(Figura f) {
		return col.contains(f);
	}

	public Figura[] getFiguras() {
		
			Figura[]getF = new Figura[getCol().size()];
			for(int j = 0; j< getF.length; j++) {
				getF[j] = col.get(j);
			}
			
		return getF;
	}

	public Ponto[] getCentros() {
		Figura[] getF = getFiguras();
		Ponto[] middle = new Ponto[getF.length];
		for(int i =0; i<middle.length;i++) {
			middle[i] = getF[i].getP1();
		}
		return middle;
	}

	
	public LinkedList<Figura> getCol() {
		return col;
	}

	public double getMaxArea() {
		return maxArea;
	}

	
	@Override
	public String toString() {
		return null;
	}
	
	

}
