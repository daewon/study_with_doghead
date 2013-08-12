public class DaewonList {
  
  static class Node<T> {
    private T value;
    private Node next;
    
    public T getValue() { return value; };
    public Node(T value) {
      this.value = value;
    }

    @Override public String toString() {
      return this.value.toString();
    }
  }

  /**
   * Iterator
   * !! Node Value가 아니라 Node를 반환
   */
  static class Iterator<T> {
    private Node<T> current = null;
   
    public Iterator(Node<T> node) {
      this.current = node;
    }

    public Node<T> getNode() { return this.current; }
    public boolean hasNext() { return this.current != null; }


    // 현재 노드를 반환하고 다음 노드로 이동
    public Node<T> next() {
      if (this.hasNext()) {
        Node<T> node = this.current;
        this.current = this.current.next;
        return node;
      } else {
        return null;
      }
    }
  }

  /**
   * 단방향 리스트
   */
  static class SingleLinkedList<T> {
    private Node<T> head = null;
    
    public SingleLinkedList<T> append(T value) {
      Node<T> newNode = new Node(value);
      if (head == null) {
        head = newNode;
      } else {
        Node<T> lastNode = this.getLast();
        lastNode.next = newNode;
      }
      
      return this;
    }

    public Iterator<T> getIterator() { return new Iterator(this.head); }
    
    private Node<T> getLast() {
      Node<T> node = this.head;
      while (node.next != null) {
        node = node.next;
      }
      
      return node;
    }

    /**
     * src 노드를  target 노드 뒤로 삽입
     */
    public SingleLinkedList<T> insertAfter(Node<T> newNode, Node<T> target) {
      Node<T> node = this.head;
      while (node != null) {
        if (node == target) {
          newNode.next = node.next;
          node.next = newNode;
          break;
        }
        node = node.next;
      }
      
      return this;
    }

    public SingleLinkedList<T> remove(Node<T> target) {
      Node<T> node = this.head;
      while (node != null) {
        if (node.next == target) {
          node.next = target.next;
          break;
        }
        node = node.next;
      }
      
      return this;
    }

    // !! mutable reverse
    private void reverseHelper(Node<T> prev, Node<T> current) {
      if (current.next != null) {
        reverseHelper(current, current.next);
      } else {
        this.head = current; // get last node! set head node
      }
      
      current.next = prev;
    }
    public SingleLinkedList<T> reverse() {
      if (this.head != null) {
        reverseHelper(null, this.head);
      }
      
      return this;
    }
    
    @Override public String toString() {
      StringBuilder sb = new StringBuilder();
      
      Node<T> node = this.head;
      while (node != null) {
        sb.append(node);
        if (node.next != null){
          sb.append(" -> ");
        }
        node = node.next;
      }
      
      return sb.toString();
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

    sll.reverse();

    System.out.println(sll);
    
    Iterator<Integer> it = sll.getIterator();
    while (it.hasNext()) {
      System.out.println(it.next());
    }

    it = sll.getIterator();
    it.next(); // 1
    it.next(); // 2
    it.next(); // 3
    it.next(); // 4
    
    Node<Integer> newNode = new Node(-1);
    // inserrt Node(-1) after 5
    sll.insertAfter(newNode, it.next());
    System.out.println(sll);
    
    sll.remove(newNode);
    System.out.println(sll);
  }
}
