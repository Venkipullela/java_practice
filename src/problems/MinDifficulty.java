package problems;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Objects;

public class MinDifficulty {
    public static void main(String[] args) {
        int[] input = new int[]{11,111,22,222,33,333,44,444};
        int d = 6;
        System.out.println(minDifficulty(input, d));
    }

    public static int minDifficulty(int[] jd, int d) {
        if(d > jd.length) {
            return -1;
        } else if(d == jd.length) {
            return Arrays.stream(jd).sum();
        } else {
            int n = jd.length;
            int[][] l = new int[d][n];

            int[][] maxLookup = new int[n][n];

            for(int i = 0; i < n; i++){
                for(int j = i; j < n; j++){
                    if(i==j){
                        maxLookup[i][j] = jd[i];
                    } else {
                        maxLookup[i][j] = Math.max(maxLookup[i][j-1], jd[j]);
                    }
                }
            }
            for(int i = 0; i < d; i++){
                for(int j = i; j < n; j++){
                    if(i == 0 && j == 0){
                        l[0][0] = jd[0];
                    } else {
                        if(i == 0){
                            l[0][j] = maxLookup[0][j];
                        } else {
                            int min = Integer.MAX_VALUE;
                            for(int k = 0; k < j-i+1; k++){
                                min = Math.min(min, l[i-1][j-k-1]+maxLookup[j-k][j]);
                            }
                            l[i][j] = min;
                        }
                    }
                }
            }
            return l[d-1][n-1];
        }
    }
}
