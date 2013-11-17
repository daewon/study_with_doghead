package tree.daewon.binaryTree;


// binary tree
class Tree{
  public static class BinaryTree<T> {
    public BinaryTree<T> left;
    public BinaryTree<T> right;
    public T value;

    public BinaryTree(T value) {
      this.value = value;
    }

    @Override public String toString() {
      return this.value.toString();
    }

    public void preorder() {
      System.out.printf("%s ->", value);

      if (this.left != null) this.left.preorder();
      if (this.right != null) this.right.preorder();
    }

    public void postorder() {
      if (this.left != null) this.left.postorder();
      if (this.right != null) this.right.postorder();
      System.out.printf("%s ->", value);
    }

    public void inorder() {
      if (this.left != null) this.left.inorder();
      System.out.printf("%s ->", value);
      if (this.right != null) this.right.inorder();
    }

    public void levelorder() {
      // first record level
      // using second stack and queue
      //
    }
  }

  public static void main(String[] args) throws Exception {
      BinaryTree<String> root = new BinaryTree<>("A");
      root.left = new BinaryTree<>("B");
      root.left.left = new BinaryTree("C");
      root.left.right = new BinaryTree("D");

      root.right = new BinaryTree<>("E");
      root.right.left = new BinaryTree<>("F");
      root.right.right = new BinaryTree<>("G");

      root.preorder();
      System.out.println();
      root.inorder();
      System.out.println();
      root.postorder();
      System.out.println();
      root.levelorder();
      System.out.println();
  }
}
