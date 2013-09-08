/**
 * 
 */
package linkedList.singleLinkedList.setin;

/**
 * @author 두석
 * 
 */
public class LinkedList<T> {
	private Node<T> head = null;
	private long listSize = 0;

	@SuppressWarnings("hiding")
	private class Node<T> {
		private T value;
		Node<T> next = null;

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
		Node<T> dataNode = new Node<T>(data);
		if (head == null) {
			head = dataNode;
		} else {
			getLastNode().next = dataNode;
		}
		increaseSize();
	}

	/**
	 * 특정인덱스에 새로운 노드를 삽입
	 */
	public void add(final int index, T data) {

		validIndex(index);

		Node<T> newNode = new Node<T>(data);

		Node<T> preNode = getNode(index - 1);

		if (index == 0) {
			newNode.next = preNode;
			this.head = newNode;
		} else {
			newNode.next = preNode.next;
			preNode.next = newNode;
		}
		increaseSize();
	}

	/**
	 * 노드 뒤에 해당 노드를 넣음.
	 */
	public void insertAfter(Node<T> currentNode, T data) {

		Node<T> newNode = new Node<T>(data);

		newNode.next = currentNode.next;

		currentNode.next = newNode;

		increaseSize();

	}

	/**
	 * 특정위치의 노드 탐색
	 * 
	 * @param location
	 * @return
	 */
	public Node<T> getNode(int location) {
		return getNode(location, this.head);
	}

	/**
	 * 특정위치의 노드탐색
	 * 
	 * @param location
	 * @param headNode
	 * @return
	 */
	public Node<T> getNode(int location, Node<T> headNode) {

		Node<T> current = headNode;
		while (current != null && (--location) >= 0) {
			current = current.next;
		}
		return current;
	}

	/**
	 * 노드 탐색
	 * 
	 * @param index
	 */

	private void validIndex(int index) {
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
		while (node.next != null) {
			node = node.next;
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

	/**
	 * 리스트 삭제 특정위치의 노드를 삭제한다.
	 * 
	 * @param index
	 * @return
	 */
	public void remove(int index) {

		validIndex(index);
		Node<T> node = this.head;
		Node<T> pNode = node;
		if (index == 0) {
			this.head = node.next;
		} else {
			for (int i = 0; i <= index; i++) {
				if (i == index) {
					pNode.next = node.next;
					break;
				}
				pNode = node;
				node = node.next;
			}
		}
		decreaseSize();
	}

	@Override
	public String toString() {
		Node<T> pNode = this.head;
		StringBuffer sb = new StringBuffer();
		String seperator = "|";
		String seperator2 = "\n";
		while (pNode != null) {
			sb.append(pNode).append(seperator).append(seperator2);
			pNode = pNode.next;
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
			pNode = pNode.next;
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

		LinkedList<String> stringList = new LinkedList<>();
		stringList.add("최두석");
		stringList.add("임정은");
		stringList.add("정대원");
		stringList.add("이재경");
		stringList.add("정연오");
		stringList.add("이명박");
		stringList.add("박근혜");

		System.out.println(stringList.toString());

		stringList.remove(5); // 이명박 삭제

		stringList.printData(); // 이명박 삭제됬는지 확인

		try {
			stringList.remove(6); // 리스트에 없는 인덱스 호출
		} catch (IllegalArgumentException iex) {
			System.out.println(iex.getMessage());
		}

		System.out.println(stringList.toString());

		stringList.remove(0);

		System.out.println(stringList.toString());

		stringList.emptyList();

		stringList.add("임성필");

		stringList.add("강병래");

		stringList.add("이현명");

		stringList.add(1, "안세정");

		stringList.add(0, "최두석");

		System.out.println(stringList.size());

		System.out.println(stringList.toString());

	}
}
