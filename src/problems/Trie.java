package problems;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Trie {
    static TrieNode root = null;

    public static void main(String[] args) {

        int[] a = {1,2,3,4,5,6,7,8};
        System.out.println(Arrays.stream(Arrays.copyOfRange(a, 1,4)).min().getAsInt());


        Queue<int[]> queue = new ArrayDeque<>();
        ExecutorService executorService =
                new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS,
                        new LinkedBlockingDeque<>());
        addText("venki");
        addText("baanu");
        addText("venkibro");
        addText("vi");

        delete("venki");
        delete("vii");
        System.out.println(isPresent("venki"));
        System.out.println(isPresent("ven"));
        System.out.println(isPresent("venkibro"));
    }

    static int getNumberOfWordsStartingWith(char c){
        return 0;
    }

    static boolean isPresent(String s) {
        if(s.equals("")) return true;
        TrieNode curr = root;
        for(char c: s.toCharArray()) { //
            if(curr.trieNodes[c - 'a'] == null) return false;
            curr = curr.trieNodes[c - 'a'];
        }
        return curr.isThisAWord;
    }

    public void hello() {

    }

    static void delete(String s) {
        if(s.equals("")) return;
        if(!isPresent(s)) return;

        TrieNode prev;
        TrieNode curr = root;
        for(char c: s.toCharArray()){
            prev = curr;
            curr = curr.trieNodes[c - 'a'];
            if(curr.numberOfWords == 1){
                prev.trieNodes[c - 'a'] = null;
                prev.numberOfWords--;
                return;
            } else {
                curr.numberOfWords--;
            }
        }
        curr.isThisAWord = false;
        curr.numberOfWords--;
        return;
    }

    static void addText(String s) { // "is"
        if(s.equals("")) return;
        TrieNode curr = root;
        for(char c: s.toCharArray()) {// c = 's'
            if(curr.trieNodes[c - 'a'] == null) curr.trieNodes[c - 'a'] = new TrieNode();
            curr = curr.trieNodes[c - 'a'];
        }
        curr.isThisAWord = true;
    }


    static class TrieNode {
        int numberOfWords = 0;
        Boolean isThisAWord = false;
        TrieNode[] trieNodes = new TrieNode[26];

        @Override
        public String toString() {
            return "TrieNode{" +
                    "numberOfWords=" + numberOfWords +
                    ", isThisAWord=" + isThisAWord +
                    ", trieNodes=" + Arrays.toString(trieNodes) +
                    '}';
        }

    }
}
