package elementsOfProgramming.Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/*
 * 
 * We traverse the graph starting from u. Each time we encounter a vertex
or an edge that is not yet in the clone, we add it to the clone. We recognize new
vertices by maintaining a hash table mapping vertices in the original graph to their
counterparts in the new graph. Any standard graph traversal algorithm works—the
code below uses breadth first search.
 */

public class CloneAGraph {

	public static class GraphVertex {
		public int label;
		public List<GraphVertex> edges;
		public GraphVertex(int label) {
			this.label = label ;
			edges = new ArrayList <>();
		}
	}
	public static GraphVertex cloneGraph(GraphVertex g) {
		if (g == null) {
			return null ;
		}
		Map<GraphVertex , GraphVertex> vertexMap = new HashMap<>();
		Queue<GraphVertex> q = new LinkedList<>();
		q.add(g);
		vertexMap.put(g , new GraphVertex(g.label));
		
		while(! q.isEmpty()){
			GraphVertex v = q.remove();
			for (GraphVertex e : v.edges) {
				// Try to copy vertex e.
				if (!vertexMap.containsKey(e)){
					vertexMap.put(e, new GraphVertex(e.label));
					q.add(e);
				}
				// Copy edge .
				vertexMap.get(v).edges.add(vertexMap.get(e));
			}
		}
		return vertexMap.get(g);
	}
}
