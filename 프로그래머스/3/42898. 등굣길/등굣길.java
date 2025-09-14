import java.util.*;

class Solution {
    private static final int MOD = 1_000_000_007;
    private static final int INF = 1_000_000;
    public int solution(int m, int n, int[][] puddles) {
        int[][] dp = new int[m+1][n+1];
        int[][] caseDP = new int[m+1][n+1];
        
        
        for(int i = 0; i <= m; i++) {
            for(int j = 0; j <= n; j++) {
                dp[i][j] = INF;
            }
        }
        
        dp[1][1] = 0;
        caseDP[1][1] = 1;
        
        for(int[] puddle: puddles) {
            caseDP[puddle[0]][puddle[1]] = -1;
        }
        
        
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                if(caseDP[i][j] < 0) continue;
                // 최단 거리인지 확인
                // 위쪽 더하기
                if(dp[i][j] >= dp[i][j-1] + 1 && caseDP[i][j-1] >= 0) {
                    if(dp[i][j] == dp[i][j-1] + 1) {
                        caseDP[i][j] += caseDP[i][j-1];
                        caseDP[i][j] %= MOD;
                    } else {
                        dp[i][j] = dp[i][j-1] + 1;
                        caseDP[i][j] = caseDP[i][j-1];
                    }
                }
                // 아래쪽 더하기
                if(dp[i][j] >= dp[i-1][j] + 1 && caseDP[i-1][j] >= 0) {       
                    if(dp[i][j] == dp[i-1][j] + 1) {
                        caseDP[i][j] += caseDP[i-1][j];
                        caseDP[i][j] %= MOD;
                    } else {
                        dp[i][j] = dp[i-1][j] + 1;
                        caseDP[i][j] = caseDP[i-1][j];
                    }
                }
            }
        }
                
        if(caseDP[m][n] < 0) return 0;
        return caseDP[m][n];
    }
}