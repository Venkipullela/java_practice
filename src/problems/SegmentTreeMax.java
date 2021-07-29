package problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class SegmentTreeMax {

    static SegmentTreeNode root;

    public static void main(String[] args) {
        Random random = new Random();
        int[] a = new int[10000];
        for(int i = 0; i < 10000; i++){
            a[i] = random.nextInt(100000);
        }

        LinkedList<Integer> list = new LinkedList<>();
        int[][] lookup = new int[10000][10000];
        long t1 = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            for(int j = i; j < 10000; j++) {
                if(i == j){
                    lookup[i][j] = a[i];
                } else {
                    lookup[i][j] = Math.max(lookup[i][j-1], a[j]);
                }
            }
        }
        //System.out.println(lookup[1000][5394]);
        long t2 = System.currentTimeMillis();
        System.out.println(t2-t1);


        t1 = System.currentTimeMillis();
        root = createTree(a,0, 9999);
        t2 = System.currentTimeMillis();
        System.out.println(t2-t1);
        //System.out.println(getMax(root, 1000,5394));
    }

    static SegmentTreeNode createTree(int[] arr, int l, int h) {
        if(l == h) {
            return new SegmentTreeNode(arr[l], l, h);
        } else {
            int m = (l+h)/2;
            SegmentTreeNode left = createTree(arr, l, m);
            SegmentTreeNode right = createTree(arr, m+1, h);
            SegmentTreeNode node = new SegmentTreeNode(Math.max(left.val, right.val), l ,h);
            node.left = left;
            node.right = right;
            return node;
        }
    }

    static int getMax(SegmentTreeNode node, int l, int h) {
        if(l <= node.l && node.h <= h) {
            return node.val;
        } else if(node.l > h || node.h < l) {
            return Integer.MIN_VALUE;
        } else {
            return Math.max(getMax(node.left, l, h), getMax(node.right, l, h));
        }
    }

    static class SegmentTreeNode {
        int val;
        int l;
        int h;
        SegmentTreeNode left;
        SegmentTreeNode right;

        public SegmentTreeNode(int val, int l, int h) {
            this.val = val;
            this.l = l;
            this.h = h;
        }

        @Override
        public String toString() {
            return "SegmentTreeNode{" +
                    "val=" + val +
                    ", l=" + l +
                    ", h=" + h +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }
}
