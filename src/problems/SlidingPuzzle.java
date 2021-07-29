package problems;

import java.util.*;

public class SlidingPuzzle {
    public static void main(String[] args) {

        int[][] b = new int[2][3];
        int[] a = new int[]{1,2,3};
        int[] c = new int[]{5,4,0};
        b[0] = a;
        b[1] = c;
        System.out.println(slidingPuzzle(b));
    }

    public static int slidingPuzzle(int[][] b) {
        String start = "123450";
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(b[0][0]).append(b[0][1]).append(b[0][2])
        .append(b[1][0]).append(b[1][1]).append(b[1][2]);

        String end = stringBuffer.toString();
        HashSet<String> hashSet = new HashSet<>();

        Queue<String> queue = new LinkedList<>();
        queue.add(start);
        queue.add(null);
        hashSet.add(start);
        int level = 0;
        while(!queue.isEmpty()) {
            String current = queue.poll();
            if(current == null){
                if(!queue.isEmpty()){
                    level++;
                    queue.add(null);
                }
            } else {
                if(end.equals(current)){
                    return level;
                } else{
                    for (String s: getPossibleStrings(current)) {
                        if(!hashSet.contains(s)){
                            hashSet.add(s);
                            queue.add(s);
                        }
                    }
                }
            }
        }
        return -1;
    }

    public static List<String> getPossibleStrings(String s) {
        HashMap<Integer, List<Integer>> zeroChangeAbles = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        zeroChangeAbles.put(0,list);

        list = new ArrayList<>();
        list.add(0);
        list.add(2);
        list.add(4);
        zeroChangeAbles.put(1,list);

        list = new ArrayList<>();
        list.add(1);
        list.add(5);
        zeroChangeAbles.put(2,list);

        list = new ArrayList<>();
        list.add(0);
        list.add(4);
        zeroChangeAbles.put(3,list);

        list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(5);
        zeroChangeAbles.put(4,list);

        list = new ArrayList<>();
        list.add(2);
        list.add(4);
        zeroChangeAbles.put(5,list);

        int zeroIndex = s.indexOf('0');
        List<Integer> list1 = zeroChangeAbles.get(zeroIndex);
        List<String> ans = new ArrayList<>();
        for(Integer i: list1){
            StringBuffer sb = new StringBuffer(s);
            sb.setCharAt(zeroIndex, s.charAt(i));
            sb.setCharAt(i,'0');
            ans.add(sb.toString());
        }
        return ans;
    }
}
