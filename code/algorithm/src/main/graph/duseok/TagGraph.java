package graph.duseok;

public class TagGraph {
	public TagGraph() {
		super();
		this.vertices = null;
		this.vertexcount = 0;
	}

	TagVertex vertices;
	int vertexcount;

	public TagVertex getVertices() {
		return vertices;
	}

	public void setVertices(TagVertex vertices) {
		this.vertices = vertices;
	}

	public int getVertexcount() {
		return vertexcount;
	}

	public void setVertexcount(int vertexcount) {
		this.vertexcount = vertexcount;
	}
}
