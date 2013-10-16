package tree.sbt;

/**
 * Simple Binary Tree body
 * 
 * @author choids
 * 
 */
public class SBTree<T> {

	public SBTNode<T> createNode(T data) {
		return new SBTNode<T>(data);
	}

	/**
	 * 전위 순회를 응용한 이진 트리 출력
	 * 
	 * @param node
	 */
	public void preOrderPrintTree(SBTNode<T> node) {

		if (node == null) {
			return;
		}

		/* 루트 노드 출력 */

		System.out.print(node.getData());

		preOrderPrintTree(node.left);

		preOrderPrintTree(node.right);
	}

	public void inOrderPrintTree(SBTNode<T> node) {

		if (node == null) {
			return;
		}

		/**
		 * 왼쪽 하위 트리 출력
		 */
		inOrderPrintTree(node.left);

		/**
		 * 루트 노드 출력
		 */
		System.out.print(node.getData());

		/**
		 * 오른쪽 하위 트리 출력
		 */
		inOrderPrintTree(node.right);

	}

	public void postOrderPrintTree(SBTNode<T> node) {

		if (node == null) {
			return;
		}

		/**
		 * 왼쪽 하위 트리 출력
		 */
		postOrderPrintTree(node.left);
		/**
		 * 오른쪽 하위 트리 출력
		 */

		postOrderPrintTree(node.right);
		/**
		 * 루트 노드 출력
		 */

		System.out.print(node.getData());

	}
}
