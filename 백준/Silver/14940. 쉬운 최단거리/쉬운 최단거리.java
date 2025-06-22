import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static final int[] dx = {1, 0, -1, 0};
    private static final int[] dy = {0, 1, 0, -1};

    private static boolean[][] graph;
    private static int[][] distance;

    private static int N, M;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new boolean[N][M];
        distance = new int[N][M];

        int cx = 0;
        int cy = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int a = Integer.parseInt(st.nextToken());
                if(a == 2) {
                    cx = i;
                    cy = j;
                    graph[cx][cy] = true;
                }
                else if(a == 1) graph[i][j] = true;
                else graph[i][j] = false;
            }
        }

        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{cx, cy, 0}); // x, y, d
        distance[cx][cy] = 0;
        graph[cx][cy] = false;

        while(!q.isEmpty()) {
            int[] pos = q.poll();

            for(int d = 0; d < 4; d++) {
                int mx = pos[0] + dx[d];
                int my = pos[1] + dy[d];

                if(mx < 0 || mx >= N || my < 0 || my >= M) continue;
                if(!graph[mx][my] || distance[mx][my] > 0) continue;
                distance[mx][my] = pos[2] + 1;
                q.add(new int[]{mx, my, pos[2] + 1});
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(!graph[i][j]) sb.append(0).append(" ");
                else if(graph[i][j] && distance[i][j] == 0) sb.append(-1).append(" ");
                else sb.append(distance[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }
}