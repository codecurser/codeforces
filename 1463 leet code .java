class Solution {

    int[][][] dp;
    int n, m;

    public int cherryPickup(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        dp = new int[n][m][m];


        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                for (int k = 0; k < m; k++)
                    dp[i][j][k] = -1;

        return helper(0, 0, m - 1, grid);
    }

    int helper(int row, int col1, int col2, int[][] grid) {

    
        if (col1 < 0 || col2 < 0 || col1 >= m || col2 >= m)
            return -1000000;

  
        if (row == n - 1) {
            if (col1 == col2)
                return grid[row][col1];
            else
                return grid[row][col1] + grid[row][col2];
        }

        if (dp[row][col1][col2] != -1)
            return dp[row][col1][col2];

        int cherries;
        if (col1 == col2)
            cherries = grid[row][col1];
        else
            cherries = grid[row][col1] + grid[row][col2];

        int max = 0;

        for (int d1 = -1; d1 <= 1; d1++) {
            for (int d2 = -1; d2 <= 1; d2++) {
                max = Math.max(
                        max,
                        helper(row + 1, col1 + d1, col2 + d2, grid)
                );
            }
        }

        return dp[row][col1][col2] = cherries + max;
    }
}
