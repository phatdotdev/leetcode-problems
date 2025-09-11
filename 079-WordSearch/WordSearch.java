
public class WordSearch {

    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        if (m * n < word.length())
            return false;
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (board[row][col] == word.charAt(0)) {
                    if (dfs(board, word, row, col, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int row, int col, int current) {
        if (current == word.length())
            return true;
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length)
            return false;
        if (board[row][col] != word.charAt(current))
            return false;

        char temp = board[row][col];
        board[row][col] = '#';

        int[][] dirs = { { -1, 0 }, { 0, -1 }, { 0, 1 }, { 1, 0 } };
        for (int[] d : dirs) {
            if (dfs(board, word, row + d[0], col + d[1], current + 1)) {
                board[row][col] = temp;
                return true;
            }
        }

        board[row][col] = temp;
        return false;
    }
}
