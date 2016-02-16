import java.util.Scanner;

public class DFSBranchCount {

	char[][] matrix;
	boolean[][] traversed;
	int rows;
	int cols;

	public DFSBranchCount(char[][] matrix, int rows, int cols) {
		this.matrix = matrix;
		this.rows = rows;
		this.cols = cols;
		traversed = new boolean[rows][cols];
		for (int i = 0; i < rows; i++)
			for (int j = 0; j < cols; j++)
				traversed[i][j] = false;
	}

	public void printMatrix() {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				System.out.print(matrix[i][j]);
			}
			System.out.println();
		}
	}

	private int findBranchOptions(int row, int col) {
		int options = 0;

		if (row > 0 && matrix[row - 1][col] != 'X' && !traversed[row - 1][col])
			options++;
		if (row < rows - 1 && matrix[row + 1][col] != 'X' && !traversed[row + 1][col])
			options++;
		if (col > 0 && matrix[row][col - 1] != 'X' && !traversed[row][col - 1])
			options++;
		if (col < cols - 1 && matrix[row][col + 1] != 'X' && !traversed[row][col + 1])
			options++;

		return options;
	}

	private void traverseBranches(int currentrow, int currentcol, int endrow, int endcol, int expectedBranches,
			int currentBranches) {

		// System.out.println("Checking cell = (" + currentrow + ", " + currentcol + ")");
		traversed[currentrow][currentcol] = true;
		// This allows us to recurse on each neighbor without checking whether the destination is valid before calling.
		if (matrix[currentrow][currentcol] == 'X')
			return;

		if (currentrow == endrow && currentcol == endcol) {
			System.out.println("Expected = " + expectedBranches + ", Actual = " + currentBranches);
			if (expectedBranches == currentBranches)
				System.out.println("Impressed");
			else
				System.out.println("Oops!");
			return;
		}

		int newCurrentBranches;
		if (findBranchOptions(currentrow, currentcol) > 1)
			newCurrentBranches = currentBranches + 1;
		else
			newCurrentBranches = currentBranches;

		if (currentcol > 0 && !traversed[currentrow][currentcol - 1] && matrix[currentrow][currentcol - 1] != 'X') { // LEFT
			traverseBranches(currentrow, currentcol - 1, endrow, endcol, expectedBranches, newCurrentBranches);
		}
		if (currentcol < (cols - 1) && !traversed[currentrow][currentcol + 1] && matrix[currentrow][currentcol + 1] != 'X') { // RIGHT
			traverseBranches(currentrow, currentcol + 1, endrow, endcol, expectedBranches, newCurrentBranches);
		}
		if (currentrow > 0 && !traversed[currentrow - 1][currentcol] && matrix[currentrow - 1][currentcol] != 'X') { // UP
			traverseBranches(currentrow - 1, currentcol, endrow, endcol, expectedBranches, newCurrentBranches);
		}
		if (currentrow < (rows - 1) && !traversed[currentrow + 1][currentcol] && matrix[currentrow + 1][currentcol] != 'X') { // DOWN
			traverseBranches(currentrow + 1, currentcol, endrow, endcol, expectedBranches, newCurrentBranches);
		}

	}

	public void traverseBranches(int startrow, int startcol, int endrow, int endcol, int expectedBranches) {
		traverseBranches(startrow, startcol, endrow, endcol, expectedBranches, 0);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt(); // Number of test cases.
		for (int t = 0; t < T; t++) {
			int N = in.nextInt(); // number of rows
			int M = in.nextInt(); // Number of columns
			char[][] matrix = new char[N][M];
			int startrow = -1, startcol = -1;
			int endrow = N, endcol = M;
			for (int i = 0; i < N; i++) {
				String row = in.next();
				for (int j = 0; j < M; j++) {
					matrix[i][j] = row.charAt(j);
					if (matrix[i][j] == 'M') {
						startrow = i;
						startcol = j;
					}
					if (matrix[i][j] == '*') {
						endrow = i;
						endcol = j;
					}
				}
			}
			DFSBranchCount bc = new DFSBranchCount(matrix, N, M);
			// bc.printMatrix();
			int W = in.nextInt(); // Number of branches to test for
			bc.traverseBranches(startrow, startcol, endrow, endcol, W);
		}
	}

}
