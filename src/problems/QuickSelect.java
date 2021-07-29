package problems;

public class QuickSelect {

    public static void main(String[] args) {
        int[] arr = {11,12,13,14,2,3,8};
        int p = getPivot(arr);
        System.out.println(arr[p]);
    }


    public static int getPivot(int[] arr) {
        int k = arr[arr.length-1];
        int i = 0; int j = arr.length-2;
        while (i != j) {
            if(arr[i] > k) {
                swap(arr, i, j);
                j--;
            } else {
                i++;
            }
        }

        return i;
    }

    private static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
