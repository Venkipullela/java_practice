package problems;

import java.util.HashMap;

public class minWindow {
    public static void main(String[] args) {
        System.out.println(characterReplacement("BCDAB",2));
    }

    public static int characterReplacement(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        int i = 0, j = 0;
        int max = 0;
        while(j < s.length()) {
            int count = map.getOrDefault(s.charAt(j), 0);
            map.put(s.charAt(j), count + 1);
            j++;
        }
        return max;
    }

    public static String minWindow(String s, String t) {
        if(s.length() < t.length()) {
            return "";
        } else if(s.equals(t)){
            return s;
        }
        int missing = t.length();
        HashMap<Character, Integer> map = new HashMap<>();
        HashMap<Character, Integer> tMap = new HashMap<>();

        for (Integer in: map.values()         ) {

        }
        for (int i = 0; i < t.length(); i++) {
            if(tMap.containsKey(t.charAt(i))){
                tMap.put(t.charAt(i), tMap.get(t.charAt(i)) + 1);
            } else {
                tMap.put(t.charAt(i), 1);
            }
        }
        int[] indices = new int[2];
        int small = Integer.MAX_VALUE;
        int i = 0;
        for(int j = 0; j < s.length(); j++) {
            char currentChar = s.charAt(j);
            if(t.contains(String.valueOf(currentChar))) {
                if(map.containsKey(currentChar)) {
                    if(map.get(currentChar) < tMap.get(currentChar)){
                        missing--;
                    }
                    map.put(currentChar, map.get(currentChar) + 1);
                } else {
                    missing--;
                    map.put(currentChar, 1);
                }
                while (missing == 0) {
                    if((j-i) < small){
                        indices[0] = i;
                        indices[1] = j;
                        small = (j-i);
                    }
                    char currentSmallChar = s.charAt(i);
                    if(t.contains(String.valueOf(currentSmallChar))){
                        if(map.get(currentSmallChar) == 1){
                            map.remove(currentSmallChar);
                            missing++;
                        } else {
                            map.put(currentSmallChar, map.get(currentSmallChar) - 1);
                        }
                    }
                    i++;
                }
            }
        }
        if(small == Integer.MAX_VALUE) {
            return "";
        }
        return s.substring(indices[0], indices[1]+1);
    }
}
