package problems;

import java.util.*;

public class HashPractice {

    public static void main(String[] args) {
        Pair p1 = new Pair(0,0);
        Pair p2 = new Pair(1,1);
        Pair p3 = new Pair(0,1);
        Pair p4 = new Pair(1,0);

        Pair p11 = new Pair(0,0);
        Pair p22 = new Pair(1,1);
        Pair p33 = new Pair(0,1);
        Pair p44 = new Pair(1,0);


        Island island1 = new Island();
        island1.addLand(p1); island1.addLand(p2); island1.addLand(p3); island1.addLand(p4);

        Island island2 = new Island();
        island2.addLand(p33); island2.addLand(p44); island2.addLand(p22); island2.addLand(p11);
        island2.lands.sort(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.x == o2.x ? o1.y-o2.y : o1.x - o2.x;
            }
        });
        island1.lands.sort(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.x == o2.x ? o1.y-o2.y : o1.x - o2.x;
            }
        });

        Set<Island> islandSet = new HashSet<>();
        System.out.println(island1.hashCode());
        System.out.println(island2.hashCode());
        islandSet.add(island1);
        islandSet.add(island2);

        System.out.println(islandSet.size());
        System.out.println(Objects.equals(island1, island2));
    }

    static class Island {
        List<Pair> lands = new ArrayList<>();
        public void addLand(Pair p) {
            lands.add(p);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Island island = (Island) o;
            return Objects.equals(lands, island.lands);
        }

        @Override
        public int hashCode() {
            return Objects.hash(lands);
        }

//        @Override
//        public String toString() {
//            return "Island{" +
//                    "lands=" + lands +
//                    '}';
//        }
    }

    static class Pair {
        int x;
        int y;

//        @Override
//        public String toString() {
//            return "Pair{" +
//                    "x=" + x +
//                    ", y=" + y +
//                    '}';
//        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return x == pair.x && y == pair.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
