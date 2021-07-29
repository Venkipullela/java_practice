package problems;

import java.util.*;

public class TreeMapExploration {
    static TreeMap<Integer, Integer> map = new TreeMap<>();


    public static void main(String[] args){
        map.floorKey(9);


    }

    static class Input{
        Integer key;
        Integer value;

        public Integer getKey() {
            return key;
        }

        public void setKey(Integer key) {
            this.key = key;
        }

        public Integer getValue() {
            return value;
        }

        public void setValue(Integer value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Input{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }

        public Input(Integer key, Integer value) {
            this.key = key;
            this.value = value;
        }

        public boolean equals(Object o) {
            if(this == o) return true;
            if(o == null || getClass() != o.getClass()) return false;
            Input input = (Input) o;
            return this.key.equals(input.key) && this.value.equals(input.value);
        }


//        @Override
//        public boolean equals(Object o) {
//            if (this == o) return true;
//            if (o == null || getClass() != o.getClass()) return false;
//            Input input = (Input) o;
//            return Objects.equals(key, input.key) && Objects.equals(value, input.value);
//        }

        @Override
        public int hashCode() {
            return Objects.hash(key, value);
        }
    }

    public static void main1(String[] args) {
        TreeMapExploration treeMapExploration = new TreeMapExploration();
        treeMapExploration.addRange(6,8);
        treeMapExploration.removeRange(7,8);
        treeMapExploration.removeRange(8,9);
        treeMapExploration.addRange(8,9);
        treeMapExploration.removeRange(1,3);
        treeMapExploration.addRange(1,8);
        System.out.println(treeMapExploration.queryRange(2,4));
        System.out.println(treeMapExploration.queryRange(2,9));
        System.out.println(treeMapExploration.queryRange(4,6));


    }

    public TreeMapExploration() {

    }

    public void addRange(int left, int right) {
        if(map.isEmpty()) {
            map.put(left, right);
        } else {
            if(map.containsKey(left)) {
                if(map.get(left) < right){
                    map.put(left, right);
                }
            } else {
                Integer floorKey = map.floorKey(left);
                Integer ceilingKey = map.ceilingKey(left);
                if(floorKey != null && map.get(floorKey) >= left){
                    map.put(floorKey, right);
                } else if(ceilingKey != null && ceilingKey <= right && right <= map.get(ceilingKey)){
                    map.put(left, map.get(ceilingKey));
                } else if(ceilingKey != null && map.get(ceilingKey) <= right){
                    map.put(left, right);
                    map.remove(ceilingKey);
                    ceilingKey = map.ceilingKey(left);
                    if(ceilingKey != null && ceilingKey <= right) {

                    }
                } else {
                    map.put(left, right);
                }
            }
        }
    }

    public boolean queryRange(int left, int right) {
        Integer floorKey = map.floorKey(left);
        if(floorKey == null) {
            return false;
        }
        return floorKey <= left && right <= map.get(floorKey);
    }

    public void removeRange(int left, int right) {
        Integer floorKey = map.floorKey(left);
        Integer ceilingKey = map.ceilingKey(left);
        if(floorKey != null && floorKey <= left && right <= map.get(floorKey)) {
            if(right < map.get(floorKey)){
                map.put(right, map.get(floorKey));
            }
            map.put(floorKey, left);
        } else if(floorKey != null && map.get(floorKey) <= left && left < map.get(floorKey)){
            map.put(floorKey, left);
        } else if(ceilingKey != null && ceilingKey < right && map.get(ceilingKey) > right){
            map.put(right, map.get(ceilingKey));
            map.remove(ceilingKey);
        } else if(ceilingKey != null && map.get(ceilingKey) <= right) {
            map.remove(ceilingKey);
        }
    }

}
