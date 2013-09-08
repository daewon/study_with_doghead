/**
 * 
 */
package linkedList.doubleLinkedList.setin;

/**
 * @author 두석
 * 
 */
public class DoubleLinkedList<T> {
	private Node<T> head = null;
	private long listSize = 0;

	@SuppressWarnings("hiding")
	private class Node<T> {
		private T value;
		Node<T> nextNode = null;
		Node<T> prevNode = null;

		public Node(T data) {
			this.value = data;
		}

		public T getValue() {
			return this.value;
		}

		@Override
		public String toString() {
			return getValue().toString();
		}
	}

	/**
	 * 데이터를 노드의 가장 마지막에 넣는다
	 * 
	 * @param data
	 */
	public void add(T data) {
		Node<T> newNode = new Node<T>(data);
		if (head == null) {
			head = newNode;
		} else {
			Node<T> lastNode = getLastNode();
			lastNode.nextNode = newNode;
			newNode.prevNode = lastNode;

		}
		increaseSize();
	}

	/**
	 * 특정인덱스에 새로운 노드를 삽입
	 */
	public void add(final int index, T data) {

		validIndex(index);

		Node<T> preNode = getNode(index - 1);

		insertAfter(preNode, data);

		increaseSize();
	}

	/**
	 * 노드 뒤에 해당 노드를 넣음.
	 */
	public void insertAfter(Node<T> currentNode, final T data) {

		Node<T> newNode = new Node<T>(data);

		newNode.nextNode = currentNode.nextNode;

		newNode.prevNode = currentNode;

		if (currentNode.nextNode != null) {
			currentNode.nextNode.prevNode = newNode;
		}

		currentNode.nextNode = newNode;

		increaseSize();

	}

	
	/**
	 * 특정 인덱스의 노드 삭제
	 * @param index
	 */
	public void removeNode(final int index) {

		Node<T> removeNode = getNode(index);

		removeNode(this.head, removeNode);

	}

	/**
	 * 노드삭제
	 * 
	 * @param head
	 * @param removeNode
	 */
	public void removeNode(Node<T> head, Node<T> removeNode) {

		if (head.equals(removeNode)) {

			head = removeNode.nextNode;

			if (head != null) {

				head.prevNode = null;

			}

			removeNode.prevNode = null;
			removeNode.nextNode = null;

		} else {
			Node<T> temp = removeNode;

			removeNode.prevNode.nextNode = temp.nextNode;

			if (removeNode.nextNode != null) {
				removeNode.nextNode.prevNode = temp.prevNode;
			}

			removeNode.prevNode = null;
			removeNode.nextNode = null;

		}
		
		 decreaseSize();

	}

	/**
	 * 특정위치의 노드 탐색
	 * 
	 * @param location
	 * @return
	 */
	public Node<T> getNode(final int location) {
		return getNode(location, this.head);
	}

	/**
	 * 특정위치의 노드탐색
	 * 
	 * @param location
	 * @param headNode
	 * @return
	 */
	public Node<T> getNode(final int location, Node<T> headNode) {

		Node<T> current = headNode;

		int index = location;

		while (current != null && (--index) >= 0) {
			current = current.nextNode;
		}
		return current;
	}

	/**
	 * 노드 탐색
	 * 
	 * @param index
	 */

	private void validIndex(final int index) {
		if (index < 0 || this.size() - 1 < index) {
			throw new IllegalArgumentException("Index is better than List Size");
		}
	}

	/**
	 * 리스트의 가장 마지막 노드를 리턴한다.
	 * 
	 * @return
	 */
	private Node<T> getLastNode() {
		Node<T> node = this.head;
		while (node.nextNode != null) {
			node = node.nextNode;
		}
		return node;
	}

	/**
	 * 리스트의 사이를 확인한다.
	 * 
	 * @return
	 */
	public long size() {
		return listSize;
	}

	private void increaseSize() {
		this.listSize++;
	}

	private void decreaseSize() {
		this.listSize--;
	}

	/**
	 * 리스트 비우기.
	 */
	public void emptyList() {
		this.head = null;
		this.listSize = 0;
	}

	@Override
	public String toString() {
		Node<T> pNode = this.head;
		StringBuffer sb = new StringBuffer();
		String seperator = "|";
		String seperator2 = "\n";
		while (pNode != null) {
			sb.append(pNode).append(seperator).append(seperator2);
			pNode = pNode.nextNode;
		}

		return sb.toString();
	}

	/**
	 * 내용 프린트
	 */
	@Deprecated
	public void printData() {
		System.out.println("Total Size : " + this.size());
		Node<T> pNode = head;
		while (pNode != null) {
			System.out.println(pNode.getValue());
			pNode = pNode.nextNode;
		}
	}

	
	/**
	 * 메인 테스트
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		/*
		 * LinkedList<Integer> list = new LinkedList<>(); list.add(1);
		 * list.add(2); list.add(3); list.add(4); list.add(5); list.printData();
		 * list.delete(3); list.printData(); list.delete(6);
		 */

		/**
		 * 1. 리스트를 생성한다. 2. 리스트에 값을 여러개 넣는다. 3. 리스트의 값을 프린트한다. 4. 특정위치의 리스트를
		 * 삭제한다. 5. 해당 노드가 삭제되었는지 확인한다. 6. 삭제 위치를 인덱스보다 크게해서 Exception을 발생시킨다.
		 */

		DoubleLinkedList<String> stringList = new DoubleLinkedList<>();
		stringList.add("가나다");
		stringList.add("ABC");
		stringList.add(1, "abc");
		System.out.println(stringList.toString());
		
		stringList.removeNode(2);
		System.out.println(stringList.toString());

	}
}
