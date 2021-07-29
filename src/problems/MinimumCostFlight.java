package problems;

import java.util.*;

public class MinimumCostFlight {
    static Map<Integer, Set<DAW>> graph = new HashMap<>();

    public static void main(String[] args) {

        int[][] flights = {{0,1,100},{1,2,100},{0,2,500}};
        int[] a = new int[1];
        //Arrays.binarySearch(a, 0, 7, 9);

        PriorityQueue<Integer> q = new PriorityQueue<>();
        q.add(5);
        q.add(3);
        q.add(4);
        q.add(3);

        HashMap<Integer, Integer> map = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();

        System.out.println(findCheapestPrice(3, flights, 0,2,1));
    }

    public static int findCheapestPrice1(int n, int[][] flights, int src, int dst, int k) {
        for(int i = 0; i < flights.length; i++) {
            int source = flights[i][0];
            int dest = flights[i][1];
            int weight = flights[i][2];

            Set<DAW> set = graph.getOrDefault(source, new HashSet<>());
            set.add(new DAW(dest, weight));
            graph.put(source, set);
        }
        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[src] = 0;
        int[] stops = new int[n];
        Arrays.fill(stops, Integer.MAX_VALUE);
        stops[src] = 0;

        int cost = Integer.MAX_VALUE;

        Queue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(distance[o1],distance[o2]);
            }
        });
        queue.add(src);

        while(!queue.isEmpty()){
            Integer current = queue.poll();
            for(DAW d: graph.getOrDefault(current, new HashSet<>())) {
                if(distance[current] + d.weight < distance[d.dest]) {
                    distance[d.dest] = distance[current] + d.weight;
                    stops[d.dest] = stops[current] + 1;
                    if(d.dest == dst && stops[d.dest] <= k+1) {
                        cost = Math.min(cost, distance[d.dest]);
                    }
                    queue.add(d.dest);
                }
            }
        }

        return cost == Integer.MAX_VALUE ? -1 : cost;
    }

    static class DAW {
        int dest;
        int weight;

        public DAW(int dest, int weight) {
            this.dest = dest;
            this.weight = weight;
        }
    }

    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {

        // Build the adjacency matrix
        int adjMatrix[][] = new int[n][n];
        for (int[] flight: flights) {
            adjMatrix[flight[0]][flight[1]] = flight[2];
        }

        // Shortest distances array
        int[] distances = new int[n];

        // Shortest steps array
        int[] currentStops = new int[n];
        Arrays.fill(distances, Integer.MAX_VALUE);
        Arrays.fill(currentStops, Integer.MAX_VALUE);
        distances[src] = 0;
        currentStops[src] = 0;

        // The priority queue would contain (node, cost, stops)
        PriorityQueue<int[]> minHeap = new PriorityQueue<int[]>((a, b) -> a[1] - b[1]);
        minHeap.offer(new int[]{src, 0, 0});

        while (!minHeap.isEmpty()) {

            int[] info = minHeap.poll();
            int node = info[0], stops = info[2], cost = info[1];

            // If destination is reached, return the cost to get here
            if (node == dst) {
                return cost;
            }

            // If there are no more steps left, continue
            if (stops == K + 1) {
                continue;
            }

            // Examine and relax all neighboring edges if possible
            for (int nei = 0; nei < n; nei++) {
                if (adjMatrix[node][nei] > 0) {
                    int dU = cost, dV = distances[nei], wUV = adjMatrix[node][nei];

                    // Better cost?
                    if (dU + wUV < dV) {
                        minHeap.offer(new int[]{nei, dU + wUV, stops + 1});
                        distances[nei] = dU + wUV;
                    }
                    else if (stops < currentStops[nei]) {

                        // Better steps?
                        minHeap.offer(new int[]{nei, dU + wUV, stops + 1});
                        currentStops[nei] = stops;
                    }
                }
            }
        }

        return distances[dst] == Integer.MAX_VALUE? -1 : distances[dst];
    }
}



