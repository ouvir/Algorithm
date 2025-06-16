import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static final int INF = Integer.MAX_VALUE;

    private static final int[] dx = {1, 0, -1, 0};
    private static final int[] dy = {0, 1, 0, -1};

    private static int size;
    private static int eatCount;
    private static int N;
    private static int cx;
    private static int cy;

    private static int[][] graph;
    private static int[][] distance;
    private static boolean[][] canEat;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        graph = new int[N][N];
        distance = new int[N][N];
        canEat = new boolean[N][N];

        size = 2;
        eatCount = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                if(graph[i][j] == 9) {
                    cx = i;
                    cy = j;
                }
            }
        }

        int time = 0;

        while(canEat()) {
            time += findAndEatTarget();
            canEat = new boolean[N][N];
            distance = new int[N][N];
        }

        System.out.println(time);
    }

    private static int findAndEatTarget() {
        int tx = 0;
        int ty = 0;
        int minDistance = INF;

        // find
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(canEat[i][j] && distance[i][j] < minDistance) {
                    tx = i;
                    ty = j;
                    minDistance = distance[i][j];
                }
            }
        }

        // eat
        graph[tx][ty] = 9;
        graph[cx][cy] = 0;
        cx = tx;
        cy = ty;
        eatCount++;
        if(eatCount == size) {
            size++;
            eatCount = 0;
        }

        return distance[tx][ty];
    }

    private static boolean canEat() {
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][N];
        visited[cx][cy] = true;
        distance[cx][cy] = INF;
        q.add(new int[] {cx, cy, 0});

        while(!q.isEmpty()) {
            int[] pos = q.poll();
            int x = pos[0];
            int y = pos[1];
            int m = pos[2];

            for(int d = 0; d < 4; d++) {
                int mx = x + dx[d];
                int my = y + dy[d];
                if(mx < 0 || mx >= N || my < 0 || my >= N) continue;
                if(visited[mx][my] || graph[mx][my] > size) continue;
                if(graph[mx][my] < size && graph[mx][my] > 0) canEat[mx][my] = true;
                visited[mx][my] = true;
                distance[mx][my] = m + 1;
                q.add(new int[] {mx, my, m + 1});
            }
        }

        for (int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(canEat[i][j]) {
                    return true;
                }
            }
        }
        return false;
    }
}
