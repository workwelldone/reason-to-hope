import java.util.NoSuchElementException;

public class SimpleLinkedList <E> {

	private class Element<T> {
		private T element;
		private Element<T> next;
		
		public Element(T element) {
			this.element = element;
		}
		
		public T getElement() {
			return element;
		}
		
		public void setElement(T element) {
			this.element = element;
		}
		
		public Element<T> getPointer() {
			return next;
		}
		
		public void setPointer(Element<T> pointer) {
			this.next = pointer;
		}
	}

	private int size;
	private Element<E> last;
	
	public SimpleLinkedList() {
		size = 0;
	}
	
	public SimpleLinkedList(E[] array){
		if (array == null || array.length == 0) size = 0;
		else for (E element : array) push(element);
	}
	
	public E pop() throws NoSuchElementException {
		if (size == 0) throw new NoSuchElementException();
		E temp = last.getElement();
		last = last.getPointer();
		size--;
		return temp;
	}
	
	public boolean push(E element) {
		if (element == null) return false;
		
		if (last == null) last = new Element<E>(element); // add first element to list
		else {
			Element<E> temp = new Element<E>(element);
			temp.setPointer(last);
			last = temp;
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
		Element<E> next = last;
		for (int i = 0; i < size; i++) {
			temp[i] = next.getElement();
			next = next.getPointer();
		}
		return (E[])(temp);
	}
}