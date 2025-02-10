import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static final int[] dx = {1,0,-1,0, 1,1,-1,-1};
    static final int[] dy = {0,1,0,-1, 1,-1,1,-1};
    static int N;
    static int M;
    static int[][] graph;
    static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        while(N != 0 && M != 0) {
            int count = 0;
            graph = new int[M][N];
            visited = new boolean[M][N];

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    graph[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if(graph[i][j] == 1 && !visited[i][j]) {
                        count++;
                        bfs(i,j);
                    }
                }
            }
            sb.append(count).append("\n");

            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
        }
        System.out.println(sb);
    }

    private static void bfs(int i, int j) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i,j});
        visited[i][j] = true;

        while(!q.isEmpty()) {
            int[] cur = q.poll();

            for(int k = 0; k < 8; k++) {
                int nx = cur[0] + dx[k], ny = cur[1] + dy[k];
                if(nx < 0 || ny < 0 || nx >= M || ny >= N) continue;
                if(graph[nx][ny] == 0 || visited[nx][ny]) continue;

                q.add(new int[]{nx, ny});
                visited[nx][ny] = true;
            }
        }
    }
}