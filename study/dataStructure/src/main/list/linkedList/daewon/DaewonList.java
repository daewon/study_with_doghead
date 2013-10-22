package list.linkedList.daewon;

public class DaewonList {
	  
	  static class Node<T> {
	    private T value;
	    private Node prev;
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
	    public boolean hasPrev() { return this.current != null && this.current.prev != null; }

	    public Node<T> prev() {
	      if (this.hasPrev()) {
	        Node<T> node = this.current;
	        this.current = this.current.prev;
	        return node;
	      } else {
	        return null;
	      }
	    }
	    
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
	  static class DoubleLinkedList<T> {
	    private Node<T> head = null;
	    
	    public DoubleLinkedList<T> append(T value) {
	      Node<T> newNode = new Node(value);
	      if (head == null) {
	        head = newNode;
	      } else {
	        Node<T> lastNode = this.getLast();
	        lastNode.next = newNode;
	        newNode.prev = lastNode;
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

	    // 1, [v], 2
	    public DoubleLinkedList<T> insertAfter(Node<T> newNode, Node<T> target) {
	      Node<T> node = this.head;
	      while (node != null) {
	        if (node == target) {
	          node.next.prev = newNode;
	          newNode.prev = node;
	                    
	          newNode.next = node.next;
	          node.next = newNode;
	          break;
	        }
	        node = node.next;
	      }
	      
	      return this;
	    }
	    // 1 [2] 3
	    public DoubleLinkedList<T> remove(Node<T> target) {
	      Node<T> node = this.head;
	      if (target == this.head && this.head.next != null) {
	        this.head = this.head.next;
	      }
	      
	      while (node != null) {
	        if (node.next == target) {
	          if (target.next != null) {
	            target.next.prev = node;
	          }
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
	    public DoubleLinkedList<T> reverse() {
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
	    DoubleLinkedList<Integer> dll = new DoubleLinkedList<Integer>();
	    
	    dll.append(1);
	    dll.append(2);
	    dll.append(3);
	    dll.append(4);
	    dll.append(5);
	    
	    System.out.println(dll);
	    
	    dll.reverse();
	    
	    System.out.println(dll);

	    dll.reverse();

	    System.out.println(dll);
	    
	    Iterator<Integer> it = dll.getIterator();
	    while (it.hasNext()) {
	      System.out.println(it.next());
	    }

	    it = dll.getIterator();
	    it.next(); // 1
	    it.next(); // 2
	    it.next(); // 3
	    it.next(); // 4
	    it.prev();
	    
	    Node<Integer> newNode = new Node(-1);
	    // inserrt Node(-1) after 5
	    dll.insertAfter(newNode, it.next());
	    System.out.println(dll);

	    // remove last node
	    dll.remove(newNode);
	    System.out.println(dll);

	    // remove first node
	    it = dll.getIterator();
	    dll.remove(it.next());
	    System.out.println(dll);
	  }
	}

