import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class DijkstraAlgorithm {

	HashMap<Integer, List<Integer>> graph;

	public DijkstraAlgorithm(int numVertices) {
		graph = new HashMap<>(numVertices);
	}

	public void addEdge(int u, int v) {
		List<Integer> neighbors = graph.get(u);
		if (neighbors == null) {
			neighbors = new LinkedList<Integer>();
		}
		neighbors.add(v);
		graph.put(u, neighbors);
	}

	public void printGraph() {
		for (Map.Entry<Integer, List<Integer>> entry : graph.entrySet()) {
			System.out.println(entry.getKey() + ": " + entry.getValue().toString());
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int numTests = in.nextInt();
		for (int i = 0; i < numTests; i++) {

		}
		in.close();
	}

}
