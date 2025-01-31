package aula6;

public class LinkedList<E extends Comparable<E>> {

  private Node<E> first = null;
  private Node<E> last = null;
  private int size = 0;

  /**
   * {@code LinkedList} constructor, empty so far.
   */
  public LinkedList() { }

  /** Returns the number of elements in the list.
   * @return Number of elements in the list
   */
  public int size() { return size; }

  /** Checks if the list is empty.
   * @return  {@code true} if list empty, otherwise {@code false}.
   */
  public boolean isEmpty() { return size == 0; }

  /** Returns the first element in the list.
   * @return  First element in the list
   */
  public E first() {
    assert !isEmpty(): "empty!";

    return first.elem;
  }

  /** Returns the last element in the list.
   * @return Last element in the list
   */
  public E last() {
    assert !isEmpty(): "empty!";

    return last.elem;
  }
  
  public void insert(E e) {
    first = insert(first,e);
    size++;
  }
  private Node<E> insert(Node<E> n, E e) {
    if (n==null || e.compareTo(n.elem) < 0)
      return new Node<E>(e,n);
    n.next = insert(n.next,e);
    return n;
  }

  /** Removes the first element in the list.
   */
  public void removeFirst() {
    assert !isEmpty(): "empty!";
    first = first.next;
    size--;
    if (isEmpty())
      last = null;
  }

  /** Removes all elements.
   */
  public void clear() {
    first = last = null;
    size = 0;
  }

  /** Checks if the given element exists in the list.
   * @param e an element
   * @return {@code true} if the element exists and {@code false} otherwise
   */
  public boolean contains(E e) { 
    return contains(first, e); 
  }
  private boolean contains(Node<E> n, E e) {
    if (n == null) return false;
    if (n.elem==null) return e==null; 
    if (n.elem.equals(e)) return true; 
    return contains(n.next, e);
  }
  
  public E[] toArray(E[] a) {
	  @SuppressWarnings("unchecked")
	E[] tmp = (E[])java.lang.reflect.Array.newInstance(a.getClass().getComponentType(), size);
	  int index = 0;
	  for(Node<E> n = first; n != null; n = n.next) {
		  tmp[index++] = n.elem;
	  }
	  return tmp;
  }
  
  @SuppressWarnings({ "rawtypes" })
public Object get(int index) {
	if(index<0)return null;
	Node current = null;
	if(first != null) {
		current = first.next;
		for(int i=0;i<index;i++) {
			if(current.next==null)return null;
			current = current.next;
		}
	}
	return current;
  }
  

public boolean remove(int index) {
	  if(index<1 || index>size){return false;}
	  Node<E> current=first;
	  if(first!=null) {
		  for(int i=0;i<index;i++) {
			  if(current.next==null)return false;
			  current=current.next;
		  }
		  current =current.next.next;
		  size--;
	  }
	  return true;
  }
  
public boolean remove(Object obj) {
	if(obj==null)return false;
	Node<E> current = first;
	if(first != null) {
		for(int i=0;i<size;i++) {
			if(current.next==null)return false;
			else if(current.equals(obj))current=current.next.next;
			current=current.next;
		}
	}
	return true;
}
  
  @SuppressWarnings("hiding")
class Node<E> {

	  final E elem;
	  Node<E> next;

	  Node(E e, Node<E> n) {
	    elem = e;
	    next = n;
	  }

	  Node(E e) {
	    elem = e;
	    next = null;
	  }

	}
}