package problems;

public class IsSubPath {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }



    public boolean isSubPath(ListNode head, TreeNode root) {
        boolean ans = false;
        if(head == null) {
            return true;
        }
        if(root == null) {
            return false;
        }

        if(head.val == root.val) {
            ans = isSubPath(head.next, root.left) ||
                    isSubPath(head.next, root.right);
        }
        if(!ans) {
            ans |= isSubPath(head, root.left);
            ans |= isSubPath(head, root.right);
        }
        return ans;
    }

    public boolean isSubPath1(ListNode head, TreeNode root) {

        //Check if a downward path is found starting from the root node.
        boolean ans = check(head, root);

        //If path is not found, check in the left and right subtrees.
        if (root!=null && !ans)
        {
            ans |= isSubPath1(head, root.left);
            ans |= isSubPath1(head, root.right);
        }

        return ans;
    }

    public boolean check(ListNode head, TreeNode root){

        //If the ListNode is null, we've reached the end of the list where all values match the ones in the tree. This means we've found a path.
        if (head==null)
            return true;

        //If the TreeNode is null, but the ListNode is not, we've reached the end of the subtree but not the list, so, return False.
        if (root==null)
            return false;

        //If the value of the current node matches the next node of the list, try to find a path in the left or right subtree, otherwise return False
        if (root.val==head.val)
            return check(head.next, root.left) || check(head.next, root.right);

        return false;

    }
}
