import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int N, K;
    private static int[][] graph;
    private static boolean[] visited;
    private static int output;

    // 모두 방문해야 함 -> 순서 나열 nPn 10!

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new  StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        graph = new int[N][N];
        visited = new boolean[N];

        output = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            st = new  StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int k = 0; k < N; k++){
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++) {
                    if(i == j) continue;

                    if(graph[i][j] > graph[i][k] + graph[k][j]){
                        graph[i][j] = graph[i][k] + graph[k][j];
                    }
                }
            }
        }

        visited[K] = true;
        perm(K, 1, 0);

        System.out.println(output);
    }

    private static void perm(int cur, int depth, int distance) {
        if(depth == N) {
            output = Math.min(output, distance);
            return;
        }
        for(int i = 0; i < N; i++){
            if(visited[i]) continue;
            visited[i] = true;
            perm(i, depth + 1, distance + graph[cur][i]);
            visited[i] = false;
        }

    }
}