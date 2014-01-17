package heap.duseok;

public class Heap {

	class TagHeapNode{
		public TagHeapNode(int capacity) {
			nodes = new int[capacity];
		}
		int[] nodes;
		int capacity = 0 ;
		int usedSize = 0;
	}
	
	public TagHeapNode tagHeap;
	
	public Heap(int capacity) {
		tagHeap = new TagHeapNode(capacity);
	}
	
	
	public void heapInsert(TagHeapNode tagHeap, int data){
		int currentPosition =  tagHeap.usedSize;
		int parentPosition = getParent(currentPosition);
		
		
		if(tagHeap.usedSize == tagHeap.capacity){
			tagHeap.capacity *= 2;
			int currentNodes[] = tagHeap.nodes;
			
			int length = currentNodes.length;
			
			int newNodex[] = new int[length * 2];
			
			System.arraycopy(currentNodes, 0, newNodex, 0, length);
			
			tagHeap.nodes = newNodex;
			
		}
		
		tagHeap.nodes[currentPosition] = data;
		
		while(currentPosition > 0 && tagHeap.nodes[currentPosition] < tagHeap.nodes[parentPosition]){
			swapNodes(tagHeap, currentPosition, parentPosition);
			currentPosition = parentPosition;
			parentPosition = getParent(currentPosition);		
		}
		
		tagHeap.usedSize++;
	}
	
	public void swapNodes(TagHeapNode tagHeap, int currentPosition, int parentPosition){
		int temp = tagHeap.nodes[currentPosition];
		tagHeap.nodes[currentPosition] = tagHeap.nodes[parentPosition];
		tagHeap.nodes[parentPosition] = temp; 
	}
	
	
	public int getParent(int index){
		return (int)(index-1)/2;
	}
	
	public int getLeftChild(int index){
		return (2 * index) + 1;
	}
	
	void printNode(TagHeapNode tagHeap){
		int i = 0 ; 
		for(i = 0; i < tagHeap.usedSize; i++){
			System.out.printf("%d " , tagHeap.nodes[i]);
		}
		System.out.println("");
	}
	
	public static void main(String[] args) {
		
		Heap heap = new Heap(3);
		
		heap.heapInsert(heap.tagHeap, 12);
		heap.heapInsert(heap.tagHeap, 87);
		heap.heapInsert(heap.tagHeap, 111);
		heap.heapInsert(heap.tagHeap, 34);
		heap.heapInsert(heap.tagHeap, 16);
		heap.heapInsert(heap.tagHeap, 75);
		
		heap.printNode(heap.tagHeap);
		
	}
}
