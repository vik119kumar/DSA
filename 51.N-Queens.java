public class NQueens {
  /**
   * function to check if a queen can be placed on board[row][col]
   * this function is called when "col" queens are already placed 
   * in columns from 0 to col -1
   * So we need to check only left side for attacking queens
   */
  boolean isSafe(int board[][], int row, int col, int n) {
    int i, j;
    // Check this row on left side
    for (i = 0; i < col; i++) {
      if (board[row][i] == 1) {
        return false;
      }
    }

    // Check upper diagonal on left side
    for (i = row, j = col; i >= 0 && j >= 0; i--, j--) {
      if (board[i][j] == 1) {
        return false;
      }
    }

    // Check lower diagonal on left side
    for (i = row, j = col; i < n && j >= 0; i++, j--) {
      if (board[i][j] == 1) {
        return false;
      }
    }

    return true;
  }

  void solveNQUtil(List<List<String>> result, int board[][], int col, int n) {
    if (col >= n) {
      List<String> solution = printSolution(board, n);
      result.add(solution);
    }
    // Consider this column and try placing queens in all rows one by one
    for (int i = 0; i < n; i++) {
      if (isSafe(board, i, col, n)) {
        // Place this queen in board[i][col]
        board[i][col] = 1;
        // Recur to place rest of the queens
        solveNQUtil(result, board, col + 1, n);

        // If placing queen in board[i][col] doesn't lead to a solution
        // then remove queen from board[i][col]
        board[i][col] = 0; // BACKTRACK
      }
    }
  }

  List<String> printSolution(int board[][], int n) {
    List<String> result = new ArrayList<>();
    StringBuilder qPlacement = new StringBuilder();
    for (int i = 0; i < n; i++) {
      qPlacement.setLength(0);
      for (int j = 0; j < n; j++) {
        if (board[i][j] == 1) {
          qPlacement.append("Q");
        }
        else {
          qPlacement.append(".");
        }
      }
      result.add(qPlacement.toString());
    }
    return result;
  }

  public List<List<String>> solveNQueens(int n) {
    int board[][] = new int[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        board[i][j] = 0;
      }
    }
    List<List<String>> result = new ArrayList<>();
    solveNQUtil(result, board, 0, n);
    return result;
  }
}
/*
Time Complexity: O(N!)
Auxiliary Space: O(N2)
*/
