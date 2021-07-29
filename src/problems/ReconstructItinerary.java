package problems;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class ReconstructItinerary {
    public static void main(String[] args){
        List<List<String>> input = new ArrayList<>();
        List<String> i = new ArrayList<>();
        i.add("MUC");
        i.add("LHR");
        input.add(i);
        List<String> i1 = new ArrayList<>();
        i1.add("JFK");
        i1.add("MUC");
        input.add(i1);
        System.out.println(findItinerary(input).toString());
    }
    public static List<String> findItinerary(List<List<String>> tickets) {
        HashMap<String, List<String>> graph = new HashMap();
        for (List<String> l: tickets) {
            add(graph, l.get(0), l.get(1));
        }
        for(String key: graph.keySet()) {
            graph.get(key).sort(new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    if(graph.getOrDefault(o1, new ArrayList<>()).contains(key)
                            && graph.getOrDefault(o2, new ArrayList<>()).contains(key)
                    ) {
                        return o1.compareTo(o2);
                    } else {
                        if(graph.getOrDefault(o1, new ArrayList<>()).contains(key)) {
                            return -1;
                        } else if(graph.getOrDefault(o2, new ArrayList<>()).contains(key)) {
                            return 1;
                        } else {
                            return o1.compareTo(o2);
                        }
                    }
                }
            });
        }
        HashMap<String, List<String>> traversed = new HashMap<>();
        List<String> ans = new ArrayList<>();

        return dfs(graph, traversed, ans, "JFK");
    }

    public static List<String> dfs(HashMap<String, List<String>> graph,
                                   HashMap<String, List<String>> traversed,
                                   List<String> ans,
                                   String start){
        ans.add(start);
        List<String> ends = graph.getOrDefault(start, new ArrayList<>());
        for (String end: ends) {
            if(traversed.getOrDefault(start, new ArrayList<>()).contains(end)){
                continue;
            } else {
                List<String> traversedTo = traversed.getOrDefault(start, new ArrayList<>());
                traversedTo.add(end);
                traversed.put(start, traversedTo);
                dfs(graph, traversed, ans, end);
            }
        }
        return ans;
    }

    public static void add(HashMap<String, List<String>> graph, String start, String end) {
        if(graph.containsKey(start)) {
            graph.get(start).add(end);
        } else {
            List<String> ends = new ArrayList<>();
            ends.add(end);
            graph.put(start, ends);
        }
    }

}
