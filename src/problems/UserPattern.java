package problems;

import java.util.*;

public class UserPattern {
    public static void main(String[] args){
        String[] u = new String[]{"h","eiy","cq","h","cq","txldsscx","cq","txldsscx","h","cq","cq"};
        int[] t = new int[]{527896567,334462937,517687281,134127993,859112386,159548699,51100299,444082139,926837079,317455832,411747930};
        String[] w = new String[]{"hibympufi","hibympufi","hibympufi","hibympufi","hibympufi","hibympufi","hibympufi","hibympufi","yljmntrclw","hibympufi","yljmntrclw"};
        List<String> ans = mostVisitedPattern(u,t,w);
        for (String s: ans) {
            System.out.println(s);
        }
    }

    public static List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        Map<String, List<Tuple>> tuples = new TreeMap<>();
        for (int i = 0; i < username.length; i++) {
            List<Tuple> currentList = tuples.getOrDefault(username[i], new ArrayList<>());
            currentList.add(new Tuple(timestamp[i], website[i]));
            tuples.put(username[i], currentList);
        }


        Map<String, Integer> ans = new TreeMap<>();

        for (String key: tuples.keySet()) {
            if(tuples.get(key).size() < 3){
                continue;
            } else {
                List<Tuple> currentList = tuples.get(key);
                currentList.sort((a,b) -> (Integer.compare(a.stamp,  b.stamp)));
                for (int i = 0; i < currentList.size()-2; i++) {
                    for (int j = i+1; j < currentList.size()-1; j++) {
                        for (int k = j + 1; k < currentList.size(); k++) {
                            String ansKey = currentList.get(i).site+"_"+currentList.get(j).site+"_"+currentList.get(k).site;
                            ans.put(ansKey, ans.getOrDefault(ansKey, 0) + 1);
                        }
                    }
                }
            }
        }
        int max = 0;
        String ansString = "";
        for (String key: ans.keySet()) {
            if(ans.get(key) > max){
                max = ans.get(key);
                ansString = key;
            }
        }
        return Arrays.asList(ansString.split("_"));
    }

    static class Tuple{
        int stamp;
        String site;

        public Tuple(int stamp, String site) {
            this.stamp = stamp;
            this.site = site;
        }
    }
}
