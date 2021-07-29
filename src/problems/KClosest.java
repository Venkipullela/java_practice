package problems;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class KClosest {

    public int[][] kClosest(int[][] points, int k) {

        PriorityQueue<PointAndDistance> pointAndDistances = new PriorityQueue<>(new Comparator<PointAndDistance>() {
            @Override
            public int compare(PointAndDistance o1, PointAndDistance o2) {
                return o1.distance.compareTo(o2.distance);
            }
        });
        HashMap<Point, Double> map = new HashMap<>();
        for (int[] point: points) {

            Point point1 = new Point(point[0], point[1]);
            Double distance = Math.sqrt((point[0])*(point[0]) + (point[1])*(point[1]));
            map.put(point1, distance);

            PointAndDistance pointAndDistance = new PointAndDistance(point1, distance);
            pointAndDistances.add(pointAndDistance);
        }

        int[][] ans = new int[k][2];
        while (k > 0) {
            Point point = pointAndDistances.poll().point;
            ans[k-1][0] = point.x;
            ans[k-1][1] = point.y;
            k--;
        }
        return ans;
    }

    static class PointAndDistance {
        Point point;
        Double distance;
        public PointAndDistance(Point point, Double distance) {
            this.point = point;
            this.distance = distance;
        }
    }

    static class Point {
        int x;
        int y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
