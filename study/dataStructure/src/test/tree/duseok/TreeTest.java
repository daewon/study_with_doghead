package tree.duseok;

import org.junit.Test;


public class TreeTest {

	@Test
	public void test() {
		
		Tree<String> tree = new Tree<String>();
		
		Node<String> root = tree.createNode("A");
		Node<String> B = tree.createNode("B");
		Node<String> C = tree.createNode("C");
		Node<String> D = tree.createNode("D");
		Node<String> E = tree.createNode("E");
		Node<String> F = tree.createNode("F");
		Node<String> G = tree.createNode("G");
		Node<String> H = tree.createNode("H");
		Node<String> I = tree.createNode("I");
		Node<String> J = tree.createNode("J");
		Node<String> K = tree.createNode("K");
		
		/**
		 * 트리에 노드 추가.
		 */
		
		
		tree.addChildNode(root, B);
			tree.addChildNode(B, C);
			tree.addChildNode(B, D);
				tree.addChildNode(D, E);
				tree.addChildNode(D, F);
		tree.addChildNode(root, G);
			tree.addChildNode(G , H);
		
		tree.addChildNode(root , I);
			tree.addChildNode(I	, J);
				tree.addChildNode(J	, K);
		
		tree.printTree(root, 0);
		
	}

}
