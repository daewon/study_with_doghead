package tree;

public class Tree<T> {

	public Node<T> createNode(T data) {
		return new Node<T>(data);
	}

	public void addChildNode(Node<T> parentNode, Node<T> childNode) {

		if (Util.isNull(parentNode.getLeftChild())) {

			parentNode.setLeftChild(childNode);

		} else {

			Node<T> tempNode = parentNode.getLeftChild();
			if (tempNode != null) {

				while (!Util.isNull(tempNode.getRightSibling())) {
					tempNode = tempNode.getRightSibling();
				}
			}
			tempNode.setRightSibling(childNode);
		}
	}

	public void printLevel(Node<T> root, int level){

		
		
	}
	
	public void printTree(Node<T> node, int depth) {

		int i = 0;

		/* 깊이만큼 들여쓰기를 한다. */

		StringBuilder sb = new StringBuilder();
		String space = " ";
		for (i = 0; i < depth; i++) {
			sb.append(space);
		}

		System.out.print(sb.toString());

		System.out.println(node.getData());

		if (!Util.isNull(node.getLeftChild())) {
			printTree(node.getLeftChild(), depth + 1);
		}

		if (!Util.isNull(node.getRightSibling())) {
			printTree(node.getRightSibling(), depth);
		}

	}

}
