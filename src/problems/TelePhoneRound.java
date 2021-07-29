package problems;

import java.util.*;

public class TelePhoneRound {
    TrieNode root = new TrieNode();
    static HashMap<Character, Character> complimentaryChars = populateMap();

    public static void main(String[] args) {
        TelePhoneRound solution = new TelePhoneRound();
        List<String> input = new ArrayList<>();
        input.add("pod");
        input.add("");
        input.add("abc");
        input.add("abca");
        input.add("doolloop");
        input.add("dooloop");
        input.add("dooaoop");
        input = null;

        Map<Integer, Integer> map = new HashMap<>();
;
        List<Integer> v = List.copyOf(map.values());
        v.sort(Comparator.naturalOrder());

        List<String> output = solution.getComplimentaryWords(input);
        System.out.println(output);
    }

    public List<String> getComplimentaryWords(List<String> words) { //pood

        if(words.size() == 0) return new ArrayList<>();

        List<String> result = new ArrayList<>();
        for(String word: words) {
            if(isCompliment(word)) {
                result.add(word);
            }
        }
        return result;
    }

    public boolean isCompliment(String word) {
        if(word.length() == 0) return true;
        int n = word.length();
        int i = 0, j = n-1;

        while(i <= j) { // i = 2, j = 1
            if(complimentaryChars.getOrDefault(word.charAt(i), ' ') != word.charAt(j)) {
                return false;
            } else {
                i++; j--;
            }
        }
        return true;
    }

    public boolean isComplimentPresent(String word) {
        int n = word.length();
        if(n == 0) return false;

        for(int i = n-1; i >= 0; i++) {
            char c = complimentaryChars.getOrDefault(word.charAt(i), ' ');
            if(c == ' ') return false;
            if(root.childs[c - 'a'] == null) return false;
            if(i != 0) {
                root = root.childs[c - 'a'];
            } else {
                return root.isWord;
            }
        }
        return false;
    }

    public void populateTrie(List<String> words) {
        for(String word: words) {
            addWord(word);
        }
    }

    // it populates complimentaryChars map.
    public static HashMap<Character, Character> populateMap() {
        HashMap<Character, Character> complimentaryChars = new HashMap<>();
        complimentaryChars.put('b','q');
        complimentaryChars.put('q','b');
        complimentaryChars.put('o','o');
        complimentaryChars.put('p','d');
        complimentaryChars.put('d','p');
        complimentaryChars.put('l','l');
        return complimentaryChars;
    }


    public void addWord(String word) {
        char[] c = word.toCharArray();
        TrieNode curr= root;
        for(int i = 0; i < c.length; i++) {
            if(root.childs[c[i] - 'a'] == null) root.childs[c[i] - 'a'] = new TrieNode();
            root = root.childs[c[i]-'a'];
        }
        root.isWord = true;
    }

    class TrieNode {
        boolean isWord;
        TrieNode[] childs = new TrieNode[26];
    }
}
//pod , dip, dollop


// pol, lod

//b,q d,p l,l m,w, n,u o,o s,s x,x, z,z

