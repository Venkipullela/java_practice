package problems;

public class MaximumNumber {

    public static void main(String[] args){
        int[] a = new int[]{4,2,45,1,23,13};
        System.out.println(maximum(a));
    }

    public static int maximum(int[] array) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            max = Math.min(max, array[i]);
        }
        return max;
    }

    public static int min(int a, int b) {
        if(a < b){
            return a;
        } else {
            return b;
        }
    }
}
