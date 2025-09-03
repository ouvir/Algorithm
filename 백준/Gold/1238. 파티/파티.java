import java.util.*;
import java.io.*;

public class Main {
    private static int N, M, X;
    private static int[][] graph;
    private static final int INF = Integer.MAX_VALUE / 10;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        graph = new int[N+1][N+1];

        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                if(i == j) continue;
                graph[i][j] = INF;
            }
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[a][b] = c;
        }

        for(int k = 1; k < N+1; k++) {
            for(int i = 1; i < N+1; i++) {
                for(int j = 1; j < N+1; j++) {
                    if(graph[i][j] > graph[i][k] + graph[k][j]) {
                        graph[i][j] = graph[i][k] + graph[k][j];
                    }
                }
            }
        }

        int max = -1;

        for(int i = 1; i < N+1; i++) {
            if(i==X) continue;
            max = Math.max(max, graph[i][X] + graph[X][i]);
        }
        
        System.out.println(max);
    }
}