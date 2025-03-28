package elementsOfProgramming.Graphs;

import java.util.Iterator;
import java.util.LinkedList;

class GraphDetectingCycle {
	private int V;   // No. of vertices 
	private LinkedList<Integer> adj[]; // Adjacency List Represntation 

	// Constructor 
	GraphDetectingCycle(int v) { 
		V = v; 
		adj = new LinkedList[v]; 
		for(int i=0; i<v; ++i) 
			adj[i] = new LinkedList(); 
	} 

	// Function to add an edge into the graph 
	void addEdge(int v,int w) { 
		adj[v].add(w); 
		adj[w].add(v); 
	} 

	// A recursive function that uses visited[] and parent to detect 
	// cycle in subgraph reachable from vertex v. 
	Boolean isCyclicUtil(int v, Boolean visited[], int parent) 
	{ 
		// Mark the current node as visited 
		visited[v] = true; 
		Integer i; 

		// Recur for all the vertices adjacent to this vertex 
		Iterator<Integer> it = adj[v].iterator(); 
		while (it.hasNext()) 
		{ 
			i = it.next(); 

			// If an adjacent is not visited, then recur for that 
			// adjacent 
			if (!visited[i]) 
			{ 
				if (isCyclicUtil(i, visited, v)) 
					return true; 
			} 

			// If an adjacent is visited and not parent of current 
			// vertex, then there is a cycle. 
			else if (i != parent) 
				return true; 
		} 
		return false; 
	} 

	// Returns true if the graph contains a cycle, else false. 
	Boolean isCyclic() 
	{ 
		// Mark all the vertices as not visited and not part of 
		// recursion stack 
		Boolean visited[] = new Boolean[V]; 
		for (int i = 0; i < V; i++) 
			visited[i] = false; 

		// Call the recursive helper function to detect cycle in 
		// different DFS trees 
		for (int u = 0; u < V; u++) 
			if (!visited[u]) // Don't recur for u if already visited 
				if (isCyclicUtil(u, visited, -1)) 
					return true; 

		return false; 
	} 
}

public class DetectADeadlockOrACycle {

	/*
	 * 
	 * We can check for the existence of a cycle in G by running DFS on G. Recall
DFS maintains a color for each vertex. Initially, all vertices are white. When a vertex
is first discovered, it is colored gray. When DFS finishes processing a vertex, that
vertex is colored black.
As soon as we discover an edge from a gray vertex back to a gray vertex, a cycle
exists in G and we can stop. Conversely, if there exists a cycle, once we first reach
vertex in the cycle (call it v),we will visit its predecessor in the cycle (call it u) before
finishing processing v, i.e., we will find an edge from a gray to a gray vertex. In
summary, a cycle exists if and only if DFS discovers an edge from a gray vertex to a
gray vertex. Since the graph may not be strongly connected, we must examine each
vertex, and run DFS from it if it has not already been explored.
	 * 
	 * 
	 * 
	 */
	
	public static void main(String args[]) 
    { 
        // Create a graph given in the above diagram 
		GraphDetectingCycle g1 = new GraphDetectingCycle(5); 
        g1.addEdge(1, 0); 
        g1.addEdge(0, 2); 
        g1.addEdge(2, 1); 
        g1.addEdge(0, 3); 
        g1.addEdge(3, 4); 
        if (g1.isCyclic()) 
            System.out.println("Graph contains cycle"); 
        else
            System.out.println("Graph doesn't contains cycle"); 
  
        GraphDetectingCycle g2 = new GraphDetectingCycle(3); 
        g2.addEdge(0, 1); 
        g2.addEdge(1, 2); 
        if (g2.isCyclic()) 
            System.out.println("Graph contains cycle"); 
        else
            System.out.println("Graph doesn't contains cycle"); 
    }
}
