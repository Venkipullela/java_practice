package problems;

import java.util.*;

public class GrabQuestion {
    public static void main(String[] args){

    }

    public static int findLongestSubArray(int[] a) {
        if(a.length == 0) {
            return 0;
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<Integer> value = new ArrayList<>();

        value.add(0);
        map.put(a[0], value);
        List<Integer> value1 = new ArrayList<>();
        value1.add(-1);
        map.put(0, value1);

        int maxLength = 0;
        for(int i = 1; i < a.length; i++){
            a[i] += a[i-1];
            if(map.containsKey(a[i])){
                //map.get(a[i]).set(map.get(a[i]).size()-1, i);
                if(map.get(a[i]).size() == 2){
                    map.get(a[i]).set(map.get(a[i]).size()-1, i);
                } else {
                    map.get(a[i]).add(i);
                }
                maxLength = Math.max(maxLength, i - (map.get(a[i]).get(0)));
            } else {
                List<Integer> newValue = new ArrayList<>();
                newValue.add(i);
                map.put(a[i],newValue);
            }
        }
        return maxLength;
    }
}
