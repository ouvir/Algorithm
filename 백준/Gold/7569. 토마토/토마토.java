import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static final int[] dx = {1, 0, -1, 0, 0, 0};
    static final int[] dy = {0, 1, 0, -1, 0, 0};
    static final int[] dz = {0, 0, 0, 0, 1, -1};
    static int N;
    static int M;
    static int H;
    static int[][][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 일부러 N,M 자리 바꿈!
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        graph = new int[H][N][M];
        boolean play = false;

        Queue<int[]> q = new ArrayDeque<>(); // z,x,y,time

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    int tmp = Integer.parseInt(st.nextToken());
                    graph[i][j][k] = tmp;
                    if (tmp == 1) q.add(new int[]{i, j, k, 0});
                    if(tmp == 0) play = true;
                }
            }
        }

        if(!play) {
            System.out.println(0);
            return;
        }

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int currZ = curr[0];
            int currX = curr[1];
            int currY = curr[2];
            int time = curr[3];

            for (int k = 0; k < 6; k++) {
                int mz = currZ + dz[k];
                int mx = currX + dx[k];
                int my = currY + dy[k];

                if(check(mz, mx, my)) continue;
                if(graph[mz][mx][my] >= 1 || graph[mz][mx][my] == -1) continue;
                graph[mz][mx][my] = time + 1;
                q.add(new int[] {mz, mx, my, time+1});
            }
        }
        // 토마토 체크하여 출력
        int max = 0;
        all:for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    int tmp = graph[i][j][k];
                    if(tmp == 0) {
                        max = -1;
                        break all;
                    }
                    max = Math.max(graph[i][j][k], max);
                }
            }
        }

        System.out.println(max);
    }

    private static boolean check(int mz, int mx, int my) {
        return mz < 0 || mz >= H || mx < 0 || mx >= N || my < 0 || my >= M;
    }

}