import java.util.*;

class Solution {
    private static int[] distance;
    private static List<Integer>[] graph;
    
    public int solution(int n, int[][] edge) {
        graph = new List[n+1];
        
        for(int i = 1; i <= n; i++) graph[i] = new ArrayList<Integer>();
        
        for(int[] ed: edge) {
            graph[ed[0]].add(ed[1]);
            graph[ed[1]].add(ed[0]);
        }
        
        
        //for(int i = 1; i <= n; i++) System.out.print(graph[i]);
        distance = new int[n+1];
        bfs(1, n);
        
        int answer = 0;
        int maxValue = -1;
        for(int i = 1; i <= n; i++) {
            if(distance[i] > maxValue) {
                answer = 1;
                maxValue = distance[i];
            } else if(distance[i] == maxValue) {
                answer++;
            } 
        }        
        
        return answer;
    }
    
    public static void bfs(int start, int n) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] {start, 0});
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            
            for(int next: graph[cur[0]]) {
                if(next != start && distance[next] == 0) {
                    distance[next] = cur[1] + 1;
                    q.add(new int[] {next, distance[next]});
                }
            }
        }
    
    }
}