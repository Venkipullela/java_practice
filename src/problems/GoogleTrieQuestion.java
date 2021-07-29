package problems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class GoogleTrieQuestion {

    public static void main(String[] args) {
        String s = "3141592653589793238462643383279";
        String[] ar = new String[]{"314", "314159", "159" ,"3141592653589793238462643383279", "9001", "15926535897932", "3846", "4", "338", "2643383279"};
        List<String> strings = Arrays.asList(ar);
        System.out.println(getMinSpaces(s, strings));
    }

    public static int getMinSpaces(String s, List<String> dict) {

        // Input dictionary converted hashset for faster search
        HashSet<String> dictSet = new HashSet<>(dict);

        if(dictSet.contains(s)) return 0;

        int n = s.length();

        // dp[i] would tell us the minimum number of spaces required to split input substring that starts at 0 and ends at i
        int[] dp = new int[n]; // [INF,0,0,INF,INF,1]

        dp[0] = dictSet.contains(s.substring(0,1)) ? 0 : Integer.MAX_VALUE;

        for(int i = 1; i < n; i++){ // i = 5
            if(dictSet.contains(s.substring(0,i+1))) {
                dp[i] = 0;
                continue;
            }

            int min = Integer.MAX_VALUE;
            for(int j = i-1; j >= 0; j--) { // i = 5 j = -1
                if(dictSet.contains(s.substring(j+1,i+1))) {
                    if(dp[j] != Integer.MAX_VALUE) {
                        min = Math.min(min, dp[j]);
                    }
                }
            }
            dp[i] = min == Integer.MAX_VALUE ? min : min + 1;
        }

        return dp[n-1]; // 1
    }
}
