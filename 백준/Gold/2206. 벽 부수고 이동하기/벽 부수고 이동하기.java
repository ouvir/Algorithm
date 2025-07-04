import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static final int[] dx = new int[] {1, 0, -1, 0};
    private static final int[] dy = new int[] {0, 1, 0, -1};
    private static int N;
    private static int M;

    private static char[][] graph;
    private static boolean[][][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new char[N][M];
        visited = new boolean[N][M][2];

        for (int i = 0; i < N; i++) {
            String line  = br.readLine();
            for (int j = 0; j < M; j++) {
                graph[i][j] = line.charAt(j);
            }
        }

        int output = -1;

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {0, 0, 1, 1}); // x, y, distance, break
        visited[0][0][1] = true;
        visited[0][0][0] = true;

        while (!q.isEmpty()) {
            int[] pos = q.poll();
            int x = pos[0];
            int y = pos[1];
            int d = pos[2];
            int b = pos[3];

            if(x == N-1 && y == M-1) {
                output = d;
                break;
            }
            for (int i = 0; i < 4; i++) {
                int mx = x + dx[i];
                int my = y + dy[i];

                if(mx < 0 || mx >= N || my < 0 || my >= M) continue;
                if(graph[mx][my] == '1' && b >= 1 && !visited[mx][my][b-1]) {
                    visited[mx][my][b-1] = true;
                    q.add(new int[] {mx, my, d + 1, b-1});
                }
                if(graph[mx][my] == '1' || visited[mx][my][b]) continue;
                visited[mx][my][b] = true;
                q.add(new int[] {mx, my, d + 1, b});
            }
        }

        System.out.println(output);
    }
}
