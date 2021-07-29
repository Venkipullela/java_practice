package problems;

import java.util.ArrayList;
import java.util.List;

public class Islands {

    public static void main(String[] args){
        char[][] grid = new char[4][5];
         char[] c1 = new char[]{};

    }

    // char '0' or '1'
    public int numIslands(char[][] grid) {
        if(grid.length == 0){
            return 0;
        } else if(grid[0].length == 0){
            return 0;
        }
        int n = grid.length;
        int m = grid[0].length;
        int[][] lookup = new int[n][m];
        List<List<String>> islandGroups = new ArrayList<>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == '0'){
                    continue;
                } else {
                    if(lookup[i][j] != 0){
                        continue;
                    }
                    if(i != n-1) {
                        if(lookup[i+1][j] != 0) {
                            islandGroups.get(lookup[i+1][j]-1).add(String.format("%s_%s", i,j));
                            lookup[i][j] = lookup[i+1][j];
                            addAllConnectedLands(grid, islandGroups, lookup, i, j);
                            continue;
                        }
                    }
                    if(j != m-1 && lookup[i][j] == 0) {
                        if(lookup[i][j+1] != 0) {
                            islandGroups.get(lookup[i][j+1]-1).add(String.format("%s_%s", i,j));
                            lookup[i][j] = lookup[i][j+1];
                            addAllConnectedLands(grid, islandGroups, lookup, i, j);
                            continue;
                        }
                    }
                    List<String> newIslandGroup = new ArrayList<>();
                    newIslandGroup.add(String.format("%s_%s", i, j));
                    lookup[i][j] = islandGroups.size()+1;
                    islandGroups.add(newIslandGroup);
                    addAllConnectedLands(grid, islandGroups, lookup, i, j );
                }
            }
        }
        return islandGroups.size();
    }

    public static void addAllConnectedLands(char[][] grid, List<List<String>> islandGroups, int[][] lookup, int i, int j) {
        int n = lookup.length;
        int m = lookup[0].length;

        if(i == n-1 && j == m-1){
            return;
        } else if(i == n-1) {
            j++;
            if(grid[i][j] == '1' && lookup[i][j] == 0){
                lookup[i][j] = lookup[i][j-1];
                islandGroups.get(lookup[i][j]-1).add(String.format("%s_%s", i, j));
                addAllConnectedLands(grid, islandGroups, lookup, i, j);
            }
        } else if(j == m-1){
            i++;
            if(grid[i][j] == '1' && lookup[i][j] == 0){
                lookup[i][j] = lookup[i-1][j];
                islandGroups.get(lookup[i][j]-1).add(String.format("%s_%s", i, j));
                addAllConnectedLands(grid, islandGroups, lookup, i, j);
            }
        } else {
            if(grid[i+1][j] == '1' && lookup[i+1][j] == 0){
                lookup[i+1][j] = lookup[i][j];
                islandGroups.get(lookup[i][j]-1).add(String.format("%s_%s", i+1, j));
                addAllConnectedLands(grid, islandGroups, lookup, i+1, j);
            }
            if(grid[i][j+1] == '1' && lookup[i][j+1] == 0){
                lookup[i][j+1] = lookup[i][j];
                islandGroups.get(lookup[i][j]-1).add(String.format("%s_%s", i, j+1));
                addAllConnectedLands(grid, islandGroups, lookup, i, j+1);
            }
        }
    }

}
