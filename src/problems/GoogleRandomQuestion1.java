package problems;

import java.util.Arrays;
import java.util.Comparator;

public class GoogleRandomQuestion1 {

    public static void main(String[] args) {
        int[][] input = {{100,80},{60,80},{90,70},{60,70}};
        System.out.println(getPassingStudents(input));
    }

    public static int getPassingStudents(int[][] scores) {
        Arrays.sort(scores, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] == o1[1] ? o2[0]-o1[0] : o2[1] - o1[1];
            }
        });

        int maxX = scores[0][0]; int maxY = scores[0][1];
        int ans = 1;
        for (int i = 1; i < scores.length; i++) {
            if(scores[i][1] == maxY) {
                ans++;
            } else {
                if(scores[i][0] < maxX) {
                    continue;
                } else {
                    ans++;
                    maxX = scores[i][0];
                }
            }
        }

        return ans;
    }
}
