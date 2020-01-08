
/*==============================================================================================================================
 * 
 * Author: Gregory Rozanski
 * 
 * Dynamic Programming Exercise SkiGebiet HS2016
 * 
 * n stations
 * m pists
 * hi = the height of the i-th station the stations are sorted in descending order
 * pists are (i,j) station pairs with i!=j
 * li = lenght of the i-th pist
 * 
 * Find the longest path such that each station at the end of one pist 
 * is the start of the next with exception of the last path
 * 
 * SOLUTION:
 * Model this as a Graph problem. We have a directed Graph with the stations
 * as nodes. There is an edge between two nodes if there is a slope between these two stations
 * Are goal is to find the longest path between any two nodes
 * We use a DP table where DP[i] is the longest path ending at station i;
 * We go through each station and outgoing edges (u,v,c(x)) if DP[v] < DP[u] + c(x) then we overwrite DP[v]
 * The max value will be in DP[V-1]
 * The algorithm has a runtime of O(|V|*|E|)
==============================================================================================================================*/
import java.util.ArrayList;
import java.util.ListIterator;

public class SkiGebiet {

	public static void main(String[] args) {
		Graph g = new Graph(5);
		g.addEdge(0, 2, 1100);
		g.addEdge(0, 4, 1780);
		g.addEdge(2, 4, 1500);
		g.addEdge(1, 3, 950);
		g.addEdge(3, 4, 1300);
		System.out.println(findPath(g));

	}

	public static int findPath(Graph g) {
		int[] res = new int[g.V];
		for (int i = 0; i < g.V; i++) {
			ListIterator<Edge> miterator = g.edges[i].listIterator();

			while (miterator.hasNext()) {
				Edge curr = miterator.next();
				int u = curr.source;
				int v = curr.dest;
				int weight = curr.weight;

				if (res[v] < res[u] + weight) {
					res[v] = res[u] + weight;
				}
			}

		}
//		int max = 0;
//		for(int i = 0; i< g.V;i++) {
//			if(res[i] > max) {
//				max = res[i];
//			}
//		}
		int max = res[g.V - 1];
		return max;
	}

	static class Graph {
		int V;
		ArrayList<Edge>[] edges;

		public Graph(int v) {
			V = v;
			edges = new ArrayList[V];
			for (int i = 0; i < V; i++) {
				edges[i] = new ArrayList<Edge>();
			}

		}

		public void addEdge(int u, int v, int weight) {
			Edge curr = new Edge(u, v, weight);
			this.edges[u].add(curr);
		}

	}

	static class Edge {
		int source;
		int dest;
		int weight;

		public Edge(int u, int v, int weight) {
			source = u;
			dest = v;
			this.weight = weight;

		}
	}
}
