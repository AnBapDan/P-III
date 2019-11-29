package aula10;

import java.util.NoSuchElementException;
import java.util.Stack;

public class BinarySearchTree<T extends Comparable<? super T>> {
	private static class BSTNode<T> {
		T element;
		BSTNode<T> left;
		BSTNode<T> right;
		
		BSTNode(T theElement) {
			element = theElement;
			left = right = null;
		}
		
		private BSTNode<T> findMax(){
			return findMax(this);
		}
		
		private BSTNode<T> findMax(BSTNode<T> n){
			if(n.right==null) {
				return n;
			}
			return findMax(n.right);
		}
		
		private BSTNode<T> findMin(){
			return findMin(this);
		}
		
		private BSTNode<T> findMin(BSTNode<T> n){
			if(n.left==null) {
				return n;
			}
			return findMin(n.left);
		}
	}
		
	private BSTNode<T> root;
	private int numNodes;
	
	public BinarySearchTree() {
		root = null;
		numNodes = 0;
	}
	
	public void insert(T value) {
		numNodes++;
		root = insert(value, root);
	}
	
	public void remove(T value) {
		numNodes--;
		root = remove(value, root);
	}
	
	public boolean contains(T value) {
		return valueOf(find(value, root)) != null;
	}
	
	private BSTNode<T> insert(T elem,BSTNode<T> n) {
		if(valueOf(root)==null) {
			root = new BSTNode<T>(elem);
			return root;
		}
		else {
			if(elem.compareTo(n.element)<0) {
				n.left = insert(elem,n.left);
				return n;
			}
			else{
				n.right = insert(elem,n.right);
				return n;
			}
		}
	}
	
	private BSTNode<T> remove(T elem,BSTNode<T> n) {
		if(root==null)throw new NullPointerException();
		if(!contains(elem))throw new NoSuchElementException();
		int i=elem.compareTo(n.element);
		if(i<0) {
			n = remove(elem,n.left);
		}
		else if(i>0) {
			n = remove(elem,n.right);
		}
		else {
			if(n.left==null) {
				n = n.right;
			}
			else if(n.right==null) {
				n = n.left;
			}
			n.element = n.findMin().element;
			n.right = remove(n.element,n.right);
		}
		return n;
	}
	
	@SuppressWarnings("unchecked")
	private BSTNode<T> find(T elem,BSTNode<T> n) {
		Iterator<T> i = getIterator();
		while(i.hasNext()) {
			T n1 = (T) i.next();
			if(n1.compareTo(elem)==0) {
				return new BSTNode<T>(n1);
			}
		}
		return root;
	}
	
	private T valueOf(BSTNode<T> n) {
		return n.element;
	}
	
	public Iterator<T> getIterator(){
		return (this).new BSTIterator<T>();
	}
	
	public class BSTIterator<E> implements Iterator<E>{
		Stack<BSTNode<T>> stack;
		
		public BSTIterator(){
			stack= new Stack<BSTNode<T>>();
			while(root!=null) {
				stack.push(root);
				root=root.left;
			}
		}
		
		@Override
		public boolean hasNext() {
			return !stack.isEmpty();
		}

		@Override
		public Object next() {
			BSTNode<T> n = stack.pop();
			Object first  = n.element;
			if(n.right!=null) {
				n=n.right;
				while(n!=null) {
					stack.push(n);
					n=n.left;
				}
			}
			return first;
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			
		}
		
	}
}
