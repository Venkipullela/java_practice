package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ModuloSum {

    public static void main(String[] args) {
        System.out.println(abc());

    }

    public static int maxModulo(int[] arr, int m) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] %= m;
        }
        Arrays.sort(arr);
        List<Integer> list = new ArrayList<>();
        list.add(arr[0]);
        int ans = arr[0];
        for(int i = 1; i < arr.length; i++) {
            List<Integer> newList = new ArrayList<>();
            newList.add(arr[i]);
            ans = Math.max(ans, arr[i]);
            if(ans == m-1){
                return ans;
            }
            for (Integer in: list) {
                ans = Math.max(ans, (arr[i]+in)%m);
                if(ans == m-1){
                    return ans;
                }
                newList.add(arr[i]+in);
            }
            list.addAll(newList);
        }
        return ans;
    }

    public static int abc() {
        try {
            return 3;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return 4;
        }
    }
}
