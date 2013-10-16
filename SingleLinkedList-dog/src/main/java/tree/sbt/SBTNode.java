package tree.sbt;

/**
 * Simple Binary Tree
 * 
 * @author choids
 * 
 */
public class SBTNode<T> {

	public SBTNode() {
	}

	public SBTNode(T data) {
		this.data = data;
	}

	private T data;

	public SBTNode<T> left;

	public SBTNode<T> right;

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public SBTNode<T> getLeft() {
		return left;
	}

	public void setLeft(SBTNode<T> left) {
		this.left = left;
	}

	public SBTNode<T> getRight() {
		return right;
	}

	public void setRight(SBTNode<T> right) {
		this.right = right;
	}

}
