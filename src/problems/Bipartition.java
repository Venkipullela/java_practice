package problems;

import java.util.*;

public class Bipartition {

    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder();

        int[][] dislikes = new int[][]{{36,68},{37,82},{8,63},{32,44},{75,78},{1,64},{11,48},{74,94},{2,41},{43,63},{67,74},{47,93},{1,28},{65,96},{43,76},{71,78},{80,94},{34,85},{94,98},{59,71},{57,59},{81,86},{86,93},{48,77},{26,89},{88,93},{7,44},{74,89},{90,95},{65,71},{66,93},{90,99},{3,11},{23,84},{46,52},{20,47},{27,60},{77,100},{57,63},{23,40},{73,92},{1,82},{13,82},{64,86},{76,78},{55,92},{70,88},{57,99},{35,79},{41,96},{71,90},{80,98},{5,20},{27,43},{36,95},{74,75},{38,93},{49,75},{7,56},{42,53},{89,91},{20,78},{91,93},{40,99},{68,73},{58,90},{85,98},{92,99},{60,84},{8,82},{32,72},{98,100},{20,27},{59,64},{81,83},{36,70},{32,46},{54,82},{41,63},{18,43},{89,92},{30,64},{31,82},{41,72},{69,78},{78,96},{24,54},{46,73},{60,83},{62,97},{81,84},{5,32},{62,83},{9,23},{7,46},{13,87},{28,79},{77,93},{51,97},{66,91},{67,91},{19,55},{67,97},{19,46},{43,93},{85,94},{61,98},{59,94},{60,64},{82,85},{28,57},{61,92},{9,46},{74,100},{7,39},{35,63},{23,53},{53,80},{54,70},{28,70},{20,91},{95,98},{79,96},{64,100},{37,97},{33,89},{71,84},{60,95},{48,83},{11,89},{16,44},{38,83},{65,87},{55,87},{54,87},{68,75},{43,96},{43,75},{46,68},{58,66},{19,34},{10,86},{82,97},{86,94},{2,80},{88,90},{49,66},{7,51},{78,90},{76,84},{12,13},{95,96},{67,84},{69,86},{80,82},{91,96},{27,59},{60,75},{23,49},{34,75},{15,95},{11,87},{50,75},{79,81},{28,73},{18,58},{11,25},{35,100},{43,95},{4,22},{87,90},{93,99},{38,68},{30,33},{14,100},{79,94},{74,76},{72,84},{69,70},{65,92},{66,80},{7,76},{40,96},{53,98},{66,74},{33,71},{96,99},{68,84},{25,41},{21,51},{9,85},{23,61},{7,30},{49,79},{25,29},{30,93},{65,79},{76,95},{55,79},{88,97},{1,55},{86,92},{99,100},{31,42},{11,80},{76,98},{73,84},{63,80},{78,88},{30,68},{19,97},{45,55},{78,100},{83,91},{90,98},{95,100},{80,84},{94,100},{91,98},{59,93},{21,47},{54,55},{37,69},{34,73},{48,67},{92,96},{27,83},{33,36},{72,73},{30,60},{7,42},{29,89},{49,83},{30,79},{37,48},{76,77},{57,73},{49,53},{41,95},{83,96},{5,97},{57,92},{8,68},{35,76},{33,76},{27,50},{21,40},{4,16},{30,39},{50,64},{79,88},{6,60},{13,38},{37,57},{18,51},{74,84},{14,21},{38,54},{42,94},{83,86},{53,96},{68,72},{1,26},{66,72},{58,93},{43,86},{85,99},{92,98},{89,96},{25,47},{21,49},{19,33},{34,91},{54,59},{2,85},{39,95},{53,79},{52,58},{76,89},{12,18},{1,19},{19,64},{41,83},{14,40},{10,72},{59,70},{82,93},{88,94},{13,88},{26,64},{43,55},{28,78},{76,80},{55,70},{69,92},{21,89},{19,73},{44,78},{24,60},{89,95},{91,100},{70,86},{1,32},{82,84},{4,43},{87,89},{51,63},{6,33},{1,81},{63,91},{75,85},{6,59},{65,95},{55,95},{64,77},{83,98},{69,91},{23,25},{85,88},{33,66},{71,85},{97,100},{70,99},{32,40},{63,64},{29,80},{6,50},{65,80},{78,82},{74,82},{10,27},{44,60},{91,92},{59,75},{66,70},{93,94},{14,39},{71,82},{18,90},{27,35},{21,25},{86,89},{88,89},{74,93},{92,93},{46,100},{3,97},{69,77},{49,63},{94,95},{33,92},{23,88},{45,75},{84,90},{13,98},{53,59},{8,41},{25,66},{78,92},{8,21},{76,82},{42,78},{67,90},{64,72},{2,17},{45,68},{32,71},{93,100},{55,90},{33,56},{79,95},{42,47},{65,93},{28,71},{66,83},{59,86},{60,88},{36,41},{84,86},{63,100},{61,84},{53,55},{25,76},{28,86},{61,78},{3,78},{78,80},{29,72},{38,42},{67,72},{91,94},{95,97},{1,30},{13,22},{42,100},{68,82},{21,61},{80,92},{34,87},{98,99},{24,47},{60,77},{23,59},{82,94},{86,95},{7,20},{31,43},{53,71},{73,85},{88,91},{8,10},{63,81},{9,11},{74,91},{17,59},{58,68},{41,77},{92,95},{12,14},{43,67},{54,80},{69,85},{80,83},{26,51},{56,63},{3,47},{58,61},{61,64},{5,55},{53,84},{18,59},{40,84},{25,27},{67,92},{64,74},{31,67},{44,74},{41,88},{83,97},{86,88},{21,79},{84,99},{44,96},{9,73},{10,89},{93,98},{22,38},{24,45},{2,93},{74,77},{6,63},{53,93},{41,48},{31,77},{11,59},{12,60},{56,94},{12,26},{92,97},{96,100},{69,97},{58,70}};
        System.out.println(possibleBipartition(4,dislikes));
    }

    public static boolean possibleBipartition(int n, int[][] dislikes) {
        Arrays.sort(dislikes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]){
                    return o1[1] - o2[1];
                } else {
                    return o1[0] - o2[0];
                }
            }
        });

        HashMap<Integer, Integer> personSetMap = new HashMap<>();
        Map<Integer, SetPair> setPairMap = new TreeMap<>();

        for(int i = 0; i < dislikes.length; i++) {
            if(personSetMap.get(dislikes[i][0]) == null && personSetMap.get(dislikes[i][1]) == null) {
                int size = setPairMap.size()+1;
                personSetMap.put(dislikes[i][0], size);
                personSetMap.put(dislikes[i][1], size);

                SetPair sp = new SetPair();
                sp.f.add(dislikes[i][0]);
                sp.s.add(dislikes[i][1]);
                setPairMap.put(size, sp);

            } else if(personSetMap.get(dislikes[i][0]) == null) {
                int getSet = personSetMap.get(dislikes[i][1]);
                personSetMap.put(dislikes[i][0], getSet);

                SetPair sp = setPairMap.get(getSet);
                if(!sp.add(dislikes[i][0], dislikes[i][1])){
                    return false;
                };
            } else if(personSetMap.get(dislikes[i][1]) == null) {
                int getSet = personSetMap.get(dislikes[i][0]);
                personSetMap.put(dislikes[i][1], getSet);

                SetPair sp = setPairMap.get(getSet);
                if(!sp.add(dislikes[i][0], dislikes[i][1])){
                    return false;
                };
            } else {
                if(personSetMap.get(dislikes[i][0]) == personSetMap.get(dislikes[i][1])) {
                    SetPair sp = setPairMap.get(personSetMap.get(dislikes[i][0]));
                    if(!sp.add(dislikes[i][0], dislikes[i][1])){
                        return false;
                    };
                } else {
                    SetPair a = setPairMap.get(personSetMap.get(dislikes[i][0]));
                    SetPair b = setPairMap.get(personSetMap.get(dislikes[i][1]));
                    SetPair sp = mergeSetPairs(a, b, dislikes[i][0], dislikes[i][1]);
                    int min = Math.min(personSetMap.get(dislikes[i][0]), personSetMap.get(dislikes[i][1]));
                    int max = Math.max(personSetMap.get(dislikes[i][0]), personSetMap.get(dislikes[i][1]));
                    setPairMap.remove(min);
                    setPairMap.remove(max);
                    setPairMap.put(min, sp);
                    for(Integer in: sp.f) {
                        personSetMap.put(in, min);
                    }
                    for(Integer in: sp.s) {
                        personSetMap.put(in, min);
                    }
                    for (Map.Entry<Integer, Integer> entry: personSetMap.entrySet()) {
                        if(entry.getValue() > max) {
                            personSetMap.put(entry.getKey(), entry.getValue()-1);
                        }
                    }
                    for (Integer key: setPairMap.keySet()) {
                        if(key > max) {
                            SetPair val = setPairMap.get(key);
                            setPairMap.remove(key);
                            setPairMap.put(key-1, val);
                        }
                    }
                }
            }
        }
        return true;
    }

    public static SetPair mergeSetPairs(SetPair a, SetPair b, int x, int y) {
        SetPair sp = new SetPair();
        if((a.f.contains(x) && b.f.contains(y)) || (a.s.contains(x) && b.s.contains(y))) {
            sp.s.addAll(b.f);
            sp.f.addAll(b.s);
        } else {
            sp.s.addAll(b.s);
            sp.f.addAll(b.f);
        }
        sp.s.addAll(a.s);
        sp.f.addAll(a.f);
        return sp;
    }

    public static class SetPair {
        Set<Integer> f = new HashSet<>();
        Set<Integer> s = new HashSet<>();

        public boolean add(int a, int b) {
            if(this.f.contains(a)) {
                if(this.f.contains(b)) return false;
                this.s.add(b);
            } else if(this.s.contains(a)) {
                if(this.s.contains(b)) return false;
                this.f.add(b);
            } else if(this.f.contains(b)) {
                if(this.f.contains(a)) return false;
                this.s.add(a);
            } else {
                if(this.s.contains(a)) return false;
                this.f.add(a);
            }
            return true;
        }
    }
}

