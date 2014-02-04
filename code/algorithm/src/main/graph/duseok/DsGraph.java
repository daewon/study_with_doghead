package graph.duseok;

public class DsGraph<T> {
	public enum VisitMode {
		visited, notVisited
	};

	TagGraph createGraph() {
		TagGraph graph = new TagGraph();
		return graph;
	}

	TagVertex<T> createTagVertex(T data) {
		TagVertex<T> v = new TagVertex<T>();
		v.setData(data);
		v.setVisited(VisitMode.visited);
		v.setIndex(-1);
		return v;
	}

	TagEdge createEdge(TagVertex<?> from, TagVertex<?> target, int weight) {
		TagEdge e = new TagEdge();

		e.setFrom(from);
		e.setTarget(target);
		e.setWeight(weight);

		return e;
	}

	void addVertex(TagGraph g, TagVertex<?> v) {

		TagVertex vertexList =  g.getVertices();
		
		if (g.getVertices() == null) {
			g.setVertices(v);
		} else {
			while ( vertexList.getNext() != null) {
				vertexList = vertexList.getNext();
			}
			vertexList.setNext(v);
		}

		g.setVertexcount(g.getVertexcount() + 1);

		v.setIndex(g.getVertexcount());
	}

	void addEdge(TagVertex<?> v, TagEdge e) {

		if (v.getAdjacencyList() == null) {
			v.setAdjacencyList(e);
		} else {
			TagEdge adjacencyList = v.getAdjacencyList();
			
			while (adjacencyList.getNext() != null) {
				adjacencyList = adjacencyList.getNext();
			}
			adjacencyList.setNext(e);
			//v.setAdjacencyList(adjacencyList);
		}

	}

	void printGraph(TagGraph g) {

		TagVertex<?> v = null;

		TagEdge e = null;

		if ((v = g.getVertices()) == null) {
			return;
		}

		while (v != null) {

			System.out.print(v.getData() + " : ");

			if ((e = v.getAdjacencyList()) == null) {
				v = v.getNext();
				System.out.println(" ");
				continue;
			}

			while (e != null) {
				System.out
						.print(e.getTarget().getData() + "[" + e.getWeight() + "] ");
				e = e.getNext();
			}

			System.out.println("");
			v = v.getNext();

		}

		System.out.println("");
	}

	public static void main(String[] args) {

		DsGraph<Integer> dsGraph = new DsGraph<Integer>();

		TagGraph graph =dsGraph.createGraph();
		
		
		TagVertex<Integer> v1 = dsGraph.createTagVertex(1);
		TagVertex<Integer> v2 = dsGraph.createTagVertex(2);
		TagVertex<Integer> v3 = dsGraph.createTagVertex(3);
		TagVertex<Integer> v4 = dsGraph.createTagVertex(4);
		TagVertex<Integer> v5 = dsGraph.createTagVertex(5);
		
		
		dsGraph.addVertex(graph, v1);
		dsGraph.addVertex(graph, v2);
		dsGraph.addVertex(graph, v3);
		dsGraph.addVertex(graph, v4);
		dsGraph.addVertex(graph, v5);

		dsGraph.addEdge(v1, dsGraph.createEdge(v1, v2, 0));
		dsGraph.addEdge(v1, dsGraph.createEdge(v1, v3, 0));
		dsGraph.addEdge(v1, dsGraph.createEdge(v1, v4, 0));
		dsGraph.addEdge(v1, dsGraph.createEdge(v1, v5, 0));
		
		dsGraph.addEdge(v2, dsGraph.createEdge(v2, v1, 0));
		dsGraph.addEdge(v2, dsGraph.createEdge(v2, v3, 0));
		dsGraph.addEdge(v2, dsGraph.createEdge(v2, v5, 0));
		
		dsGraph.addEdge(v3, dsGraph.createEdge(v3, v1, 0));
		dsGraph.addEdge(v3, dsGraph.createEdge(v3, v2, 0));
		
		dsGraph.addEdge(v4, dsGraph.createEdge(v4, v1, 0));

		dsGraph.addEdge(v5, dsGraph.createEdge(v5, v1, 0));
		dsGraph.addEdge(v5, dsGraph.createEdge(v5, v2, 0));
		dsGraph.addEdge(v5, dsGraph.createEdge(v5, v4, 0));
		
		dsGraph.printGraph(graph);
	}

}
