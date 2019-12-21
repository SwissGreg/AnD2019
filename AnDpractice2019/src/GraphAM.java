/*=========================================================================================================
 * 
 * Author: Gregory Rozanski
 * 
 * Graph Adjacency Matrix implementation
 * 
 * supports following functionality:
 * 
 * addEdge(int u, int v): adds an edge between vertices u and v
 * removeEdge(int u, int v): removes the edge between vertices u and v
 * removeAllOutgoing(int u): removes all outgoing edges from u
 * removeAllIncoming(int u): removes all incoming edges to u
 * findNeighbours(int u): outputs all neighbours of vertice u
 * deg(int u): outputs the degree of vertice u
 * 
 ========================================================================================================*/
public class GraphAM {
	int[][] matrix;
	int V;

	public static void main(String[] args) {
		GraphAM graph = new GraphAM(6);
		graph.addEdge(0, 2);
		graph.addEdge(0, 3);
		graph.addEdge(3, 4);
		graph.addEdge(1, 4);
		graph.addEdge(4, 2);
		graph.addEdge(2, 2);
		graph.deg(0);
		graph.findNeighbours(4);
		graph.removeEdge(4, 2);
		graph.deg(4);
		graph.removeAllOutgoing(0);
		graph.deg(0);
		graph.deg(1);
		graph.removeAllIncoming(4);
		graph.deg(1);

	}

	public GraphAM(int v) {
		this.V = v;
		matrix = new int[V][V];
	}

	public void addEdge(int u, int v) {
		matrix[u][v] = 1;
	}

	public void removeEdge(int u, int v) {
		matrix[u][v] = 0;
	}

	public void removeAllOutgoing(int u) {
		for (int i = 0; i < matrix[u].length; i++) {
			matrix[u][i] = 0;
		}
	}

	public void removeAllIncoming(int u) {
		for (int i = 0; i < matrix.length; i++) {
			matrix[i][u] = 0;
		}
	}

	public void findNeighbours(int u) {
		for (int i = 0; i < matrix.length; i++) {
			if (matrix[u][i] == 1) {
				System.out.print(i + " ");
			}
		}
		System.out.println();
	}

	public void deg(int u) {
		int counter = 0;
		for (int i = 0; i < matrix.length; i++) {
			if (matrix[u][i] == 1) {
				counter++;
			}
		}
		System.out.println(counter);
	}
}
