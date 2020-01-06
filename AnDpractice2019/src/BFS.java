/*==============================================================================================================================
 * 
 * Author: Gregory Rozanski
 * 
 * Breadth First Search
 * 
 * finds shortest path from node s to node t in an undirected graph with no weights
 * 
 * returns true if path from s to t is found false otherwise
 * 
 ===============================================================================================================================*/
import java.util.ArrayList;
import java.util.ListIterator;
public class BFS {
	static Graph g;
	public static void main(String[] args) {
		g  = new Graph(6);
		g.addEdge(0, 1);
		g.addEdge(1, 2);
		g.addEdge(2, 3);
		g.addEdge(4, 5);
		System.out.println(bfs(2,4));
	}
	public static boolean bfs(int u,int t) {
		boolean[] visited = new boolean[g.adj.length];	
		ArrayList<Integer> queue = new ArrayList();
		queue.add(u);
		if(u == t) {
			return true;
		}
		while(!queue.isEmpty()) {
			int curr = queue.get(0);
			queue.remove(0);
			visited[curr] = true;
			ListIterator<Integer> miterator = g.adj[curr].listIterator();
			while(miterator.hasNext()) {
				int next = miterator.next();
				if(next == t) {
					return true;
				}
				if(!visited[next]) {
				queue.add(next);
				}
			}
		}
		return false;
		
	}
}

class Graph{
	int V;
	ArrayList<Integer>[] adj;
	
	public Graph(int v){
		V = v;
		adj = new ArrayList[v];
		for(int i = 0; i<adj.length;i++) {
			adj[i] = new ArrayList<Integer>();
			
		}
	}
	
	public void addEdge(int u, int v) {
		this.adj[u].add(v);
		this.adj[v].add(u);
	}
	
}
