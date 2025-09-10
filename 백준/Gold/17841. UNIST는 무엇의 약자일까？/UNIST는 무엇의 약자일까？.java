import java.io.*;
import java.util.*;

public class Main {
    private static int N;
    private static String[] words;
    private static int[][] dp;
    private static final char[] UNIST = {'U','N','I','S','T'};
    private static final int MOD = 1_000_000_007;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        
        words = new String[N];
        dp = new int[N][5];
        
        for(int i = 0; i < N; i++) {
            words[i] = br.readLine();
        }

        // 첫단어
        for (int j = 0; j < 5; j++) {
            if (canMake(words[0], 0, j)) dp[0][j] = 1;
        }

        for(int i = 1; i < N; i++) {
            for(int j = 0; j < 5; j++) {
                dp[i][j] += dp[i-1][j];

                for(int k = 0; k <= j; k++) {
                    if(canMake(words[i], k, j)) {
                        if(k == 0) dp[i][j] += 1;
                        else dp[i][j] += dp[i-1][k-1];
                    }
                    dp[i][j] %= MOD;
                }
            }
        }

        System.out.print(dp[N-1][4] % MOD);
    }

    private static boolean canMake(String word, int k, int j) {
        char[] c = word.toCharArray();
        if(c.length <= (j-k))  return false;

        for(int i = k; i <= j; i++) {
            if(!(c[i-k] == UNIST[i])) return false;
        }
        return true;
    }
}
