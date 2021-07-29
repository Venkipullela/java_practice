package problems;

import java.util.*;

public class BET {


    public static void findMaxArea1() {
        int[] a = new int[]{8, 3, 5, 7, 1, 3, 6, 3, 2};

        if(a.length < 3){
            System.out.println(0);
        }
        // 7, 4,2,1,3,5
        int[][] d = new int[a.length][a.length];
        for(int i = 0; i < a.length; i++) {
            for(int j = i+2; j < a.length; j++){
                if(j-i == 2){
                    d[i][j] = i+1;
                } else {
                    if(a[j-1] >= a[d[i][j-1]]) {
                        d[i][j] = j-1;
                    } else {
                        d[i][j] = d[i][j-1];
                    }
                }
            }
        }

        int i = 0, j = 2;
        int ans = 0;
        int currentMaxIndex = 1;
        while (j < a.length){
            int k;
            if(a[currentMaxIndex] > a[i] || a[currentMaxIndex] > a[j]) {
                k = currentMaxIndex;
            } else {
                k = -1;
            }

            if(k == -1) {
                int h = Math.min(a[i], a[j]);
                int currentArea = 0;
                for (int l = i+1; l < j; l++) {
                    currentArea += (h-a[l]);
                }
                ans = Math.max(ans, currentArea);
            } else {
                if(a[k] > a[i]){
                    i = k;
                    for(int l = i + 1; l < j+1; l++){
                        if(a[currentMaxIndex] <= a[l]){
                            currentMaxIndex = l;
                        }
                    }
                }
            }
            if(a[currentMaxIndex] <= a[j]){
                currentMaxIndex = j;
            }
            j++;

        }
        System.out.println(ans);
    }

    public static int canIandJformAValley(int[] a, int i, int j){
        for (int k = j-1; k > i; k--) {
            if(a[k] > a[i] || a[k] > a[j]){
                return k;
            }
        }
        return -1;
    }




    public static void abc(int n) {
        int[] a = new int[]{4,5,7,9,11,13,3,2,1,-1};

        int l = 0;
        int h = a.length-1;
        int m = (l+h)/2;

        int pointOfInflection = -1;

        while(l<=h){
            if(a[m-1] < a[m] && a[m] < a[m+1]) {
                l = m+1;
            } else if(a[m-1] > a[m] && a[m] > a[m+1]){
                h = m-1;
            } else {
                pointOfInflection = m;
                break;
            }
            if(m == h || m == l){
                break;
            }
            m = (l+h)/2;
        }

        System.out.println(pointOfInflection);
        if(n > a[0]) {
            int temp = Arrays.binarySearch(a, 0, pointOfInflection+1, n);
            if(temp > -1){
                System.out.println(temp);
                return;
            }
        } else if(n == a[0]) {
            System.out.println(0);
        }
        int temp = Arrays.binarySearch(a, pointOfInflection, a.length, n);
        if(temp > -1){
            System.out.println(temp);
            return;
        }
        System.out.println("not found");

    }



    public static void random() {
        List<Integer> list = new ArrayList<>();
        list.add(9);
        list.add(81);
        list.add(25);
        list.add(991);
        list.add(883);

        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String s1 = o1.toString();
                String s2 = o2.toString();
                return (s2+s1).compareTo(s1+s2);
            }
        });

        for (Integer i: list) {
            System.out.print(i);
        }
    }

    public static int[] restoreArray1(int[][] a) {
        List<Integer> ans = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        HashMap<Integer, Integer> reverseMap = new HashMap<>();
        for(int i = 0; i < a.length; i++){
            if(!map.containsKey(a[i][0])){
                map.put(a[i][0], a[i][1]);
            } else {
                int k = a[i][0];
                int v = map.get(k);
                reverse(map, k, v);
                map.put(k, a[i][1]);
            }
        }
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            reverseMap.put(entry.getValue(), entry.getKey());
        }

        int k = a[0][0];
        int v = map.get(a[0][0]);
        ans.add(a[0][0]);
        ans.add(v);
        map.remove(a[0][0]);
        if(reverseMap.containsKey(v)) {
            if(reverseMap.get(v).equals(a[0][0])){
                reverseMap.remove(v);
            }
        }
        while (!map.isEmpty()){
            if(map.containsKey(v)) {
                int t = map.get(v);
                ans.add(t);
                map.remove(v);
                if(reverseMap.containsKey(t)){
                    if(reverseMap.get(t).equals(v)){
                        reverseMap.remove(t);
                    }
                }
                v = t;
            } else {
                if(reverseMap.containsKey(v)){
                    if(!reverseMap.get(v).equals(ans.get(ans.size()-1))){
                        int t = v;
                        ans.add(reverseMap.get(v));
                        v = reverseMap.get(v);
                        map.remove(v);
                        reverseMap.remove(t);
                        continue;
                    }
                }
                boolean found = false;
                for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
                    if(entry.getValue().equals(v)) {
                        ans.add(entry.getKey());
                        map.remove(entry.getKey());
                        v = entry.getKey();
                        found = true;
                        break;
                    }
                }
                if(!found) {
                    Collections.reverse(ans);
                    v = ans.get(ans.size()-1);
                }
            }
        }

        int[] b = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            b[i] = ans.get(i);
        }
        return b;
    }

    public static HashMap<Integer, Integer> reverse(HashMap<Integer, Integer> map, int k, int v){
        if(map.containsKey(v)) {
            map = reverse(map, v, map.get(v));
        }
        map.remove(k);
        map.put(v,k);
        return map;
    }


    public static int[] mergeList(List<List<Integer>> list) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if(ans.size() == 0){
                ans.addAll(list.get(i));
                list.remove(i);
                i = -1;
            } else {
                if(ans.get(ans.size()-1) == list.get(i).get(0)) {
                    ans.remove(ans.size()-1);
                    ans.addAll(list.get(i));
                    list.remove(i);
                    i = -1;
                } else if(ans.get(ans.size()-1) == list.get(i).get(list.get(i).size() - 1)){
                    ans.remove(ans.size()-1);
                    Collections.reverse(list.get(i));
                    ans.addAll(list.get(i));
                    list.remove(i);
                    i = -1;
                } else if(ans.get(0) == list.get(i).get(0)) {
                    ans.remove(0);
                    Collections.reverse(ans);
                    ans.addAll(list.get(i));
                    list.remove(i);
                    i = -1;
                } else if(ans.get(0) == list.get(i).get(list.get(i).size() - 1)){
                    ans.remove(0);
                    Collections.reverse(list.get(i));
                    Collections.reverse(ans);
                    ans.addAll(list.get(i));
                    list.remove(i);
                    i = -1;
                }
            }
        }
        int[] a = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            a[i] = ans.get(i);
        }
        return a;
    }

    public static String solution(int a, int b, int c) {
        List<Integer> list = new ArrayList<>();
        StringBuffer sb = new StringBuffer();
        int max, mid, min;
        char maxChar, midChar, minChar;

        if(a >= b && a >= c){
            max = a; maxChar = 'a';
            if(b >= c){
                mid = b; midChar = 'b'; min = c; minChar = 'c';
            } else {
                min = b; minChar = 'b'; mid = c; midChar = 'c';
            }
        } else if(b >= a && b >= c){
            max = b; maxChar = 'b';
            if(a >= c){
                mid = a; midChar = 'a'; min = c; minChar = 'c';
            } else {
                min = a; minChar = 'a'; mid = c; midChar = 'c';
            }
        } else {
            max = c; maxChar = 'c';
            if(a >= b){
                mid = a; midChar = 'a'; min = b; minChar = 'b';
            } else {
                min = a; minChar = 'a'; mid = b; midChar = 'b';
            }
        }

        sb.append(String.valueOf(maxChar).repeat(Math.max(0, max)));

        for(int i = 0; i < mid; i++ ){
            if(i*3+2 < sb.length()){
                sb.insert(3*i+2, midChar);
            } else {
                sb.append(midChar);
            }
        }

        for(int i = 0 ; i < min; i++) {
            sb.insert(sb.length() - (3*i+2), minChar);
        }
        String s = sb.toString();
        int j = -1;
        if(s.contains("aaa")) {
            j = s.indexOf("aaa");
        } else if(s.contains("bbb")) {
            j = s.indexOf("bbb");
        } else if(s.contains("ccc")){
            j = s.indexOf("ccc");
        }

        if(j != -1){
            int length = 1;
            for(int i = j+1; i < s.length(); i++) {
                if(s.charAt(i) == s.charAt(i-1)){
                    length++;
                } else{
                    break;
                }
            }
            s = s.substring(0,j) + s.charAt(j) + s.charAt(j) + s.substring(j+length,s.length());
        }
        return s;
    }

    public String solution(String s) {
        Long musicSize = 0L, imagesSize = 0L, moviesSize = 0L, otherSize = 0L;

        List<String> musicExtensions = Arrays.asList("mp3", "aac", "flac");
        List<String> imagesExtensions = Arrays.asList("jpg", "bmp", "gif");
        List<String> moviesExtensions = Arrays.asList("mp4", "avi", "mkv");

        String[] modifiedInput = s.split("\n");

        for (String str : modifiedInput) {
            String[] splitStr = str.split(" ");
            String[] splitFile = splitStr[0].split("\\.");

            if (musicExtensions.contains(splitFile[splitFile.length - 1])) {
                musicSize += Long.parseLong(splitStr[1].substring(0, splitStr[1].length()-1));
            } else if (imagesExtensions.contains(splitFile[splitFile.length - 1])) {
                imagesSize += Long.parseLong(splitStr[1].substring(0, splitStr[1].length()-1));
            } else if (moviesExtensions.contains(splitFile[splitFile.length - 1])) {
                moviesSize += Long.parseLong(splitStr[1].substring(0, splitStr[1].length()-1));
            } else {
                otherSize += Long.parseLong(splitStr[1].substring(0, splitStr[1].length()-1));
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append("music ").append(musicSize).append("b\n");
        sb.append("images  ").append(imagesSize).append("b\n");
        sb.append("movies  ").append(moviesSize).append("b\n");
        sb.append("other ").append(otherSize).append("b");

        return sb.toString();
    }

    public static void main(String[] args){
        //restoreArray(new int[][]{{-3,-9},{-5,3},{2,-9},{6,-3},{6,1},{5,3},{8,5},{-5,1},{7,2}});
    }



    static class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }
    }
}
