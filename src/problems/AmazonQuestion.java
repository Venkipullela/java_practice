package problems;

public class AmazonQuestion {
    int n;
    int m;
    int[][] longestPathMatrix;
    int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};


    public static void main(String[] args) {
        AmazonQuestion amazonQuestion = new AmazonQuestion();

        int[][] grid = {{3,2,6},{8,1,9},{8,4,13}};
        System.out.println(amazonQuestion.getLongestPath(grid));
    }

    public int getLongestPath(int[][] grid) {
        n = grid.length;
        m = grid[0].length;

        longestPathMatrix = new int[n][m];
        int result = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(longestPathMatrix[i][j] == 0) {
                    dfs(grid, i, j);
                }
                result = Math.max(result, longestPathMatrix[i][j]);
            }
        }

        return result;
    }

    public void dfs(int[][] grid, int i, int j) {
        for(int[] dir: directions) {
            int x = i + dir[0]; int y = j + dir[1];
            if(0 <= x && x < n && 0 <= y && y < m) {
                if(grid[i][j] < grid[x][y]) {
                    if(longestPathMatrix[x][y] == 0) {
                        dfs(grid, x, y);
                    }
                    longestPathMatrix[i][j] = Math.max(longestPathMatrix[i][j], 1 + longestPathMatrix[x][y]);
                }
            }
        }
        longestPathMatrix[i][j] = Math.max(1, longestPathMatrix[i][j]);
    }
}
