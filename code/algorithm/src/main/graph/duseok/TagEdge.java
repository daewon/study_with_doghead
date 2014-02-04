package graph.duseok;


public class TagEdge {

	private int weight;
	private TagEdge next;
	private TagVertex from;
	private TagVertex target;

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public TagEdge getNext() {
		return next;
	}

	public void setNext(TagEdge next) {
		this.next = next;
	}

	public TagVertex getFrom() {
		return from;
	}

	public void setFrom(TagVertex from) {
		this.from = from;
	}

	public TagVertex getTarget() {
		return target;
	}

	public void setTarget(TagVertex target) {
		this.target = target;
	}

}