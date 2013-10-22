package stack.duseok;

public class DsLinkedListStack<T> {

	private Node<T> top = null;

	@SuppressWarnings("hiding")
	public class Node<T> {
		private T data;
		Node<T> next = null;

		public Node(T data) {
			this.data = data;
		}

		public T getValue() {
			return this.data;
		}

		@Override
		public String toString() {
			return getValue().toString();
		}
	}

	public void push(T data) {

		Node<T> newNode = new Node<T>(data);

		if (this.top == null) {
			this.top = newNode;
		} else {
			newNode.next = this.top;
			this.top = newNode;
		}

	}

	public T pop() {

		T returnValue = null;
		Node<T> popNode = this.top;
		if (popNode != null) {
			this.top = popNode.next;
			returnValue = popNode.getValue();
		}
		return returnValue;
	}

	public Node<T> lastNode() {

		Node<T> oldTop = this.top;

		while (oldTop.next != null) {
			oldTop = oldTop.next;
		}
		return oldTop;
	}

	public boolean isEmpty() {

		boolean isEmpty = false;
		if (this.top == null) {
			isEmpty = true;
		} else {
			isEmpty = false;
		}

		return isEmpty;

	}

	public static void main(String[] args) {
		DsLinkedListStack<Integer> stack = new DsLinkedListStack<Integer>();

		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		stack.push(6);
		stack.push(7);

		Object pop;
		while ((pop = stack.pop()) != null) {

			System.out.println(pop);
		}

	}

}
