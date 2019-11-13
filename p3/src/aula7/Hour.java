package aula7;

public class Hour {
	private String h;
	private String m;
	
	Hour(String s){
		String[]x = s.split(":");
		this.h = x[0];
		this.m= x[1];
	}
	
	Hour(String h, String m){
		this.h = h;
		this.m = m;
	}

	public String geth() {
		return h;
	}
	
	public String getm() {
		return m;
	}

	
	public static  Hour obs(Hour h1, Hour h2) {
		
		int min1 = Integer.parseInt(h1.getm());
		int min2 = Integer.parseInt(h2.getm());
		int hr1 = Integer.parseInt(h1.geth());
		int hr2 = Integer.parseInt(h2.geth());
		
		String mins = Integer.toString((min1+min2)%60);
		String hrs = Integer.toString(hr1+hr2+(min1+min2)/60);
		
		Hour n = new Hour(hrs, mins);
		
		
		return n;
	}
	
	@Override
	public String toString() {
		return geth() + ":" + getm() ;
	}
	
	

}
