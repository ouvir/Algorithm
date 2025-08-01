import java.util.*;

class Solution {
    private static int answer;
    private static int N, K;
    private static int[] visitOrder;
    private static boolean[] visited;
    private static int[][] graph;
    
    public int solution(int k, int[][] dungeons) {
        answer = 0;
        N = dungeons.length;
        K = k;
        visitOrder = new int[N];
        visited = new boolean[N];
        graph = dungeons;
        
        perm(0);
        
        return answer;
    }
    
    private static void perm(int depth) {
        if(depth == N) {
            answer = Math.max(answer, calc());
            return;
        }
        
        for(int i = 0; i < N; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            visitOrder[depth] = i;
            perm(depth + 1);
            visited[i] = false;
            visitOrder[depth] = 0;
        }
    }
    
    private static int calc() {
        int answer = 0;
        int tmp = K;
        
        for(int i = 0 ; i < N; i++) {
            if(graph[visitOrder[i]][0] > tmp || graph[visitOrder[i]][1] > tmp) {
                break;
            }
            tmp -= graph[visitOrder[i]][1];
            answer++;
        }
        return answer;
    }
}