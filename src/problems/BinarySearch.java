package problems;

import java.util.*;

public class BinarySearch {

    public static void main(String[] args) {
        LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add(3);
        linkedHashSet.add(5);
        linkedHashSet.add(7);



    }

    public static int bfs(Map<String, List<String>> graph, String b, String e) {
        HashSet<String> added = new HashSet<>();
        added.add(b);
        Queue<String> queue = new ArrayDeque<>();
        queue.add(b);
        queue.add(null);
        int ans = 1;
        while(!queue.isEmpty()) {
            String s = queue.poll();
            if(s == null) {
                if(queue.isEmpty()) {
                    break;
                } else {
                    ans++;
                    queue.add(null);
                }
            }else {
                if(s.equals(e)){
                    return ans;
                }
                List<String> list = graph.get(s);
                for(String element: list) {
                    if(!added.contains(element)) {
                        added.add(element);
                        queue.add(element);
                    }
                }
            }
        }

        return 0;
    }
}
