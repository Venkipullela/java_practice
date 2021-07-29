package problems;

import java.util.*;

public class MinimumSpanningTree {

    public static void main(String[] args) {
        long t1 = System.currentTimeMillis();
        List<Edge> edges = new ArrayList<>();
        edges.add(new Edge(0,1,5));
        edges.add(new Edge(1,3,1));
        edges.add(new Edge(0,2,2) );
        edges.add(new Edge(2,1,1));
        edges.add(new Edge(2,3,7));


        int source = 0;
        int[] distance = new int[4];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[0] = 0;

        Set<Integer> mstSet = new HashSet<>();
        Queue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(distance[o1],distance[o2]);
            }
        });
        //Queue<Integer> queue = new ArrayDeque<>();
        queue.add(source);

        while (!queue.isEmpty()){
            Integer current = queue.poll();
            System.out.println(current);
            for (Edge e: edges) {
                if (current.equals(e.start)) {
                    if (distance[e.start] + e.weight < distance[e.end]) {
                        distance[e.end] = distance[e.start] + e.weight;
                        if(!queue.contains(e.end))queue.add(e.end);
                    }
                }
            }
        }

        System.out.println(Arrays.toString(distance));
        long t2 = System.currentTimeMillis();
        System.out.println(t2-t1);
    }





    static class Edge {
        int start;
        int end;
        int weight;

        public Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }
}

