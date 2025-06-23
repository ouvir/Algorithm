import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static final int INF = Integer.MAX_VALUE;

    private static final int[] dx = {1, 0, -1, 0};
    private static final int[] dy = {0, 1, 0, -1};
    private static int[][] fireCount;
    private static boolean[][] visited;
    private static char[][] graph;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        fireCount = new int[N][M];
        visited = new boolean[N][M];
        graph = new char[N][M];

        int cx = 0;
        int cy = 0;
        Queue<int[]> q = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                graph[i][j] = line.charAt(j);
                fireCount[i][j] = INF;
                if(graph[i][j] == 'J') {
                    cx = i;
                    cy = j;
                }
                else if(graph[i][j] == 'F') {
                    fireCount[i][j] = 0;
                    q.add(new int[] {i, j, 0}); // x, y, time
                    visited[i][j] = true;
                }
            }
        }

        // 불먼저 확산
        while(!q.isEmpty()) {
            int[] cur = q.poll();

            for (int d = 0; d < 4; d++) {
                int mx = cur[0] + dx[d];
                int my = cur[1] + dy[d];

                if(mx < 0 || mx >= N || my < 0 || my >= M) continue;
                if(visited[mx][my] || graph[mx][my] == '#') continue;
                visited[mx][my] = true;
                fireCount[mx][my] = cur[2] + 1;
                q.add(new int[] {mx, my, cur[2] + 1});
            }
        }

        // 지훈이 탈출 시켜보기
        visited = new boolean[N][M];
        q.add(new int[]{cx, cy, 0});
        visited[cx][cy] = true;
        boolean canEscape = false;
        int time = 0;

        while(!q.isEmpty()) {
            int[] pos = q.poll();

            if(pos[0] == 0 || pos[1] == 0 || pos[0] == N - 1 || pos[1] == M - 1) {
                canEscape = true;
                time = pos[2];
                break;
            }

            for (int d = 0; d < 4; d++) {
                int mx = pos[0] + dx[d];
                int my = pos[1] + dy[d];
                if(mx < 0 || mx >= N || my < 0 || my >= M) continue;
                if(visited[mx][my] || fireCount[mx][my] <= pos[2] + 1 || graph[mx][my] == '#') continue;
                visited[mx][my] = true;
                q.add(new int[] {mx, my, pos[2] + 1});
            }
        }

        if(!canEscape) System.out.println("IMPOSSIBLE");
        else System.out.println(time + 1);
    }
}