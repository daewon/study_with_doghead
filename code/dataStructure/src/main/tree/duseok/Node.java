package tree.duseok;

public class Node<T> {

	private T data;

	public Node<T> leftChild;

	public Node<T> righSibling;

	public Node<T> getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(Node<T> leftChild) {
		this.leftChild = leftChild;
	}

	public Node<T> getRightSibling() {
		return righSibling;
	}

	public void setRightSibling(Node<T> rightSibling) {
		this.righSibling = rightSibling;
	}

	Node(T data) {
		this.data = data;
	}

	public T getData() {
		return data;
	}

}
