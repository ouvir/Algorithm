import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int N, M;
    private static boolean[][] graph;
    private static boolean[][][] visited;
    private static final int[] dx = {1, 0, -1, 0};
    private static final int[] dy = {0, 1, 0, -1};
    private static final int INF = Integer.MAX_VALUE / 10;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new boolean[N][M];
        visited = new boolean[N][M][2]; // 0~1 부수기 사용 개수

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                if (line.charAt(j) == '1') graph[i][j] = true;
            }
        }

        int output = -1;

        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{0, 0, 1, 1}); // x, y, moveCount, remainBreakCount
        visited[0][0][1] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            if (cur[0] == N - 1 && cur[1] == M - 1) {
                output = cur[2];
                break;
            }

            for (int d = 0; d < 4; d++) {
                int nx = cur[0] + dx[d];
                int ny = cur[1] + dy[d];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;

                if (cur[3] >= 1 && graph[nx][ny]) {
                    if (visited[nx][ny][cur[3] - 1]) continue;
                    q.add(new int[]{nx, ny, cur[2] + 1, cur[3] - 1});
                    visited[nx][ny][cur[3] - 1] = true;
                } else {
                    if (graph[nx][ny]) continue;
                    if (visited[nx][ny][cur[3]]) continue;
                    q.add(new int[]{nx, ny, cur[2] + 1, cur[3]});
                    visited[nx][ny][cur[3]] = true;
                }
            }
        }
        System.out.println(output);
    }


}