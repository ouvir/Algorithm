import java.util.*;

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        boolean[][] graph = new boolean[n][m];
        int[][] count = new int[n][m];
        count[0][0] = 1;
        
        for(int[] puddle: puddles) {
            graph[puddle[1]-1][puddle[0]-1] = true;
        }
        
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(graph[i][j]) continue;
                if(i-1 >= 0) count[i][j] = (count[i][j] + count[i-1][j]) % 1_000_000_007;
                if(j-1 >= 0) count[i][j] = (count[i][j] + count[i][j-1]) % 1_000_000_007;
            }
        }
        
        return count[n-1][m-1];
    }
}