package elementsOfProgramming.Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class EdgeUsingColor
{
	int source, dest;

	public EdgeUsingColor(int source, int dest) {
		this.source = source;
		this.dest = dest;
	}
};

// Class to represent a graph object
class GraphUsingColor
{
	// A List of Lists to represent an adjacency list
	List<List<Integer>> adjList = null;

	// Constructor
	GraphUsingColor(List<EdgeUsingColor> edges, int N)
	{
		adjList = new ArrayList<>(N);

		for (int i = 0; i < N; i++) {
			adjList.add(i, new ArrayList<>());
		}

		// add edges to the undirected graph
		for (int i = 0; i < edges.size(); i++)
		{
			int src = edges.get(i).source;
			int dest = edges.get(i).dest;

			adjList.get(src).add(dest);
			adjList.get(dest).add(src);
		}
	}
}


public class BipartitieGraphUsingColor {
	
	// Perform DFS on graph starting from vertex v
		public static boolean DFS(GraphUsingColor graph, int v, boolean[] discovered,
								  boolean[] color)
		{
			// do for every edge (v -> u)
			for (int u : graph.adjList.get(v))
			{
				// if vertex u is explored for first time
				if (discovered[u] == false)
				{
					// mark current node as discovered
					discovered[u] = true;
					// set color as opposite color of parent node
					color[u] = !color[v];

					// if DFS on any subtree rooted at v
					// we return false
					if (DFS(graph, u, discovered, color) == false)
						return false;
				}
				// if the vertex is already been discovered and
				// color of vertex u and v are same, then the
				// graph is not Bipartite
				else if (color[v] == color[u]) {
					return false;
				}
			}

			return true;
		}

		public static void main(String[] args) {
			// List of graph edges as per above diagram
			List<EdgeUsingColor> edges = Arrays.asList(
					new EdgeUsingColor(1, 2), new EdgeUsingColor(2, 3), new EdgeUsingColor(2, 8),
					new EdgeUsingColor(3, 4), new EdgeUsingColor(4, 6), new EdgeUsingColor(5, 7),
					new EdgeUsingColor(5, 9), new EdgeUsingColor(8, 9), new EdgeUsingColor(2, 4)
					// if we remove 2->4 edge, graph is becomes Bipartite
			);

			// Set number of vertices in the graph
			final int N = 10;

			// create a graph from edges
			GraphUsingColor graph = new GraphUsingColor(edges, N);

			// stores vertex is discovered or not
			boolean[] discovered = new boolean[N];

			// stores color 0 or 1 of each vertex in BFS
			boolean[] color = new boolean[N];

			// mark source vertex as discovered and
			// set its color to 0
			discovered[0] = true;
			color[0] = false;

			// start DFS traversal from any node as graph
			// is connected and undirected
			if (DFS(graph, 1, discovered, color))
				System.out.println("Bipartite Graph");
			else
				System.out.println("Not a Bipartite Graph");
		}
}
