package learn.ashish.algorithms.array;

public class WordSearchInGrid {

    /**
     * board = {
     * {'A', 'B', 'C', 'E'},
     * {'S', 'F', 'C', 'S'},
     * {'A', 'D', 'E', 'E'}},
     * <p>
     * word = "SEE"
     * <p>
     * Given an m x n grid of characters board and a string word, return true if word exists in the grid.
     * <p>
     * The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally
     * or vertically neighboring. The same letter cell may not be used more than once.
     */
    public static void main(String[] args) {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}};
        String word = "SEE";

        System.out.println(new WordSearchInGrid().exist(board, word));
    }

    public boolean exist(char[][] board, String word) {
        if (word == null || word.length() == 0)
            return true;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0))
                    if (dfs(board, word, i, j, 0))
                        return true;
            }
        }

        return false;
    }


    public boolean dfs(char[][] board, String word, int i, int j, int count) {
        if (count == word.length())
            return true;

        if (i < 0 || i >= board.length || j < 0 || j >= board[i].length || board[i][j] != word.charAt(count))
            return false;

        char temp = board[i][j];
        board[i][j] = ' '; // remove char for backtracking

        boolean found =
                dfs(board, word, i, j - 1, count + 1)
                        || dfs(board, word, i, j + 1, count + 1)
                        || dfs(board, word, i - 1, j, count + 1)
                        || dfs(board, word, i + 1, j, count + 1);

        board[i][j] = temp;

        return found;
    }
}
