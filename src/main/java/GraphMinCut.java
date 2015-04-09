import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class GraphMinCut {

	private final int numVertices; // Number of vertices

	// A map of vertex to the other vertices to which it has edges.
	// A vertex as a set allows us to handle vertex contraction.
	// For an undirected graph we can use a set as the value.
	private HashMap<HashSet<Integer>, HashSet<Integer>> graph;

	// The edges in the graph, need to track for contraction.
	// A set as they key ensures that there is only
	// one entry in the map for uv and vu.
	private HashMap<HashSet<Integer>, Boolean> edges;

	// We need to track the super vertex that a contracted 
	// vertex is member of over the computation.
	private HashMap<Integer, HashSet<Integer>> contractionMap;
	
	public GraphMinCut(int numVertices) {
		this.numVertices = numVertices;
		graph = new HashMap<HashSet<Integer>, HashSet<Integer>>(numVertices);
		for (int i = 0; i < numVertices; i++) {
			graph.put(new HashSet<Integer>(new Integer(i)),
					new HashSet<Integer>());
		}
		edges = new HashMap<HashSet<Integer>, Boolean>();
		contractionMap = new HashMap<Integer, HashSet<Integer>>(numVertices);
		for (int i = 0; i < numVertices; i++) {
			contractionMap.put(new Integer(i), new HashSet<Integer>());
		}
	}

	private void addEdge(int u, int v) {
		System.out.format("Adding edge (%d, %d)\n", u, v);

		graph.get(new HashSet<Integer>(new Integer(u - 1))).add(new Integer(v - 1));
		HashSet<Integer> hSet = new HashSet<Integer>();
		hSet.add(new Integer(u - 1));
		hSet.add(new Integer(v - 1));
		edges.put(hSet, Boolean.TRUE);
	}

	public void readAdjacencyListFile(String filePath)
			throws FileNotFoundException {

		Scanner scan = new Scanner(new File(filePath));
		while (scan.hasNextLine()) {
			String line = scan.nextLine();
			String[] parts = line.split("\\s+");
			int u = Integer.parseInt(parts[0]);
			for (int i = 1; i < parts.length; i++) {
				int v = Integer.parseInt(parts[i]);
				addEdge(u, v);
			}

		}
		scan.close();
	}

	private void contract(int u, int v) {

	}

	/**
	 * @return the vertices
	 */
	public int getNumberOfVertices() {
		return numVertices;
	}

	/**
	 * @return the edges
	 */
	public int getNumberOfEdges() {
		return edges.size();
	}

	public static void main(String[] args) throws FileNotFoundException {
		int V = Integer.parseInt(args[0]);
		GraphMinCut gmc = new GraphMinCut(V);
		gmc.readAdjacencyListFile(args[1]);
		System.out.format("The graph has %d vertices\n", gmc.getNumberOfVertices());
		System.out.format("The graph has %d edges\n", gmc.getNumberOfEdges());
	}

}
