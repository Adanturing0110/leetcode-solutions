class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;

        // Pruning: if the board lacks enough of any letter, fail fast
        int[] freq = new int[128];
        for (char[] row : board)
            for (char c : row) freq[c]++;
        for (char c : word.toCharArray())
            if (--freq[c] < 0) return false;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, word, i, j, 0)) return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int i, int j, int idx) {
        if (idx == word.length()) return true;   // all characters matched

        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length
                || board[i][j] != word.charAt(idx)) {
            return false;                        // out of bounds, visited ('#'), or mismatch
        }

        char temp = board[i][j];
        board[i][j] = '#';                       // mark visited

        boolean found = dfs(board, word, i + 1, j, idx + 1)
                     || dfs(board, word, i - 1, j, idx + 1)
                     || dfs(board, word, i, j + 1, idx + 1)
                     || dfs(board, word, i, j - 1, idx + 1);

        board[i][j] = temp;                      // backtrack: restore the cell
        return found;
    }
}