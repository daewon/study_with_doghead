package tree.duseok.et;

import static org.hamcrest.CoreMatchers.is;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import tree.duseok.et.Tree.Node;

public class ExpressionTreeTest {

	Tree expressionTree;
	Node rootNode;

	@Before
	public void 수식트리구축() {
		expressionTree = new Tree("71*52-/");
		rootNode = new Node();
		expressionTree.buildExpressionTree(rootNode);
	}

	@Test
	public void 프리오더출력() {
		System.out.println("프리오더 출력");
		expressionTree.preorderPrintTree(rootNode);
		System.out.println();
	}

	@Test
	public void 인오더출력() {
		System.out.println("인오더 출력");
		expressionTree.inorderPrintTree(rootNode);
		System.out.println();
	}

	@Test
	public void 포스트오더출력() {
		System.out.println("포스트오더출력");
		expressionTree.postOrderPrintTree(rootNode);
		System.out.println();
	}

	@Test
	public void 계산하기() {
		assertThat(expressionTree.evaluation(rootNode), is(2.3333333333333335));
	}

	@Test
	public void test() {
		// fail("Not yet implemented");
	}

}
