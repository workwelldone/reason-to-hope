public class Deque<E> {

	
	private Node<E> top;
	private Node<E> bottom;
	
	public Deque() {}
	
	/** Remove value at top */
	public E pop() {
		E temp = top.element;
		top = top.nextDown;
		return temp;
	}
	
	/** Add value on top */
	public void push(E element) {
		if (bottom == null) {
			bottom = new Node<E>(element);
			top = bottom;
		}
		else {
			Node<E> temp = new Node<E>(element);
			temp.nextDown = top;
			top.nextUp = temp;
			top = temp;
		}
	}

	/** Remove value at bottom */
	public E shift() {
		E temp = bottom.element;
		bottom = bottom.nextUp;
		return temp;
	}
	
	/** Insert value at bottom */
	public void unshift(E element) {
		if (bottom == null) {
			bottom = new Node<E>(element);
			top = bottom;
		}
		else {
			Node<E> temp = new Node<E>(element);
			temp.nextUp = bottom;
			bottom.nextDown = temp;
			bottom = temp;
		}
	}

	private class Node<T> {
		private final T element;
		private Node<T> nextUp;
		private Node<T> nextDown;
		
		public Node(T element) {
			this.element = element;
		}
	}
}