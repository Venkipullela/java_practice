package problems;

import java.util.*;

//public class problems.LRUCache {
//
//
//    static LinkedHashMap<Integer, Integer> linkedHashMap = new LinkedHashMap<>();
//
//    Map<Integer, Integer> map = new HashMap<>();
//
//    Map<Integer, Long> timeStampMap = new HashMap<>();
//    TreeMap<Long, Integer> reverseTimeStampMap = new TreeMap<>();
//
//    int capacity = 0;
//
//    public static void main(String[] args) {
//
////        problems.LRUCache lRUCache = new problems.LRUCache(2);
////        lRUCache.put(1, 1); // cache is {1=1}
////        lRUCache.put(2, 2); // cache is {1=1, 2=2}
////        System.out.println(lRUCache.get(1));    // return 1
////        lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
////        System.out.println(lRUCache.get(2));    // returns -1 (not found)
////        lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
////        System.out.println(lRUCache.get(1));    // return -1 (not found)
////        System.out.println(lRUCache.get(3));    // return 3
////        System.out.println(lRUCache.get(4));    // return 4
//    }
//
//    public problems.LRUCache(int capacity) {
//        this.capacity = capacity;
//    }
//
//    public int get(int key) {
//        if(map.containsKey(key)) {
//            long currentTimeStamp = System.nanoTime();
//            long previousTimeStamp = timeStampMap.get(key);
//            timeStampMap.put(key, currentTimeStamp);
//            reverseTimeStampMap.remove(previousTimeStamp);
//            reverseTimeStampMap.put(currentTimeStamp, key);
//            return map.get(key);
//        } else {
//            return -1;
//        }
//    }
//
//    public void put(int key, int value) {
//
//        if(map.containsKey(key)) {
//            long currentTimeStamp = System.nanoTime();
//            long previousTimeStamp = timeStampMap.get(key);
//            timeStampMap.put(key, currentTimeStamp);
//            reverseTimeStampMap.remove(previousTimeStamp);
//            reverseTimeStampMap.put(currentTimeStamp, key);
//            map.put(key, value);
//        } else {
//            if(map.size() < this.capacity){
//                map.put(key, value);
//                long currentTimeStamp = System.nanoTime();
//                timeStampMap.put(key, currentTimeStamp);
//                reverseTimeStampMap.put(currentTimeStamp, key);
//            } else {
//                Map.Entry<Long, Integer> entry = reverseTimeStampMap.firstEntry();
//                timeStampMap.remove(entry.getValue());
//                reverseTimeStampMap.remove(entry.getKey());
//                map.remove(entry.getValue());
//
//                map.put(key, value);
//                long currentTimeStamp = System.nanoTime();
//                timeStampMap.put(key, currentTimeStamp);
//                reverseTimeStampMap.put(currentTimeStamp, key);
//            }
//        }
//    }
//}

public class LRUCache extends LinkedHashMap<Integer, Integer>{
    private int capacity;

    public static void main(String[] args) {

        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // cache is {1=1}
        lRUCache.put(2, 2); // cache is {1=1, 2=2}
        System.out.println(lRUCache.get(1));    // return 1
        lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        System.out.println(lRUCache.get(2));    // returns -1 (not found)
        lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
        System.out.println(lRUCache.get(1));    // return -1 (not found)
        System.out.println(lRUCache.get(3));    // return 3
        System.out.println(lRUCache.get(4));    // return 4
    }

    public LRUCache(int capacity) {
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }
}
