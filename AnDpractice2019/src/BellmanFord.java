/*=============================================================================================================================
 * 
 * Author: Gregory Rozanski
 * 
 * Bellman Ford Implementation
 * 
 * returns shortest path from a node s to all other nodes
 * 
 ==============================================================================================================================*/
import java.util.ArrayList;

public class BellmanFord {

	public static void main(String[] args) {
		Graph g = new Graph(6);
		g.edges.add(new Edge(0, 1, 4));
		g.edges.add(new Edge(0, 2, 3));
		g.edges.add(new Edge(1, 2, 5));
		g.edges.add(new Edge(1, 3, 2));
		g.edges.add(new Edge(3, 4, 2));
		g.edges.add(new Edge(2, 3, 7));
		g.edges.add(new Edge(4, 1, 4));
		g.edges.add(new Edge(4, 0, 4));
		g.edges.add(new Edge(4, 5, 6));

		int[] arr = bellmanFord(g, 0);
		for (int i = 1; i < arr.length; i++) {
			System.out.println(arr[i]);
		}

	}

	public static int[] bellmanFord(Graph g, int s) {
		int[] dist = new int[g.V];
		for (int i = 0; i < g.V; i++) {
			dist[i] = Integer.MAX_VALUE;
		}
		dist[s] = 0;
		for (int i = 0; i < g.V - 1; i++) {

			for (int j = 0; j < g.edges.size(); j++) {
				Edge curr = g.edges.get(j);
				if (dist[curr.destination] > dist[curr.source] + curr.weight) {
					dist[curr.destination] = dist[curr.source] + curr.weight;
				}
			}
		}

		for (int j = 0; j < g.edges.size(); j++) {
			Edge curr = g.edges.get(j);
			if (dist[curr.destination] > dist[curr.source] + curr.weight) {
				throw new Error("NEGATIVE CYCLE DETECTED");
			}
		}

		return dist;

	}

	static class Graph {
		int V;
		ArrayList<Edge> edges;

		public Graph(int v) {
			V = v;
			edges = new ArrayList<Edge>();
		}
	}

	static class Edge {
		int source;
		int destination;
		int weight;

		public Edge(int u, int v, int weight) {
			source = u;
			destination = v;
			this.weight = weight;
		}
	}
}
