package tree.daewon;


public class Tree<T> {
  static class Node<T> {
    private T value;
    private Node<T> child;
    private Node<T> sibling;

    /**
     * Make helper
     * using: Node<String> strNode = Node.make("value");
     * instead: Node<String> strNode = new Node<String>("value");
     **/
    public static <T> Node<T> make(T value) {
      return new Node<T>(value);
    }

    private Node(T value) { this.value = value; }

    public Node<T> addChild(Node<T> child) {
      this.child = child;
      return child;
    }

    public Node<T> addSibling(Node<T> sibling) {
      this.sibling = sibling;
      return sibling;
    }

    public void traverse(Consumer<T> consumer) {
      if (this.child != null) { this.child.traverse(consumer); }
      consumer.accept(this.value);
      if (this.sibling != null) { this.sibling.traverse(consumer); }
    }

    @Override public String toString() {
      return "TODO:: ";
    }
  }

  public static void main(String[] args) {
    // root
    Node<String> root = Node.make("0");

    // level 1
    Node<String> lv0_1 = root.addChild(Node.make("1-1"));
    Node<String> lv0_2 = lv0_1.addSibling(Node.make("1-2"));
    Node<String> lv0_3 = lv0_2.addSibling(Node.make("1-3"));

    // level 2
    Node<String> lv2_1 = lv0_1.addChild(Node.make("2-1"));
    Node<String> lv2_2 = lv2_1.addSibling(Node.make("2-2"));

    root.traverse( s -> System.out.print(s) );
  }
}