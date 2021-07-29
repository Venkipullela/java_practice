package problems;

import java.util.HashSet;
import java.util.Objects;

public class SegmentTreeMin {
    public static void main(String[] args) {
        int[] array = new int[]{30,1,40,9,5};
        int sl = getSegmentTreeLength(array.length);

        int[] segmentTree = new int[sl];
        getSegmentTreeNodeValue(segmentTree, array, 0, 0, array.length-1);
        for (int i = 0; i < segmentTree.length; i++) {
            //System.out.println(segmentTree[i]);
        }
        System.out.println(getRangeMin(segmentTree, array,0,4,0,4,0));
    }

    public static int getSegmentTreeNodeValue(int[] segmentTree, int[] array, int si, int l, int r) {
        if(l == r) {
            segmentTree[si] = l;
        } else {
            int mid = (l+r)/2;
            int left = getSegmentTreeNodeValue(segmentTree, array, 2*si+1, l, mid);
            int right = getSegmentTreeNodeValue(segmentTree, array, 2*si+2, mid+1, r);
            if(array[left] < array[right]){
                segmentTree[si] = left;
            } else {
                segmentTree[si] = right;
            }
        }
        return segmentTree[si];
    }

    public static int getSegmentTreeLength(int n) {
        int sl = (int)Math.ceil(Math.log(n) / Math.log(2));
        return (int)Math.pow(2, sl+1)-1;
    }

    public static int getRangeMin(int[] segmentTree, int[] array, int l, int r, int l1, int r1, int i) {
        if(l <= l1 && r >= r1){
            return segmentTree[i];
        }
        if(l > r1 || r < l1){
            return Integer.MAX_VALUE;
        }
        int left = getRangeMin(segmentTree, array, l, r, l1, (l1+r1)/2, 2*i+1);
        int right = getRangeMin(segmentTree, array, l, r, ((l1+r1)/2 + 1), r1, 2*i+2);
        if(left == Integer.MAX_VALUE) {
            return right;
        }
        if(right == Integer.MAX_VALUE) {
            return left;
        }

        return array[left] < array[right] ? left : right;
    }

    public static int numSplits(String s) {
        if(s.length() == 0 || s.length() == 1){
            return 0;
        }
        HashSet<Character> set = new HashSet<>();
        char[] chars = s.toCharArray();
        int[] fromBeginning = new int[s.length()];
        int[] fromEnding = new int[s.length()];
        set.add(chars[0]);
        fromBeginning[0] = 1;
        for(int i = 1; i < s.length()-1; i++){
            if(set.contains(chars[i])) {
                fromBeginning[i] = fromBeginning[i-1];
            } else {
                set.add(chars[i]);
                fromBeginning[i] = fromBeginning[i-1] + 1;
            }
        }
        set.clear();
        set.add(chars[s.length()-1]);
        fromEnding[s.length()-1] = 1;
        int ans = fromBeginning[s.length() - 2] == 1 ? 1 : 0;
        for(int i = s.length()-2; i > 0; i--){
            if(set.contains(chars[i])) {
                fromEnding[i] = fromEnding[i+1];
            } else {
                set.add(chars[i]);
                fromEnding[i] = 1 + fromEnding[i+1];
            }
            if(fromEnding[i] == fromBeginning[i-1]) {
                ans++;
            }
        }
        return ans;
    }



}
