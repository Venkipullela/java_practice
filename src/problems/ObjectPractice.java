package problems;

import java.util.*;

public class ObjectPractice {
    public static void main(String[] args) {
        int[][] m = new int[1][1];
    }

    public static int longestIncreasingPath(int[][] matrix) {
        Map<Node, List<Node>> graph = new TreeMap<>(new Comparator<Node>() {
            public int compare(Node a, Node b) {
                return Integer.compare(a.val, b.val);
            }
        });
        int n = matrix.length;
        int m = matrix[0].length;

        Node[][] nodes = new Node[n][m];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                nodes[i][j] = new Node(matrix[i][j]);
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                List<Node> list = graph.getOrDefault(nodes[i][j], new ArrayList<>());
                if(i == 0) {
                    list.add(nodes[i+1][j]);
                } else if(i == n-1) {
                    list.add(nodes[i-1][j]);
                } else {
                    list.add(nodes[i-1][j]);
                    list.add(nodes[i+1][j]);
                }
                if(j != 0) {
                    list.add(nodes[i][j-1]);
                }
                if(j != m-1) {
                    list.add(nodes[i][j+1]);
                }
                graph.put(nodes[i][j], list);
            }
        }

        Set<Node> computedSet = new HashSet<>();
        int lip = 0;

        for(Node key: graph.keySet()) {
            if(!computedSet.contains(key)){
                lip = Math.max(lip, dfs(graph, computedSet, key));
            }
        }

        return lip;
    }

    public static int dfs(Map<Node, List<Node>> graph, Set<Node> computedSet, Node key) {
        computedSet.add(key);

        int lip = 0;
        int currentMax = 0;
        for(Node value: graph.getOrDefault(key, new ArrayList<>())) {
            if(computedSet.contains(value)) {
                continue;
            }
            if(key.val < value.val) {
                currentMax = Math.max(currentMax, dfs(graph, computedSet, value));
            }
        }
        lip = Math.max(lip, currentMax + 1);
        return lip;
    }

    static class Node {
        int val;
        public Node(int val){
            this.val = val;
        }

        @Override
        public String toString() {
            return val+"";
        }
    }
}
