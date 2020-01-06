
/*==============================================================================================================================
 * 
 * Author: Gregory Rozanski
 * 
 * Dijkstra's Algorithm Implementation
 * 
 * Finds shortest path from node s to all other nodes
 * 
 * implemented using priority queue
 * 
 ===============================================================================================================================*/
import java.util.ArrayList;
import java.util.Comparator;
import java.util.ListIterator;
import java.util.PriorityQueue;

public class Dijkstra {
	static Graph g;
	static int[] dist;

	public Dijkstra(Graph g) {
		this.g = g;
	}

	public static void main(String[] args) {
		Dijkstra dike = new Dijkstra(new Graph(6));
		g.addEdge(0, 1, 4);
		g.addEdge(0, 2, 3);
		g.addEdge(1, 2, 5);
		g.addEdge(1, 3, 2);
		g.addEdge(3, 4, 2);
		g.addEdge(2, 3, 7);
		g.addEdge(4, 1, 4);
		g.addEdge(4, 0, 4);
		g.addEdge(4, 5, 6);
		g.addEdge(2, 0, 0);

		System.out.println(dijkstra(0, 1));
		System.out.println(dijkstra(0, 2));
		System.out.println(dijkstra(0, 3));
		System.out.println(dijkstra(0, 4));
		System.out.println(dijkstra(0, 5));
		System.out.println(dijkstra(3, 5));
		System.out.println(dijkstra(2, 5));

	}

	public static int dijkstra(int s, int t) {
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>(new Comparer());
		queue.add(s);

		dist = new int[g.adj.length];
		int[] check = dist;
		boolean[] visited = new boolean[g.adj.length];
		for (int i = 0; i < dist.length; i++) {
			dist[i] = Integer.MAX_VALUE;
		}
		dist[s] = 0;

		while (!queue.isEmpty()) {
			int i = queue.poll();
			visited[i] = true;
			ListIterator<Edge> miterator = g.adj[i].listIterator();

			while (miterator.hasNext()) {
				Edge next = miterator.next();
				if (dist[next.v] > dist[next.u] + next.weight) {
					dist[next.v] = dist[next.u] + next.weight;
				}
				if (!visited[next.v]) {
					queue.add(next.v);
				} else if (queue.contains(next.v)) {
					queue.remove(next.v);
					queue.add(next.v);
				}
			}

		}
		return dist[t];
	}

	static class Comparer implements Comparator<Integer> {
		public int compare(Integer one, Integer two) {
			if (dist[one] < dist[two]) {
				return -1;
			} else {
				return 1;
			}

		}

	}

	static class Graph {
		int V;
		ArrayList<Edge>[] adj;

		public Graph(int v) {
			this.V = v;
			adj = new ArrayList[v];

			for (int i = 0; i < v; i++) {
				adj[i] = new ArrayList<Edge>();
			}

		}

		public void addEdge(int u, int v, int weight) {
			adj[u].add(new Edge(u, v, weight));

		}
	}

	static class Edge {
		int u;
		int v;
		int weight;

		public Edge(int u, int v, int weight) {

			this.u = u;
			this.v = v;
			this.weight = weight;
		}
	}
}
