package tree.duseok.sbt;

import org.junit.Test;

public class SBTreeTest {

	@Test
	public void SBT_Test() {

		SBTree<String> sb = new SBTree<String>();
		
		SBTNode<String> nodeA = sb.createNode("A");
		SBTNode<String> nodeB = sb.createNode("B");
		SBTNode<String> nodeC = sb.createNode("C");
		SBTNode<String> nodeD = sb.createNode("D");
		SBTNode<String> nodeE = sb.createNode("E");
		SBTNode<String> nodeF = sb.createNode("F");
		SBTNode<String> nodeG = sb.createNode("G");
		
		
		
		nodeA.setLeft(nodeB);
		nodeB.setLeft(nodeC);
		nodeB.setRight(nodeD);
		
		nodeA.setRight(nodeE);
		nodeE.setLeft(nodeF);
		nodeE.setRight(nodeG);
		
		System.out.println("Preorder ....");
		sb.preOrderPrintTree(nodeA);
		System.out.println("\n\n");
		System.out.println("Inorder ....");
		sb.inOrderPrintTree(nodeA);
		
		System.out.println("\n\n");
		System.out.println("Postorder ....");
		sb.postOrderPrintTree(nodeA);
		
		
	}
}
