package problems;

import java.util.*;

public class KLengthSubString {
    public static void main(String[] args) {

        int[] a = new int[2];
        a[0] = 10;
        a[1] =100;

        System.out.println((Arrays.stream(a).sum()));
        Integer i = 2;
        Integer j = 2;

        Map<String, Integer> map = new HashMap<>();
        Integers integers = new Integers(3,4);
        map.put(integers.toString(), 6);

        int m = map.values().stream().max(Comparator.naturalOrder()).get();

        Integers integers2 = new Integers(3,4);
        if(map.containsKey(integers2.toString())) {
            System.out.println("map contains key");
        }

    }

    static class Integers {
        int i;
        int j;
        public Integers(int i, int j){
            this.i = i;
            this.j = j;
        }

        public String toString(){
            return String.format("%s_%s",i,j);
        }
    }

    public static int numKLenSubstrNoRepeats(String S, int k) {
        if(S.length() < k){
            return 0;
        }
        HashSet<Character> cur = new HashSet<>();
        int res = 0, i = 0, j = 0;
        for(j = 0; j < k; j++){
            cur.add(S.charAt(j));
        }
        if(cur.size() == k){
            res++;
        }
        for(j = cur.size(); j < S.length(); j++){
            while(cur.contains(S.charAt(j))){
                cur.remove(S.charAt(i++));
            }
            if(cur.size() == k){
                cur.remove(S.charAt(i++));
            }
            cur.add(S.charAt(j));

            if(cur.size() == k){
                res++;
            }
        }
        return res;
    }

    public static int numKLenSubstrNoRepeats1(String S, int K) {
        HashMap<Character, Integer> map = new HashMap<>();
        boolean isUnique = true;
        int ans = 0;
        int i = 0;
        PriorityQueue<Integer> values = new PriorityQueue<>(Comparator.reverseOrder());
        for(i = 0; i < K; i++){
            if(map.containsKey(S.charAt(i))) {
                isUnique = false;
            }
            int count = map.getOrDefault(S.charAt(i), 0);
            if(count == 0) {
                values.add(1);
            } else {
                values.add(count+1);
            }
            map.put(S.charAt(i), count+1);
        }
        i = 0;

        if(isUnique){
            ans++;
        }
        int j = i+K;
        while(j < S.length()) {
            if(map.get(S.charAt(i)) == 1) {
                map.remove(S.charAt(i));
            } else {
                map.put(S.charAt(i), map.get(S.charAt(i)) - 1);
            }
            if(!map.containsKey(S.charAt(j))) {
                if((map.values().stream().mapToInt(v -> v).max().isPresent() &&
                        map.values().stream().mapToInt(v -> v).max().getAsInt() == 1) || map.values().isEmpty()){
                    ans++;
                }
                map.put(S.charAt(j), 1);
            } else {
                map.put(S.charAt(j), map.get(S.charAt(j)) + 1);
            }
            i++; j++;
        }
        return ans;
    }
}
