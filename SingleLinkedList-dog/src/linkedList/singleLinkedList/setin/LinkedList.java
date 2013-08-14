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
		private T tData;
		Node<T> next = null;

		public Node(T data) {
			this.tData = data;
		}

		public T getValue() {
			return this.tData;
		}
	}

	/**
	 * 데이터를 노드의 가장 마지막에 넣는다
	 * 
	 * @param data
	 */
	public void add(T data) {
		Node<T> dataNode = new Node<T>(data);
		if (node == null) {
			node = dataNode;
		} else {
			getLast().next = dataNode;
		}
		plusSize();
	}
	
	/**
	 * 특정위치에 새로운 노드를 삽입
	 */
	public void add(int index) {

	}

	/**
	 * 리스트의 가장 마지막 노드를 리턴한다.
	 * 
	 * @return
	 */
	private Node<T> getLast() {
		Node<T> node = this.node;
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
	public long getSize() {
		return size;
	}

	private void plusSize() {
		this.size++;
	}

	private void minusSize() {
		this.size--;
	}

	/**
	 * 리스트 비우기.
	 */
	public void emptyList() {
		this.node = null;
		this.size = 0;
	}

	/**
	 * 내용 프린트
	 */
	public void printData() {
		System.out.println("Total Size : " + this.getSize());
		Node<T> pNode = node;
		while (pNode != null) {
			System.out.println(pNode.getValue());
			pNode = pNode.next;
		}
	}

	/**
	 * 리스트 삭제 특정위치의 노드를 삭제한다.
	 * 
	 * @param index
	 * @return
	 */
	public boolean delete(int index) {
		if (this.getSize() - 1 < index) {
			throw new IllegalArgumentException("Index is better than List Size");
		}
		Node<T> node = this.node;
		int count = 0;
		boolean checkIndex = false;
		Node<T> pNode = node;
		if (index == 0) {
			this.node = node.next;
		} else {
			for (int i = 0; i <= index; i++) {
				if (i == index) {
					pNode.next = node.next;
					checkIndex = true;
					break;
				}
				pNode = node;
				node = node.next;
			}
		}
		minusSize();
		return checkIndex;
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

		stringList.printData();

		stringList.delete(5); // 이명박 삭제

		stringList.printData(); // 이명박 삭제됬는지 확인

		try {
			stringList.delete(6); // 리스트에 없는 인덱스 호출
		} catch (IllegalArgumentException iex) {
			System.out.println(iex.getMessage());
		}

		stringList.printData(); // 삭제됬는지 확인

		stringList.delete(0);

		stringList.printData();

		stringList.emptyList();

		stringList.printData();

	}
}
