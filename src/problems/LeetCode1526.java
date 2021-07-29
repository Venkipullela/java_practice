package problems;

public class LeetCode1526 {

    SegmentTreeNode root;

    public static void main(String[] args) {
        LeetCode1526 l = new LeetCode1526();
        l.minNumberOperations(new int[]{3,1,5,4,2,1});
    }

    public int minNumberOperations(int[] target) {
        root = createTree(target, 0, target.length-1);
        return minOps(target, 0, target.length-1, 0);
    }

    public int minOps(int[] target, int l, int h, int min) {
        if(l > h) return 0;
        if(l == h) return target[l]-min;
        int minIdx = getMin(target, root, l, h);

        return (target[minIdx]-min)+
                minOps(target, l, minIdx-1, target[minIdx])+
                minOps(target, minIdx+1, h, target[minIdx]);
    }

    SegmentTreeNode createTree(int[] arr, int l, int h) {
        if(l == h) {
            return new SegmentTreeNode(l, l, h);
        } else {
            int m = (l+h)/2;
            SegmentTreeNode left = createTree(arr, l, m);
            SegmentTreeNode right = createTree(arr, m+1, h);

            SegmentTreeNode node = new SegmentTreeNode(0, l ,h);
            node.val = arr[left.val] < arr[right.val] ? left.val : right.val;
            node.left = left;
            node.right = right;
            return node;
        }
    }

    int getMin(int[] arr,SegmentTreeNode node, int l, int h) {
        if(l <= node.l && node.h <= h) {
            return node.val;
        } else if(node.l > h || node.h < l) {
            return -1;
        } else {
            //return Math.max(getMax(node.left, l, h), getMax(node.right, l, h));
            int left = getMin(arr, node.left, l, h);
            int right = getMin(arr, node.right, l, h);
            if(left == -1) {
                return right;
            } else if(right == -1) {
                return left;
            } else {
                return arr[left] < arr[right] ? l : h;
            }
        }
    }

    class SegmentTreeNode {
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
