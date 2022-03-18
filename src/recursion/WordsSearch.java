package recursion;

/**
 * @author zhangjie
 */
public class WordsSearch {


  public boolean exist(char[][] board, String word) {
    int rows = board.length;
    int colums = board[0].length;

    boolean[][] visited = new boolean[rows][colums];

    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < colums; j++) {
        if (dfs(board, word, visited, i, j, 0)) {
          return true;
        }
      }
    }
    return false;
  }

  private boolean dfs(char[][] board, String word, boolean[][] visited, int i, int j, int index) {
    if (board[i][j] != word.charAt(index)) {
      return false;
    }

    if (index == word.length() - 1) {
      return true;
    }

    int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    boolean result = false;
    visited[i][j] = true;
    for (int k = 0; k < directions.length; k++) {
      int newI = i + directions[k][0];
      int newJ = j + directions[k][1];
      if (newI >= 0 && newI <= board.length - 1 && newJ >= 0 && newJ <= board[0].length - 1) {
        if(visited[newI][newJ]){
          continue;
        }
        if (dfs(board, word, visited, newI, newJ, index + 1)) {
          result = true;
          break;
        }
      }
    }
    visited[i][j] = false;

    return result;
  }
}
