package problems;

import java.util.*;
import java.util.regex.Pattern;

public class WholeMinuteDilemma {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer> ar = new ArrayList<>();
        HashSet<Integer> a = new HashSet<Integer>(ar);

        if(prerequisites.length == 0){
            int[] ans = new int[numCourses];
            for(int i = 0; i < numCourses; i++){
                ans[i] = i;
            }
            return ans;
        }

        Map<Integer, List<Integer>> map = new HashMap<>();
        Map<Integer, Integer> indegreeMap = new HashMap<>();
        for(int i = 0; i < prerequisites.length; i++){
            List<Integer> currentList = map.getOrDefault(prerequisites[i][1], new ArrayList<>());
            currentList.add(prerequisites[i][0]);
            indegreeMap.put(prerequisites[i][0], indegreeMap.getOrDefault(prerequisites[i][0], 0) + 1);
            map.put(prerequisites[i][1], currentList);
        }

        for(int i = 0; i < numCourses; i++){
            if(!indegreeMap.containsKey(i)) {
                indegreeMap.put(i, 0);
            }
        }
        Queue<Integer> queue = new ArrayDeque();
        for(Integer key: indegreeMap.keySet()){
            if(indegreeMap.get(key) == 0) {
                queue.add(key);
            }
        }
        int[] ans = new int[indegreeMap.size()];
        int i = 0;
        while(!queue.isEmpty()){
            Integer key = queue.poll();
            ans[i++] = key;
            for(Integer v: map.getOrDefault(key, new ArrayList<>())) {
                if(indegreeMap.get(v) == 0){
                    return new int[]{};
                } else if(indegreeMap.get(v) == 1){
                    queue.add(v);
                    indegreeMap.put(v,0);
                } else {
                    indegreeMap.put(v,indegreeMap.get(v)-1);
                }
            }
        }
        if(indegreeMap.values().stream().max(Comparator.naturalOrder()).get() != 0){
            return new int[]{};
        }
        return ans;
    }

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int maxEnd = Arrays.stream(endTime).max().getAsInt();
        ArrayDeque<Integer> q = new ArrayDeque<>();


        return maxEnd;
    }
    public static void main(String[] strings) {
        int a = 1;
        int b = 17;
        System.out.println(a&b);

    }
    public static long playlist(List<Integer> songs) {
        for (int i = 0; i < songs.size(); i++) {
            songs.set(i, songs.get(i) % 60);
        }
        songs.sort(Comparator.naturalOrder());
        long ans = 0L;
        for (int i = 0; i < songs.size() - 1; i++) {
            if (songs.get(i) > 30) {
                break;
            }
            if (songs.get(i) == 0) {
                //ans += songs.lastIndexOf(0) - i;
                ans += getFirstOrLast(songs, 0, false) - i;
            }
            //int fi = songs.indexOf(60 - songs.get(i));
            int fi = getFirstOrLast(songs, 60 - songs.get(i), true);
            if (fi > -1) {
                if (songs.get(i) == 30) {
                    //ans += songs.lastIndexOf(30) - i;
                    ans += getFirstOrLast(songs, 30, false) - i;
                } else {
                    //ans += songs.lastIndexOf(60 - songs.get(i)) - fi + 1;
                    ans += getFirstOrLast(songs, 60 - songs.get(i), false) - fi + 1;
                }
            }
        }
        return ans;
    }

    public static int getFirstOrLast(List<Integer> integers, int item, boolean isFirst) {
        //int l = 0, h = integers.size()-1, m = (l+h)/2;
        /*while(l <= h){
            int middle = integers.get(m);
            if(middle < item) {
                l = m;
                m = (l+h)/2;
                if(l==m){
                    m++;
                }
            } else if (middle > item) {
                h = m;
                m = (l+h)/2;
                if(h==m){
                    m--;
                }
            } else if(middle == item) {
                if(isFirst){
                    while(m > -1) {
                        if(integers.get(m) < item) {
                            return ++m;
                        } else if (m==0){
                            return 0;
                        }
                        m--;
                    }
                } else {
                    while(m < integers.size()) {
                        if(integers.get(m) > item) {
                            return --m;
                        } else if(m == integers.size()-1){
                            return m;
                        }
                        m++;
                    }
                }
            }
            if(l+1 == h){
                if(item != integers.get(l) && item != integers.get(h)){
                    return -1;
                }
            }
        }*/


        int index = Collections.binarySearch(integers, item);
        if(index > -1){
            if(isFirst) {
                while(index > -1) {
                    if (integers.get(index) != item) {
                        return ++index;
                    } else if (index == 0) {
                        return 0;
                    } else {
                        index--;
                    }
                }
            } else {
                while (index < integers.size()) {
                    if(integers.get(index) != item){
                        return --index;
                    } else if(index == integers.size()-1){
                        return index;
                    } else {
                        index++;
                    }
                }
            }
        }
        return index;
    }


}
