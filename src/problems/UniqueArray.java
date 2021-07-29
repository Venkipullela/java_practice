package problems;

import java.util.*;

public class UniqueArray {
    public static void main(String[] args) {
        List<Pair> list = new ArrayList<>();
        Collections.sort(list, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return 0;
            }
        });

    }
    class Pair {
        int r;
        int val;
        public Pair(int r, int val) {
            this.r = r;
            this.val = val;
        }
    }

    public static int minIncrementForUnique(int[] nums) {
        if(nums.length < 2){
            return 0;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int k = nums[i];
            if(map.getOrDefault(k, 0) > 1){
                k++;
                while(map.getOrDefault(k, 0) > 0){
                    k++;
                }
            }
            count += (k-nums[i]);
            if(k-nums[i] != 0){
                map.put(k,1);
                if(map.get(nums[i]) > 1){
                    map.put(nums[i], map.get(nums[i])-1);
                } else if(map.get(nums[i]) == 1){
                    map.remove(nums[i]);
                }
            }
            nums[i] = k;
        }
        return count;
    }
}
