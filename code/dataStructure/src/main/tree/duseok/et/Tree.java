package tree.duseok.et;

/**
 * 수식트리 구현
 * 
 * @author 두석
 * 
 */
public class Tree {

	private String expression;

	public Tree(String expression) {
		this.expression = expression;
	}

	private Node rootNode;

	public Node getRootNode() {
		return rootNode;
	}

	@SuppressWarnings("hiding")
	public static class Node {

		private char data;

		public void setData(char data) {
			this.data = data;
		}

		public Node left;

		public Node right;

		public Node getLeft() {
			return left;
		}

		public void setLeft(Node left) {
			this.left = left;
		}

		public Node getRight() {
			return right;
		}

		public void setRight(Node right) {
			this.right = right;
		}

		public Node() {

		}

		public char getData() {
			return data;
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();

			sb.append("data:").append(getData());
			if (left != null) {
				sb.append("left :").append(left.getData());
			}
			if (right != null) {
				sb.append("right :").append(right.getData());
			}
			return sb.toString();

		}
	}

	public Node createNode(Character data) {

		Node newNode = new Node();
		newNode.data = data;

		return newNode;
	}

	public void preorderPrintTree(Node node) {
		if (node == null) {
			return;
		}
		printNode(node);
		preorderPrintTree(node.getLeft());
		preorderPrintTree(node.getRight());
	}

	public void inorderPrintTree(Node node) {
		if (node == null) {
			return;
		}

		System.out.print("(");

		inorderPrintTree(node.getLeft());

		printNode(node);

		inorderPrintTree(node.getRight());

		System.out.print(")");

	}

	public void postOrderPrintTree(Node node) {
		if (node == null) {
			return;
		}

		postOrderPrintTree(node.getLeft());

		postOrderPrintTree(node.getRight());

		printNode(node);
	}

	public void buildExpressionTree(Node node) {
		int len = expression.length();
		char token = expression.charAt(len - 1);
		expression = expression.substring(0, len - 1);

		switch (token) {
		case '+':
		case '-':
		case '*':
		case '/':
			if (node == null)
				node = new Node();
			node.setData(token);
			node.setRight(new Node());
			node.setLeft(new Node());
			buildExpressionTree(node.getRight());
			buildExpressionTree(node.getLeft());
		default: // 피연사인 경우
			node.setData(token);
			;
		}
	}

	/**
	 * 프린트 노드.
	 * 
	 * @param node
	 */
	public void printNode(Node node) {
		if (node == null) {
			return;
		}
		System.out.print(" " + node.getData());
	}

	public double evaluation(Node tree) {

		double left, right, result = 0f;

		if (tree == null)
			return 0;

		switch (tree.getData()) {
		case '+':
		case '-':
		case '*':
		case '/':
			left = evaluation(tree.getLeft());
			right = evaluation(tree.getRight());
			if (tree.getData() == '+')
				result = left + right;
			else if (tree.getData() == '-')
				result = left - right;
			else if (tree.getData() == '*')
				result = left * right;
			else if (tree.getData() == '/')
				result = left / right;
			break;

		default:
			result = Double.parseDouble(String.valueOf(tree.getData()));
			break;
		}

		return result;

	}

	public static void main(String[] args) {

		String postfixExpression = "1234567890";

		int len = postfixExpression.length();
		char token = postfixExpression.charAt(len - 1);
		postfixExpression = postfixExpression.substring(0, len - 1);

		System.out.println(token);
		System.out.println(postfixExpression);
	}

}
