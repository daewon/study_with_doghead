package heap.duseok;

public class Heap {

	class TagHeapNode{
		int[] nodes;
		int capacity;
		int usedSize;
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
	}
	
	public void swapNodes(TagHeapNode tagHeap, int currentPosition, int parentPosition){
		int temp = tagHeap.nodes[currentPosition];
		tagHeap.nodes[currentPosition] = tagHeap.nodes[parentPosition];
		tagHeap.nodes[parentPosition] = temp; 
	}
	
	
	public int getParent(int index){
		return (int)(index-1)/2;
	}
	
	
}
