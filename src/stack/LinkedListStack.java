package stack;

public class LinkedListStack<E> implements Stack<E> {
	private class Node<T> {
		T data;
		Node<T> next;
		Node(T data) {
			this.data = data;
			this.next = null;
		}
		// implement the nodes here
		/**
		 * toString method that matches test cases for easy testing.
		 */
		@Override
		public String toString() {
			return ((next == null) ? "" : next.toString()+"-") + data.toString() ;
		}
	}

	Node<E> top;

	@Override
	public boolean isEmpty() {
		return top == null;
	}


	@Override
	public E top() throws Underflow {
		if (isEmpty()) {
			throw new Underflow();
		}
		return top.data;
	}

	@Override
	public void push(E element) {
		Node<E> newNode = new Node<>(element);
		newNode.next = top;
		top = newNode;
	}

	@Override
	public E pop() throws Underflow {
		if (isEmpty()) {
			throw new Underflow();
		}
		E data = top.data;
		top = top.next;
		return data;
	}

	/**
	 * toString method that matches test cases for easy testing.
	 * @return
	 */
	@Override
	public String toString() {
		if (top == null)
			return "<empty>";
		return "<stack: "+top.toString()+">";
	}
}
