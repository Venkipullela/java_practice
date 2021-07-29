package problems;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.TreeMap;

public class LFUCache {

    Map<Integer, ValueAndFrequency> map = new HashMap<>();
    TreeMap<Integer, LinkedHashSet<Integer>> frequencyKeyListMap = new TreeMap<>();
    int capacity = 0;

    public LFUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        ValueAndFrequency valueAndFrequency = map.get(key);

        int currentFrequency = valueAndFrequency.frequency;
        valueAndFrequency.frequency++;

        LinkedHashSet<Integer> keyMap;
        if(currentFrequency != 0){
            keyMap = frequencyKeyListMap.get(currentFrequency);
            keyMap.remove(key);
            if(keyMap.size() == 0){
                frequencyKeyListMap.remove(currentFrequency);
            }
        }
        keyMap = frequencyKeyListMap.getOrDefault(currentFrequency+1, new LinkedHashSet<>());
        keyMap.add(key);
        frequencyKeyListMap.put(currentFrequency+1, keyMap);

        return valueAndFrequency.value;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)) {
            map.put(key, new ValueAndFrequency(value, map.get(key).frequency));
        } else {
            map.put(key, new ValueAndFrequency(value, 0));
        }
        get(key);
        if(map.size() == capacity + 1) {
            Map.Entry<Integer,LinkedHashSet<Integer>> entry = frequencyKeyListMap.firstEntry();
            LinkedHashSet<Integer> valueSet = entry.getValue();
            Integer removalKey = valueSet.stream().findFirst().get();
            valueSet.remove(removalKey);
            if(valueSet.size() == 0){
                frequencyKeyListMap.remove(entry.getKey());
            }
        }
    }

    class ValueAndFrequency {
        int value;
        int frequency;
        public ValueAndFrequency(int value, int frequency){
            this.value = value;
            this.frequency = frequency;
        }
    }
}