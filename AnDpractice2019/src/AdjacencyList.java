/*=========================================================================================================
 * 
 * Author: Gregory Rozanski
 * 
 * AdjacencyList Implementation
 * 
 * supports following functionality:
 * 
 * addEdge(int u, int v): creates a directed edge between u and v
 * removeEdge(int u, int v): removes edge (u,v) from  the graph
 * deg(int u): returns the degree of vertice u
 * removeAllOutgoing(int u): removes all outgoing edges of a vertice u
 * hasNeighbour(int u): returns true if u has a neighbour
 * isEdge(int u, int v): returns true if (u,v) is in the graph
 * 
 =========================================================================================================*/
import java.util.ArrayList;

public class AdjacencyList {

	int V;
	ArrayList<Integer>[] adj;

	public static void main(String[] args) {
		AdjacencyList adjacent = new AdjacencyList(6);
		adjacent.addEdge(0, 1);
		adjacent.addEdge(0, 3);
		adjacent.addEdge(1, 1);
		adjacent.addEdge(1, 5);
		adjacent.addEdge(3, 4);
		adjacent.addEdge(5, 0);
		System.out.println(adjacent.isEdge(5, 0));
		adjacent.removeEdge(5, 0);
		System.out.println(adjacent.isEdge(5, 0));
		System.out.println(adjacent.deg(0));
		adjacent.removeAllOutgoing(0);
		System.out.println(adjacent.deg(0));
		System.out.println(adjacent.hasNeighbour(1));
	}

	public AdjacencyList(int v) {
		V = v;
		adj = new ArrayList[V];
		for (int i = 0; i < adj.length; i++) {
			adj[i] = new ArrayList();
		}
	}

	public void addEdge(int u, int v) {
		adj[u].add(v);
	}

	public void removeEdge(int u, int v) {
		int index = adj[u].indexOf(v);
		adj[u].remove(index);
	}

	public int deg(int u) {
		return adj[u].size();
	}

	public void removeAllOutgoing(int u) {
		adj[u].clear();
	}

	public boolean hasNeighbour(int u) {
		if (adj[u].size() >= 1) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isEdge(int u, int v) {
		if (adj[u].contains(v)) {
			return true;
		} else {
			return false;
		}
	}

}
