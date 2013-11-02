package tree.duseok.et;

/**
 * 수식트리 구현
 * 
 * @author 두석
 * 
 */
public class Tree<T> {
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

		public Node(T data) {
			this.data = data;
		}

		public T getData() {
			return data;
		}

	}

	public Node<T> createNode(T data) {
		return new Node<T>(data);
	}


	
}
