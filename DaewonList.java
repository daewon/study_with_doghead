public class DaewonList {
  static class Node<T> {
    protected T value;
    protected Node next;

    // getter and setter
    public T getValue() { return value; };
    public void setValue(T value) { this.value = value; };
    
    public Node getNext() { return this.next; }
    public void setNext(Node<T> next) { this.next = next; }

    // constructor
    public Node(T value) {
      this.value = value;
    }
  }

  static interface Proc<T> {
    public void apply(T input);
  }
  
  static class SingleLinkedList<T> {
    private Node<T> head  = null;

    public SingleLinkedList<T> append(T value) {
      Node<T> newNode = new Node(value);
      if (head == null) {
        head = newNode;
      } else {
        Node<T> lastNode = this.findLast();
        lastNode.next = newNode;
      }
      return this;
    }

    public Node<T> findLast() {
      Node<T> node = this.head;
      while(node.next != null) {
        node = node.next;
      }
      return node;
    }

    public void forEach(Proc<T> proc) {
      Node<T> node = this.head;
      while(node != null) {
        proc.apply(node.getValue());
        node = node.next;
      }
    }


    private void reverseHelper(Node<T> prev, Node<T> current) {
      if (current.next != null) {
        reverseHelper(current, current.next);
      } else {
        this.head = current; // set head 
      }
      current.next = prev;
    }

    // !! mutable reverse
    public SingleLinkedList<T> reverse() {
      reverseHelper(null, this.head);
      return this;
    }
    
    @Override public String toString() {
      final StringBuilder sb = new StringBuilder();
      final String loopDelim = " -> ";
      forEach(new Proc<T>() {
          @Override public void apply(T value) {
            sb.append(value.toString() + loopDelim);
          }
        });
      String str = sb.toString();
      return str.substring(0, str.length() - loopDelim.length());
    }
  }
  
  public static void main(String[] args) {
    SingleLinkedList<Integer> sll = new SingleLinkedList<Integer>();
    
    sll.append(1);
    sll.append(2);
    sll.append(3);
    sll.append(4);
    sll.append(5);
    
    System.out.println(sll);
    
    sll.reverse();
    
    System.out.println(sll);
  }
}
