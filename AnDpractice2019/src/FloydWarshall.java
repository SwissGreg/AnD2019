/*=============================================================================================================================
 * 
 * Author: Gregory Rozanski
 * 
 * Floyd Warshall Implementation
 * 
 * returns a matrix of all pairs shortest paths
 * 
 ===============================================================================================================================*/
import java.util.ArrayList;
public class FloydWarshall {

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
		int[][] matrix = floydWarshall(g);
		
		for(int i = 0; i< matrix.length;i++) {
			for(int j = 0; j< matrix[i].length;j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}

	}

	public static int[][] floydWarshall(Graph g) {
		int[][] dist = new int[g.V][g.V];

		for (int i = 0; i < g.V; i++) {
			for (int j = 0; j < g.V; j++) {
				if (i == j) {
					dist[i][j] = 0;
				} else {
					dist[i][j] = 1000;
				}
			}
		}
		for (int i = 0; i < g.edges.size(); i++) {
			Edge curr = g.edges.get(i);
			dist[curr.source][curr.dest] = curr.weight;
		}

		for (int a = 0; a < g.V; a++) {
			for (int b = 0; b < g.V; b++) {
				for (int c = 0; c < g.V; c++) {
					if (dist[b][c] > dist[b][a] + dist[a][c]) {
						dist[b][c] = dist[b][a] + dist[a][c];
					}
				}
			}
		}
		
		for(int i = 0; i< g.V;i++) {
			if(dist[i][i] < 0) {
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
		int dest;
		int weight;

		public Edge(int u, int v, int weigth) {
			source = u;
			dest = v;
			this.weight = weigth;

		}
	}
}
