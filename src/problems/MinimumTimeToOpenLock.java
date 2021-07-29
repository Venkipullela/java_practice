package problems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class MinimumTimeToOpenLock {

    public static void main(String[] args) {
        System.out.println(minimumTimeToOpenLock("123", "318", null));
    }

    public static int minimumTimeToOpenLock(String start, String end, String[] deadlocks) {
        HashSet<String> deadLockSet = new HashSet<>(Arrays.asList(deadlocks));

        int size = start.length();
        int[][] minAndMax = new int[size][3];

        for(int i = 0; i < start.length(); i++) {
            int currentDifference = Math.abs(Integer.parseInt(String.valueOf(start.charAt(i)))
                    - Integer.parseInt(String.valueOf(end.charAt(i))));
            if (currentDifference < 10 - currentDifference) {
                minAndMax[i][0] = currentDifference;
                minAndMax[i][1] = 10 - currentDifference;
                minAndMax[i][2] = 0;
            } else {
                minAndMax[i][0] = 10 - currentDifference;
                minAndMax[i][1] = currentDifference;
                minAndMax[i][2] = 1;
            }
        }
        return 0;
    }

    public static KTree createTree(String start, String end, HashSet<String> deadlocks) {

        KTree kTree = new KTree();
        KTree head = kTree;
        kTree.val = start;
        boolean condition = true;
        for(int i = 0; i < start.length(); i++){
            String temp = new String(start);
            String newChar = Integer.toString(Integer.parseInt(String.valueOf(start.charAt(i)))+1);
            temp = temp.substring(0, i) + newChar + temp.substring(i+1);
            if(deadlocks.contains(temp)) {
                kTree.pointers.add(null);
            } else {
                KTree kTree1 = new KTree();
                kTree1.val = temp;
                kTree.pointers.add(kTree1);
            }
        }
        return null;
    }


    static class KTree {
        String val;
        List<KTree> pointers;
    }


}
