package problems;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class CharacterReplacement {
    public static void main(String[] args){
        int[] a = new int[4];
        a[0] = 5; a[1] = 2; a[2] = 6; a[3] = 1;
        int i = -2147483648;
        //int i = -50;
        System.out.println(i*(-1));
    }

    public synchronized static int characterReplacement(String s, int k) {
        int n = s.length();
        if(k == n || k+1 == n){
            return n;
        }
        int i = 0; int j = 0; int max = k+1;
        HashMap<Character, Integer> map = new HashMap<>();

        while(j < n){
            map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
            if(j-i > k){
                int currentMax = map.values().stream().max(Comparator.naturalOrder()).get();
                if(currentMax + k >= (j-i) + 1){
                    max = Math.max(max, (j-i) + 1);
                    j++;
                } else {
                    if(map.get(s.charAt(i)) == 1){
                        map.remove(s.charAt(i));
                    } else {
                        map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
                    }
                    if(map.get(s.charAt(j)) == 1){
                        map.remove(s.charAt(j));
                    } else {
                        map.put(s.charAt(j), map.get(s.charAt(j)) - 1);
                    }
                    i++;
                }
            } else {
                j++;
            }

        }

        return max;
    }
    public static int characterReplacementWithArray(String s, int k) {
        int n = s.length();
        if(k == n || k+1 == n){
            return n;
        }
        int i = 0; int j = 0; int max = k+1;
        int[] map = new int[26];

        int currentMax = 1;
        while(j < n){
            currentMax = Math.max(currentMax, ++map[s.charAt(j)-'A']);

            while(currentMax + k < (j-i) + 1){
                map[s.charAt(i)-'A']--;
                i++;
            }
            max = Math.max(max, (j-i) + 1);
            j++;
        }
        return max;
    }
}
