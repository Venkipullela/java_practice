package problems;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CheckInclusion {
    public static void main(String[] args){

        System.out.println(findMaxLength(new int[]{1,1,0}));
        String s = "input world";
        System.out.println(Arrays.toString(s.split(" ")));


        Thread t = new Thread();
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static int findMaxLength(int[] nums) {
        int n = nums.length;
        int[] zeros = new int[n+1];
        int[] ones = new int[n+1];
        if(nums[0] == 0){
            zeros[1] = 1;
        } else {
            ones[1] = 1;
        }
        for(int i = 2; i < n+1; i++){
            if(nums[i-1] == 0){
                zeros[i] = zeros[i-1]+1;
                ones[i] = ones[i-1];
            } else {
                zeros[i] = zeros[i-1];
                ones[i] = ones[i-1]+1;
            }
        }

        int l = 1, h = n;
        while(l < h){
            int z = zeros[h] - zeros[l-1];
            int o = ones[h] - ones[l-1];
            if(z > o){
                if(zeros[l] < zeros[l+1]){
                    l++;
                    continue;
                } else if(zeros[h] > zeros[h-1]){
                    h--;
                    continue;
                }
            } else if(z < o) {
                if(ones[h] > ones[h-1]){
                    h--;
                    continue;
                } else if(ones[l] < ones[l+1]){
                    l++;
                    continue;
                }
            } else if(z == o){
                return z+o;
            }
            l++;
        }
        return 0;
    }

    public static String justify(String input, int maxWidth, boolean last) {
        String[] words = input.split(" ");
        StringBuffer sb = new StringBuffer();
        if(words.length == 1 || last){
            sb.append(input);
            sb.append(" ".repeat(maxWidth - input.length()));
        } else {
            int n = words.length-1;
            int totalChars = 0;
            for (String word: words) {
                totalChars += word.length();
            }
            int spaceChars = maxWidth - totalChars;
            int quotient = spaceChars / n;
            int remainder = spaceChars % n;
            for (String word: words) {
                sb.append(word);
                sb.append(" ".repeat(quotient));
                if(remainder > 0){
                    sb.append(" ");
                    remainder--;
                }
            }
        }
        return sb.toString().trim();
    }

    public static boolean checkInclusion(String s1, String s2) {
        int[] a = new int[26];
        int n = 26;
        for(int i = 0; i < s1.length(); i++){
            int idx = s1.charAt(i)-'a';
            a[idx]++;
            if(a[idx] == 1){
                n--;
            }
        }
        int i = 0, max, min;

        for(int j = 0; j < s2.length(); j++){
            int jdx = s2.charAt(j)-'a';
            a[jdx]--;
            if(a[jdx] == 0){
                n++;
            } else if(a[jdx] == -1){
                n--;
            }
            if(j >= s1.length()){
                int idx = s2.charAt(i)-'a';
                a[idx]++;
                if(a[idx] == 0){
                    n++;
                } else if(a[idx] == 1){
                    n--;
                }
                i++;
            }
            if(n == 26){
                return true;
            }
        }
        return false;
    }
}
