import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static final int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
    static final int[] dy = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int N;
    static int[][] graph;
    static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int count;
            N = Integer.parseInt(br.readLine());
            visited = new boolean[N][N];
            st = new StringTokenizer(br.readLine());
            int sx = Integer.parseInt(st.nextToken());
            int sy = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int ex = Integer.parseInt(st.nextToken());
            int ey = Integer.parseInt(st.nextToken());

            count = bfs(sx, sy, ex, ey);

            sb.append(count).append("\n");
        }

        System.out.print(sb);
    }

    private static int bfs(int sx, int sy, int ex, int ey) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sx, sy, 0});
        visited[sx][sy] = true;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if (cur[0] == ex && cur[1] == ey) {
                return cur[2];
            }
            for (int k = 0; k < 8; k++) {
                int nx = cur[0] + dx[k], ny = cur[1] + dy[k];
                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if (visited[nx][ny]) continue;

                q.add(new int[]{nx, ny, cur[2] + 1});
                visited[nx][ny] = true;
            }
        }
        return -1;
    }
}