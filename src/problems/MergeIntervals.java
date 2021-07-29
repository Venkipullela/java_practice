package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    public static void main(String[] args){
        int[][] input = new int[][]{{2,3},{5,5},{2,2},{3,4},{3,4}};
        merge(input);
    }
    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b) -> Integer.compare(a[0],b[0]));
        List<List<Integer>> ansList = mergeWithin(intervals, 0, intervals.length-1);
        int[][] ans = new int[ansList.size()][2];
        //System.out.print("[");
        for (int i = 0; i < ansList.size(); i++) {
            ans[i][0] = ansList.get(i).get(0);
            ans[i][1] = ansList.get(i).get(1);
            //System.out.print("["+ ans[i][0] + ", " + ans[i][1] + "],");
        }
        //System.out.print("]");
        return ans;
    }

    public static List<List<Integer>> mergeWithin(int[][] intervals, int i, int j) {
        List<List<Integer>> ans = new ArrayList<>();
        if(i == j){
            List<Integer> iArray = new ArrayList<>();
            iArray.add(intervals[i][0]);
            iArray.add(intervals[i][1]);
            ans.add(iArray);
            return ans;
        }
        else if(i + 1 == j) {
            if(intervals[i][1] >= intervals[j][0]){
                List<Integer> merged = new ArrayList<>();
                merged.add(intervals[i][0]);
                if(intervals[i][1] >= intervals[j][1]) {
                    merged.add(intervals[i][1]);
                } else {
                    merged.add(intervals[j][1]);
                }
                ans.add(merged);
            } else {
                List<Integer> iArray = new ArrayList<>();
                iArray.add(intervals[i][0]);
                iArray.add(intervals[i][1]);
                List<Integer> jArray = new ArrayList<>();
                jArray.add(intervals[j][0]);
                jArray.add(intervals[j][1]);
                ans.add(iArray);
                ans.add(jArray);
            }
            return ans;
        } else {
            List<List<Integer>> iToMid = mergeWithin(intervals, i, (i+j)/2);
            List<List<Integer>> midToJ = mergeWithin(intervals, ((i+j)/2)+1, j);
            int end = iToMid.get(iToMid.size()-1).get(1);
            int k = 0;
            for (k = 0; k < midToJ.size(); k++) {
                List<Integer> current = midToJ.get(k);
                if(end < current.get(0)) {
                    break;
                }
            }
            if(k == 0){
                iToMid.addAll(midToJ);
                return iToMid;
            } else if(k == midToJ.size()) {
                if(end < midToJ.get(midToJ.size()-1).get(1)){
                    iToMid.get(iToMid.size()-1).set(1, midToJ.get(midToJ.size()-1).get(1));
                }
                return iToMid;
            } else {
                for(int p = 0; p < k-1; p++){
                    midToJ.remove(0);
                }
                int newStart = iToMid.get(iToMid.size()-1).get(0);
                int newEnd = midToJ.get(0).get(1);
                if(end > newEnd) {
                    newEnd = end;
                }
                iToMid.remove(iToMid.size()-1);
                midToJ.remove(0);
                List<Integer> merged = new ArrayList<>();
                merged.add(newStart);
                merged.add(newEnd);
                iToMid.add(merged);
                iToMid.addAll(midToJ);
                return iToMid;
            }
        }
    }

}
