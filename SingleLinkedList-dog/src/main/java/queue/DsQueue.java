package queue;

import stack.DsLinkedListStack;


public class DsQueue<T> {
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
			top = newNode;
		} else {

			Node<T> lastNode = lastNode();
			lastNode.next = newNode;
		}
	}

	public Node<T> pop() {
		Node<T> topNode = this.top;

		if (topNode != null) {
			this.top = topNode.next;
		}
		return topNode;
	}

	public Node<T> lastNode() {

		Node<T> oldTop = this.top;

		while (oldTop.next != null) {
			oldTop = oldTop.next;
		}
		return oldTop;
	}
	
	
	public static void main(String[] args) {
		DsQueue<Integer> queue = new DsQueue<Integer>();

		queue.push(1);
		queue.push(2);
		queue.push(3);
		queue.push(4);
		queue.push(5);
		queue.push(6);
		queue.push(7);

		Object pop;
		while ((pop = queue.pop()) != null) {

			System.out.println(pop);
		}

	}

}
