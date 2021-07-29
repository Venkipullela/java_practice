package problems;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LongestSubstring {
    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>();
        integers.add(0);
        integers.add(1);
        integers.add(2);
        integers.add(3);

        System.out.println(lengthOfLongestSubstringWithSb("ubstringongesength"));
        System.out.println(lengthOfLongestSubstringWith2Pointers("ubstringongesength"));
    }
    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        List<Character> lastSubstring = new ArrayList<>();
        int[] a = new int[n];
        int max = 1;
        if(s.length() > 0) {
            a[0] = 1;
            lastSubstring.add(s.charAt(0));
            for(int i = 1; i < n; i++) {
                Character currentChar = s.charAt(i);
                if(!lastSubstring.contains(currentChar)){
                    a[i] = a[i-1]+1;
                    lastSubstring.add(currentChar);
                } else {
                    int lastIndex = lastSubstring.lastIndexOf(currentChar);
                    a[i] = lastSubstring.size()-lastIndex;
                    lastSubstring = lastSubstring.subList(lastIndex + 1, lastSubstring.size());
                    lastSubstring.add(currentChar);
                }
                max = Math.max(max, a[i]);
            }
        } else {
            return 0;
        }
        return max;
    }
    public static int lengthOfLongestSubstringWithSb(String s) {
        int n = s.length();
        StringBuilder lastSubstring = new StringBuilder();
        int[] a = new int[n];
        int max = 1;
        if(s.length() > 0) {
            a[0] = 1;
            lastSubstring.append(s.charAt(0));
            for(int i = 1; i < n; i++) {
                Character currentChar = s.charAt(i);
                if(!lastSubstring.toString().contains(currentChar.toString())){
                    a[i] = a[i-1]+1;
                    lastSubstring.append(currentChar);
                } else {
                    int lastIndex = lastSubstring.lastIndexOf(currentChar.toString());
                    a[i] = lastSubstring.length()-lastIndex;
                    String temp = lastSubstring.substring(lastIndex + 1, lastSubstring.length());
                    StringBuilder sb = new StringBuilder();
                    sb.append(temp).append(currentChar);
                    lastSubstring = sb;
                }
                max = Math.max(max, a[i]);
            }
        } else {
            return 0;
        }
        return max;
    }

    public static int lengthOfLongestSubstringWith2Pointers(String s) {
        int n = s.length();
        HashMap<Character, Integer> map = new HashMap<>();
        int l=0,r=0;
        int max = 0;
        while(r < n) {
            if (map.containsKey(s.charAt(r))) {
                l = Math.max(map.get(s.charAt(r)) + 1, l);
            }
            map.put(s.charAt(r), r);
            r++;
            max = Math.max(max, r-l);

        }
        return max;
    }
}
