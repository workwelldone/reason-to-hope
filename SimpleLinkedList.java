import java.util.NoSuchElementException;

public class SimpleLinkedList <E> {

	private int size;
	private Node<E> top;
	
	public SimpleLinkedList() {
		size = 0;
	}
	
	public SimpleLinkedList(E[] array){
		if (array == null || array.length == 0) size = 0;
		else for (E element : array) push(element);
	}
	
	public E pop() throws NoSuchElementException {
		if (size == 0) throw new NoSuchElementException();
		E temp = top.element;
		top = top.nextDown;
		size--;
		return temp;
	}
	
	public boolean push(E element) {
		if (element == null) return false;
		
		if (top == null) top = new Node<E>(element);
		else {
			Node<E> temp = new Node<E>(element);
			temp.nextDown = top;
			top = temp;
		}
		size++;
		return true;
	}
	
	public int size() {
		return size;
	}
	
	@SuppressWarnings("unchecked")
	public void reverse() {
		int originalSize = size;
		Object[] temp = new Object[originalSize];
		for (int i = 0; i < originalSize; i++) temp[i] = pop();
		for (int i = 0; i < originalSize; i++) push((E)temp[i]);
	}
	
	@SuppressWarnings("unchecked")
	public E[] asArray(Class<?> c){
		Object[] temp = new Object[size];
		Node<E> next = top;
		for (int i = 0; i < size; i++) {
			temp[i] = next.element;
			next = next.nextDown;
		}
		return (E[])(temp);
	}
	
	private class Node<T> {
		private final T element;
		private Node<T> nextDown;
		
		public Node(T element) {
			this.element = element;
		}
	}
}