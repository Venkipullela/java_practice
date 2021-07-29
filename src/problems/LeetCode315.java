package problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class LeetCode315 {

    public static void main(String[] args) {
        String a = "hello";
        a.indexOf('e');
    }

    public static List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int[] indices = new int[n]; // record the index. we are going to sort this array
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }
        // sort indices with their corresponding values in nums, i.e., nums[indices[i]]
        mergeSort(indices, 0, n, result, nums);
        // change int[] to List to return
        List<Integer> resultToReturn = new ArrayList<Integer>(n);
        for (int i : result) {
            resultToReturn.add(i);
        }
        return resultToReturn;
    }

    private static void mergeSort(int[] indices, int left, int right, int[] result, int[] nums) {
        if (right - left <= 1) {
            return;
        }
        int mid = (left + right) / 2;
        mergeSort(indices, left, mid, result, nums);
        mergeSort(indices, mid, right, result, nums);
        merge(indices, left, right, mid, result, nums);
    }

    private static void merge(int[] indices, int left, int right, int mid, int[] result, int[] nums) {
        // merge [left, mid) and [mid, right)
        int i = left; // current index for the left array
        int j = mid; // current index for the right array
        // use temp to temporarily store sorted array
        List<Integer> temp = new ArrayList<Integer>(right - left);
        while (i < mid && j < right) {
            if (nums[indices[i]] <= nums[indices[j]]) {
                // j - mid numbers jump to the left side of indices[i]
                result[indices[i]] += j - mid;
                temp.add(indices[i]);
                i++;
            } else {
                temp.add(indices[j]);
                j++;
            }
        }
        // when one of the subarrays is empty
        while (i < mid) {
            // j - mid numbers jump to the left side of indices[i]
            result[indices[i]] += j - mid;
            temp.add(indices[i]);
            i++;
        }
        while (j < right) {
            temp.add(indices[j]);
            j++;
        }
        // restore from temp
        for (int k = left; k < right; k++) {
            indices[k] = temp.get(k - left);
        }
    }

    public static List<Integer> countSmaller1(int[] nums) {
        List<Integer> sortedArray = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();
        ans.add(0);
        sortedArray.add(nums[nums.length-1]);
        for(int i = nums.length - 2; i > -1; i--){
            int index = getBinarySearchIndex(sortedArray, nums[i]);
            ans.add(index);
            sortedArray.add(index, nums[i]);
        }
        Collections.reverse(ans);
        return ans;
    }

    public static int getBinarySearchIndex(List<Integer> sortedArray, int key){
        int index = Collections.binarySearch(sortedArray, key);
        if(index < 0) {
            return -1*index -1;
        } else {
            while (index > -1) {
                if (sortedArray.get(index) == key) {
                    index--;
                }
            }
            return index + 1;
        }
    }
}
