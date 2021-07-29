package problems;

import java.util.*;

public class LeetCode1448 {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        Integer[] ans = new Integer[numCourses];
        for(int i = 0; i < numCourses; i++){
            ans[i] = 0;
        }
        for(int i = 0; i < prerequisites.length; i++){
            Set<Integer> currentSet = map.getOrDefault(prerequisites[i][1], new HashSet<>());
            currentSet.add(prerequisites[i][0]);
            map.put(prerequisites[i][1], currentSet);
        }

        Arrays.sort(ans, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                if(map.getOrDefault(a, new HashSet<>()).contains(b)) {
                    return -1;
                } else if(map.getOrDefault(b, new HashSet<>()).contains(a)) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });

        int[] a = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            a[i] = ans[i];
        }
        return a;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        HashMap<Character, HashSet<String>> dict = new HashMap<Character, HashSet<String>>();
        try {
            for(String l: wordDict) {
                HashSet<String> set = dict.get(l.charAt(0));
                set.add(l);
                dict.put(l.charAt(0),set);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return wordBreakSet(s, dict);
    }

    public boolean wordBreakSet(String s, HashMap<Character, HashSet<String>> wordDict) {
        if(wordDict.get(s.charAt(0)) == null) {
            return false;
        }
        if(wordDict.get(s.charAt(0)).contains(s)) {
            return true;
        }
        for(String t: wordDict.get(s.charAt(0))) {
            if(wordBreakSet(s.substring(t.length()), wordDict)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

    }

    public static int goodNodes(TreeNode root) {
        if (root.left == null && root.right == null) {
            return 1;
        }

        int ans = 1;
        Stack<TreeNode> stack = new Stack<>();
        TreeSet<TreeNode> childsKept = new TreeSet<>();
        stack.push(root);
        if(root.right != null){
            stack.push(root.right);
        }
        if(root.left != null) {
            stack.push(root.left);
        }
        childsKept.add(root);
        while(!stack.empty()) {
            TreeNode current = stack.peek();
            if(isLeaf(current) || childsKept.contains(current)) {
                stack.pop();
                if(childsKept.last().val <= current.val){
                    ans++;
                }
                if(childsKept.contains(current)){
                    childsKept.remove(current);
                }
            } else {
                if(current.right != null) {
                    stack.push(current.right);
                }
                if(current.left != null) {
                    stack.push(current.left);
                }
                childsKept.add(current);
            }
        }
        return ans;
    }

    public static boolean isLeaf(TreeNode node) {
        return (node.left == null && node.right == null);
    }

    class TreeNode {
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

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            TreeNode treeNode = (TreeNode) o;
            return val == treeNode.val && Objects.equals(left, treeNode.left) && Objects.equals(right, treeNode.right);
        }

        @Override
        public int hashCode() {
            return Objects.hash(val, left, right);
        }
    }
}
