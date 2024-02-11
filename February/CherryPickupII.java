// Cherry Pickup II

public class CherryPickupII {

    // this is a 3d dp problem. The first dimension is the row, second is the column of
    // one of the robots and third is the column of another robot. Top down approach
    // is much easier in this case.
    public static int cherryPickup(int[][] grid) {

        int n = grid.length, m = grid[0].length;

        Integer[][][] dp = new Integer[n][m][m];
        return dfs(grid, n, m, 0, 0, m - 1, dp);
    }

    public static int dfs(int[][] grid, int n, int m, int row, int col1, int col2, Integer[][][] dp) {

        // base case
        if (row < 0 || row >= n || col1 < 0 || col1 >= m || col2 < 0 || col2 >= m) {
            return 0;
        }

        // return if dp table is populated for current values
        if (dp[row][col1][col2] != null) {
            return dp[row][col1][col2];
        }

        // now iterate through all the possible cherries available in the next row and add them
        // to find the maximum possible cherries collected in the below row by the robots
        int maxCherries = 0;
        for (int i = -1; i <= 1; i++) {
            int newCol1 = col1 + i;
            for (int j = -1; j <= 1; j++) {
                int newCol2 = col2 + j;
                maxCherries = Math.max(maxCherries, dfs(grid, n, m, row + 1, newCol1, newCol2, dp));
            }
        }

        // then we add the current cherry to that count
        int currentCherry = 0;
        if (col1 == col2) {
            currentCherry = grid[row][col1];
        } else {
            currentCherry = grid[row][col1] + grid[row][col2];
        }

        // and put that value in the dp table and return
        return dp[row][col1][col2] = maxCherries + currentCherry;
    }

    public static void main(String[] args) {
        int[][] grid = { { 3, 1, 1 }, { 2, 5, 1 }, { 1, 5, 5 }, { 2, 1, 1 } };
        System.out.println("Cherry Pickup II: " + cherryPickup(grid));
    }
}
