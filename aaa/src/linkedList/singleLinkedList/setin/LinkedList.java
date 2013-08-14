/**
 * 
 */
package linkedList.singleLinkedList.setin;

/**
 * @author 두석 
 * 
 */
public class LinkedList<T> {
	private Node<T> node = null;
	private long size = 0;

	@SuppressWarnings("hiding")
	private class Node<T> {
		T t;
		Node<T> next = null;

		public Node(T data) {
			this.t = data;
		}

		public T getValue() {
			return this.t;
		}
	}

	public void insertData(T data) {
		Node<T> dataNode = new Node<T>(data);
		if (node == null) {
			node = dataNode;
		} else {
			getLast().next = dataNode;
		}
		size++;
	}

	public Node<T> getLast() {
		Node<T> node = this.node;
		while (node.next != null) {
			node = node.next;
		}
		return node;
	}

	public long getSize() {
		return size;
	}

	public void printData() {
		System.out.println("Total Size : " + this.getSize());
		Node<T> pNode = node;
		while (pNode != null) {
			System.out.println(pNode.getValue());
			pNode = pNode.next;
		}
	}

	public boolean delete(int index) {
		if (this.getSize() < index) {
			throw new IllegalArgumentException("Index is better than List Size");
		}
		Node<T> node = this.node;
		int count = 0;
		boolean checkIndex = false;
		Node<T> pNode = null;
		while (node.next != null) {
			if (count == index) {
				pNode.next = node.next;
				checkIndex = true;
				this.size--;
				break;
			}
			pNode = node;
			node = node.next;
			count++;
		}
		return checkIndex;
	}

	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<>();
		list.insertData(1);
		list.insertData(2);
		list.insertData(3);
		list.insertData(4);
		list.insertData(5);
		list.printData();
		list.delete(3);
		list.printData();
		list.delete(6);
	}
}
