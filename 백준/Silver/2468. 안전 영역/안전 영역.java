import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static final int MAX_HEIGHT = 100;
    private static final int[] dx = new int[] {1, 0, -1, 0};
    private static final int[] dy = new int[] {0, 1, 0, -1};
    private static int N;
    private static int[][] graph;
    private static boolean[][] visited;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        graph = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int maxAreaCount = 0;
        for (int h = 0; h <= MAX_HEIGHT; h++) {
            int areaCount = 0;
            visited = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(graph[i][j] > h && !visited[i][j]) {
                        bfs(i, j, h);
                        areaCount++;
                    }
                }
            }

            maxAreaCount = Math.max(maxAreaCount, areaCount);
        }
        System.out.println(maxAreaCount);
    }

    private static void bfs(int i, int j, int h) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{i, j});
        visited[i][j] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for(int d = 0; d < 4; d++) {
                int mx =  cur[0] + dx[d];
                int my =  cur[1] + dy[d];
                if(mx < 0 || mx >= N || my < 0 || my >= N) continue;
                if(visited[mx][my] || graph[mx][my] <= h) continue;
                visited[mx][my] = true;
                q.add(new int[]{mx, my});
            }
        }
    }
}