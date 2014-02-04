package graph.duseok;

import graph.duseok.DsGraph.VisitMode;

/**
 * @author choids
 * 
 */
public class TagVertex<T> {

	private T data;
	private VisitMode visited;
	private int index;

	private TagVertex next;
	private TagEdge adjacencyList;

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public VisitMode getVisited() {
		return visited;
	}

	public void setVisited(VisitMode visited) {
		this.visited = visited;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public TagVertex getNext() {
		return next;
	}

	public void setNext(TagVertex next) {
		this.next = next;
	}

	public TagEdge getAdjacencyList() {
		return adjacencyList;
	}

	public void setAdjacencyList(TagEdge adjacencyList) {
		this.adjacencyList = adjacencyList;
	}

}