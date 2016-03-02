import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/* The board is always of the size 10 x 10 and squares are always numbered 1 to 100. 
 * Input format:
 * Line 1: T number of test cases.
 * For each test case:
 *     Line 1: N number of ladders.
 *     Line 2 to N + 1: two integers representing start and end of ladder.
 *     Line N + 2: M: nunber of snakes.
 *     Line N + 3 to N + 3 + M: two integers representing start and end of snake.
 */

public class SnakesLadders {

	private static int BOARD_MAX = 100;
	private static int BOARD_MIN = 1;
	private static int DICE_MAX = 6;
	private static int DICE_MIN = 1;

	// This is a linked list of connected vertices representation.
	// Each square connects to at most six squares using die rolls.
	// An alternate is adjacency matrix but that would waste space.
	// Traversals are slower in linked list than the matrix form.
	private HashMap<Integer, List<Integer>> board;

	public SnakesLadders() {
		board = new HashMap<Integer, List<Integer>>();
		for (int i = BOARD_MIN; i < BOARD_MAX + 1; i++) {
			// Construct a board without any snakes or ladders.
			board.put(i, getDestinations(i));
		}
	}

	public void printBoard() {
		for (int i = BOARD_MIN; i < BOARD_MAX + 1; i++) {
			// Construct a board without any snakes or ladders.
			List<Integer> neighbors = board.get(i);
			if (neighbors == null) {
				continue;
			}
			System.out.print("Node " + i + ": ");
			for (Integer neighbor : neighbors) {
				System.out.print(neighbor.intValue() + " ");
			}
			System.out.println();
		}
	}

	public void addLadder(int start, int end) {
		// Modify each square from where you can reach the the start
		// of the ladder to point to the destination of the ladder.
		for (Integer source : getSources(start)) {
			List<Integer> destinations = board.get(source);
			if (destinations == null) {
				continue;
			}
			for (int i = 0; i < destinations.size(); i++) {
				if (destinations.get(i).intValue() == start) {
					destinations.set(i, end);
				}
			}
			board.put(source, destinations);
			// There is no die roll when you land on the start square. So, for
			// the start square remove the list we had built up in the constructor.
			board.remove(start);
		}
	}

	public void addSnake(int start, int end) {
		// Logically there is no difference between adding a snake or ladder.
		// Physically the difference is that start < end in ladder and reverse in snake.
		addLadder(start, end);
	}

	public int getLeastRolls() {
		int level = 0;
		int SENTINEL = -99;
		// Store the nodes for BFS traversal.
		LinkedList<Integer> queue = new LinkedList<Integer>();
		queue.add(BOARD_MIN);
		queue.add(SENTINEL);

		// Track if node has been visited.
		HashMap<Integer, Boolean> visited = new HashMap<>();
		for (int i = BOARD_MIN; i < BOARD_MAX + 1; i++) {
			visited.put(i, false);
		}
		while (!queue.isEmpty()) {
			int square = queue.remove().intValue();
			visited.put(square, true);
			if (square == BOARD_MAX) {
				return level;
			} else if (square == SENTINEL) {
				if (queue.isEmpty()) {
					return -1;
				} else {
					level++; // Completed a level in the tree
					queue.add(SENTINEL);
				}
			} else {
				// Insert all the unvisited neighbors of the
				// current square at the end of the BFS queue.
				List<Integer> neighbors = board.get(square);
				if (neighbors != null) {
					for (Integer neighbor : neighbors) {
						if (!visited.get(neighbor)) {
							queue.add(neighbor);
							visited.put(neighbor, true);
						}
					}
				}
			}
		}
		return -1;
	}

	private List<Integer> getDestinations(int n) {
		// For the given square on the board return all the
		// squares that one can get to with roll of the die
		// when there are no snakes or ladders on the board.
		List<Integer> result = new ArrayList<Integer>();
		for (int i = DICE_MIN; i < DICE_MAX + 1; i++) {
			if (n + i < BOARD_MAX + 1) {
				result.add(n + i);
			}
		}
		return result;
	}

	private List<Integer> getSources(int n) {
		// For the given square on the board return all the squares
		// from where one can get to this one with a roll of the die
		// when there are no snakes or ladders on the board.
		List<Integer> result = new ArrayList<Integer>();
		for (int i = DICE_MIN; i < DICE_MAX + 1; i++) {
			if (n - i > BOARD_MIN - 1) {
				result.add(n - i);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		int numTests = scnr.nextInt();
		for (int i = 0; i < numTests; i++) {
			SnakesLadders snld = new SnakesLadders();
			int numLadders = scnr.nextInt();
			for (int l = 0; l < numLadders; l++) {
				int start = scnr.nextInt();
				int end = scnr.nextInt();
				snld.addLadder(start, end);
			}
			int numSnakes = scnr.nextInt();
			for (int s = 0; s < numSnakes; s++) {
				int start = scnr.nextInt();
				int end = scnr.nextInt();
				snld.addSnake(start, end);
			}
			// The minimum number of die rolls needed.
			System.out.println(snld.getLeastRolls());
		}
		scnr.close();
	}

}
