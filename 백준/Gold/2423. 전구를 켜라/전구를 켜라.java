import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static char[][] a;
    static final int INF = 1 << 30;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        a = new char[N][M];
        for (int i = 0; i < N; i++) a[i] = br.readLine().toCharArray();

        // (N+M)이 홀수면 도달 불가
        if (((N + M) & 1) == 1) {
            System.out.println("NO SOLUTION");
            return;
        }

        int[][] dist = new int[N + 1][M + 1];
        for (int i = 0; i <= N; i++) Arrays.fill(dist[i], INF);

        Deque<int[]> dq = new ArrayDeque<>();
        dist[0][0] = 0;
        dq.addFirst(new int[]{0, 0});

        while (!dq.isEmpty()) {
            int[] cur = dq.pollFirst();
            int x = cur[0], y = cur[1];
            int d = dist[x][y];
            if (d > dist[x][y]) continue;

            // (x,y) -> (x+1,y+1) : 셀 (x,y), 필요 대각선 '\'
            if (x < N && y < M) {
                int w = (a[x][y] == '\\') ? 0 : 1;
                if (dist[x + 1][y + 1] > d + w) {
                    dist[x + 1][y + 1] = d + w;
                    if (w == 0) dq.addFirst(new int[]{x + 1, y + 1});
                    else dq.addLast(new int[]{x + 1, y + 1});
                }
            }
            // (x,y) -> (x+1,y-1) : 셀 (x,y-1), 필요 대각선 '/'
            if (x < N && y > 0) {
                int w = (a[x][y - 1] == '/') ? 0 : 1;
                if (dist[x + 1][y - 1] > d + w) {
                    dist[x + 1][y - 1] = d + w;
                    if (w == 0) dq.addFirst(new int[]{x + 1, y - 1});
                    else dq.addLast(new int[]{x + 1, y - 1});
                }
            }
            // (x,y) -> (x-1,y+1) : 셀 (x-1,y), 필요 대각선 '/'
            if (x > 0 && y < M) {
                int w = (a[x - 1][y] == '/') ? 0 : 1;
                if (dist[x - 1][y + 1] > d + w) {
                    dist[x - 1][y + 1] = d + w;
                    if (w == 0) dq.addFirst(new int[]{x - 1, y + 1});
                    else dq.addLast(new int[]{x - 1, y + 1});
                }
            }
            // (x,y) -> (x-1,y-1) : 셀 (x-1,y-1), 필요 대각선 '\'
            if (x > 0 && y > 0) {
                int w = (a[x - 1][y - 1] == '\\') ? 0 : 1;
                if (dist[x - 1][y - 1] > d + w) {
                    dist[x - 1][y - 1] = d + w;
                    if (w == 0) dq.addFirst(new int[]{x - 1, y - 1});
                    else dq.addLast(new int[]{x - 1, y - 1});
                }
            }
        }

        int ans = dist[N][M];
        System.out.println(ans >= INF ? "NO SOLUTION" : ans);
    }
}
