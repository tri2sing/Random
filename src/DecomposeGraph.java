import java.util.*;

public class DecomposeGraph {

	private int V; // Number of vertices
	private int E; // number of edges
	private int edgesAdded;
	private boolean[][] G; // matrix representing graph
	private int[] v; // vertex 1 for an edge
	private int[] w; // vertex 2 for an edge
	private boolean[] visited;

	public DecomposeGraph(int V, int E) {
		this.V = V;
		this.E = E;
		edgesAdded = 0;
		G = new boolean[V][V];
		v = new int[E];
		w = new int[E];
		visited = new boolean[V];
	}

	// The input assumes vertices are 1 ... N
	// We store them as 0 ... N-1
	public void addEdge(int v, int w) {
		this.v[edgesAdded] = v - 1;
		this.w[edgesAdded] = w - 1;
		edgesAdded++;

		G[v - 1][w - 1] = true;
		G[w - 1][v - 1] = true;
	}

	// As we store vertices as 0 ... N-1,
	// we remove them accordingly frm the graph.
	private void removeEdge(int v, int w) {
		G[v][w] = false;
		G[w][v] = false;
	}
	
	// Start at a vertex and traverse all connected vertices
	// It returns the count of the
	public int traverse(int v) {
		int count = 1;
		
		visited[v] = true;
		for(int i = 0; i < V; i++) {
			if (i != v && G[v][i] && !visited[i]) {
				count += traverse(i);
			}
		}
		return count;
	}

	// Find connected components
	// It returns the count of nodes in each connected component
	public ArrayList<Integer> components() {
		ArrayList<Integer> counts = new ArrayList<Integer>();

		int i;
		for (i = 0; i < V; i++)
			visited[i] = false;
		for (i = 0; i < V; i++) {
			if (!visited[i])
				counts.add(traverse(i));
		}
		return counts;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int V = in.nextInt(); // Number of vertices
		int E = in.nextInt(); // Number edges

		DecomposeGraph dg = new DecomposeGraph(V, E);

		for (int i = 0; i < E; i++) {
			int v = in.nextInt();
			int w = in.nextInt();
			dg.addEdge(v, w);
		}

		in.close();
	}
}
