package problems;

public class SegmentTreeRange {
    public static void main(String[] args) {
        int[] array = new int[]{3,1,4,8,6};
        int sl = getSegmentTreeLength(array.length);

        int[] segmentTree = new int[sl];
        getSegmentTreeNodeValue(segmentTree, array, 0, 0, array.length-1);
        System.out.println(getRangeSum(segmentTree, 1,3,0,4,0));
    }

    public static int getSegmentTreeNodeValue(int[] segmentTree, int[] array, int si, int l, int r) {
        if(l == r) {
            segmentTree[si] = array[l];
        } else {
            int mid = (l+r)/2;
            segmentTree[si] = getSegmentTreeNodeValue(segmentTree, array, 2*si+1, l, mid) + getSegmentTreeNodeValue(segmentTree, array, 2*si+2, mid+1, r);
        }
        return segmentTree[si];
    }

    public static int getSegmentTreeLength(int n) {
        int sl = ((Double)Math.ceil(Math.log(n) / Math.log(2))).intValue();
        return (int)Math.pow(2, sl+1)-1;
    }

    public static int getRangeSum(int[] segmentTree, int l, int r, int l1, int r1, int i) {
        if(l <= l1 && r >= r1){
            return segmentTree[i];
        }
        if(l > r1 || r < l1){
            return 0;
        }
        return getRangeSum(segmentTree, l, r, l1, (l1+r1)/2, 2*i+1) + getRangeSum(segmentTree, l, r, ((l1+r1)/2 + 1), r1, 2*i+2);
    }

}
