package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RollingHash {
    int mod = 1000000009;
    public static void main(String[] args) {
        //System.out.println((long)Math.pow(26,39));

        boolean a = true;
        boolean b = true;
        System.out.println(~(10^12));

//        int[] a = new int[2];
//        a[0] = 0;
//        int[] b = Arrays.copyOf(a, a.length);
//        b[0] = 10;
//        System.out.println(a[0]);
//        System.out.println(b[0]);
//        Arrays.stream(a).min().getAsInt();
        System.out.println(Long.parseLong("999999999999999999"));
        ArrayList<Integer> list = new ArrayList<>();
        RollingHash rollingHash = new RollingHash();
        System.out.println(rollingHash.patternMatching("zbzbcdefghcdehdsabcdskejeksldfyuekaazbcdefghbcdef", "zbcdefgh"));
    }

    public boolean patternMatching(String s, String k) { // "abcd", "bc"
        int kl = k.length();
        int n = s.length();

        long hash = getHash(k);
        long currentHash = getHash(s.substring(0,kl));
        if(currentHash == hash) {
            return true;
        }

        for(int i = kl; i < n; i++){
            currentHash = ((currentHash - ((s.charAt(i-kl)-'a'+1)*(getPower(kl-1)%mod))) + mod)%mod;
            if(currentHash < 0) {
                currentHash+= mod;
            }
            currentHash = (currentHash * 26)%mod;
            currentHash = (currentHash + s.charAt(i)-'a'+1)%mod;
            if(currentHash == hash) {
                return true;
            }
        }
        return false;

    }

    public long getHash(String k) {
        long hash = 0;
        int n = k.length();
        for(int i = 0; i < n; i++){
            hash = ((hash*26)%mod + (k.charAt(n-i-1) - 'a' + 1))%mod;
        }
        return hash;
    }

    public long getPower(int n) {
        long ans = 1;
        for(int i = 0; i < n; i++) {
            ans = (ans*26)%mod;
        }
        return ans;
    }
}
