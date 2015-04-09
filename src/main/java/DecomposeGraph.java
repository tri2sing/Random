/**
 * You are given a tree (a simple connected graph with no cycles). 
 * You have to remove as many edges from the tree as possible to obtain a forest with the condition 
 * that each connected component of the forest should contain an even number of vertices.
 * Note: The tree in the input will be such that it can always be decomposed into components containing even number of nodes. 
 */

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

	// The input assumes vertices are 1 ... N, but we store them as 0 ... N-1
	// This function can only be used once when initially creating the graph.
	public void addEdge(int v, int w) {
		this.v[edgesAdded] = v - 1;
		this.w[edgesAdded] = w - 1;
		edgesAdded++;

		G[v - 1][w - 1] = true;
		G[w - 1][v - 1] = true;
	}

	// As we store vertices as 0 ... N-1,
	// we remove edges using 0 ... N - 1.
	private void removeEdge(int v, int w) {
		G[v][w] = false;
		G[w][v] = false;
	}

	// Start at a vertex and traverse all connected vertices
	// It returns the count of the vertices that it reaches
	// from the starting vertex.
	public int traverse(int v) {
		int count = 1;

		visited[v] = true;
		for (int i = 0; i < V; i++) {
			if (i != v && G[v][i] && !visited[i]) {
				count += traverse(i);
			}
		}
		return count;
	}

	// Determine all connected components and return
	// the count of nodes in each connected component
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

	// This function removes an edge from the graph one at a time.
	// If the removal results in components with even number of,
	// then it increments the count. Else, it adds the removed
	// edge back to the graph and goes to the next edge.

	public int decompose() {
		int edges = 0;
		for (int i = 0; i < E; i++) {
			removeEdge(v[i], w[i]);
			boolean odd = false;
			ArrayList<Integer> l = components();
			for (int k : l) {
				if (k % 2 != 0) {
					odd = true;
					G[v[i]][w[i]] = true;
					G[w[i]][v[i]] = true;
					break;
				}
			}
			if (!odd)
				edges++;
		}
		return edges;
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

		/*
		 * ArrayList<Integer> l = dg.components(); for (int i : l) {
		 * System.out.println(i); }
		 */

		System.out.println(dg.decompose());

		in.close();
	}
}
