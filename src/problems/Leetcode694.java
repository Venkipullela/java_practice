package problems;

import java.util.*;

public class Leetcode694 {
    int[][] dirs = {{1,0}, {0,1}, {-1,0}, {0,-1}};
    int n;
    int m;
    boolean[][] visited;



    public int numDistinctIslands(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        visited = new boolean[n][m];
        Set<Island> islands = new HashSet<>();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == 1 && !visited[i][j]) {
                    Island island = new Island();
                    dfs(grid, i, j, island, i, j);
                    island.lands.sort(new Comparator<Pair>() {
                        @Override
                        public int compare(Pair o1, Pair o2) {
                            return o1.r == o2.r ? o1.c-o2.c : o1.r - o2.r;
                        }
                    });
                    islands.add(island);
                }
            }
        }
        return islands.size();
    }

    public void dfs(int[][] grid, int i, int j, Island island, int r, int c) {
        visited[i][j] = true;
        island.addLand(new Pair(i-r, j-c));

        for(int[] dir: dirs) {
            int x = i + dir[0]; int y = j + dir[1];
            if(0 <= x && x < n && 0 <= y && y < m) {
                if(grid[x][y] == 1 && !visited[x][y]) {
                    dfs(grid, x, y, island, r, c);
                }
            }
        }
    }

    class Island {
        List<Pair> lands = new ArrayList<>();
        public void addLand(Pair p) {
            lands.add(p);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Island island = (Island) o;
            return Objects.equals(lands, island.lands);
        }

        @Override
        public String toString() {
            return "Island{" +
                    "lands=" + lands +
                    '}';
        }

        @Override
        public int hashCode() {
            return Objects.hash(lands);
        }
    }

    class Pair {
        int r;
        int c;
        public Pair(int r, int c) {
            this.r = r;
            this.c = c;
        }
        @Override
        public String toString() {
            return "Pair{" +
                    "r=" + r +
                    ", c=" + c +
                    '}';
        }

        @Override
        public int hashCode() {
            return Objects.hash(r, c);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return r == pair.r && c == pair.c;
        }
    }
}
