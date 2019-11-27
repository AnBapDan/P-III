package aula10;

public class VectorGeneric<T>{
	private int totalelems;
	private final int cont = 50;
	private int dimClasse = cont;
	Object[] elems = new Object[10];
	
	public VectorGeneric() {
		elems=new Object[cont];
		totalelems=0;
	}
	
	public boolean addElem(T p) {
		if(p==null) {
			return false;
		}
		extend();
		elems[totalelems]=p;
		totalelems++;
		return true;
	}
	
	public boolean removeElem(T p) {
		for(int i=0;i<totalelems;i++) {
			Object p1 = elems[i];
			if(p1.equals(p)) {
				totalelems--;
				for(int j=i;j<totalelems;j++) {
					elems[j]=elems[j+1];
				}
				return true;
			}
		}
		return false;
	}
	
	public int totalElem() {
		return totalelems;
	}
	
	public Object getObject(int index) {
		return elems[index];
	}
	
	private void extend() {
		if(totalelems>=dimClasse) {
			dimClasse+=cont;
			Object[] copy = elems;
			elems=new Object[dimClasse];
			System.arraycopy(copy, 0, elems, 0, totalelems);
		}
	}
	
	public Iterator<T> iterator() {
		return (this).new VectorIterator();
	}
	
	class VectorIterator implements Iterator<T>{
		private int index;
		
		VectorIterator(){
			this.index=0;
		}
		
		
		public boolean hasNext() {
			return index<totalelems;
		}

		public Object next() {
			if(hasNext()) {
				Object r = elems[index];
				index++;
				return r;
			}
			else {
				throw new IndexOutOfBoundsException(index+" elements for range "+totalelems);
			}
		}

		public void remove() {
			throw new UnsupportedOperationException("Not supported operation!");
			
		}

		public boolean hasPrevious() {
			return index>0;
		}

		public Object previous() {
			if(hasPrevious()) {
				index--;
				Object r = elems[index];
				return r;
			}
			else {
				throw new IndexOutOfBoundsException("Reached and passed 0");

			}
		}
	}
}
