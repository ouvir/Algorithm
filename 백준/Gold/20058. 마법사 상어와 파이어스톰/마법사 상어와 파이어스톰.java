import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static final int[] dx = {1, 0, -1, 0};
    private static final int[] dy = {0, 1, 0, -1};

    private static int[][] graph;
    private static boolean[][] visited;
    private static int N,Q,L;
    private static int size;
    private static int sum;
    private static int bigIce;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        size = (int) Math.pow(2, N);

        graph = new int[size][size];
        visited = new boolean[size][size];
        sum = 0;

        for (int i = 0; i < size; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < size; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 마법 시전
        st = new StringTokenizer(br.readLine());

        for (int q = 0; q < Q; q++) {
            L = Integer.parseInt(st.nextToken());
            // 격자로 나누어 90도 돌리기
            rotateAll(L);
            // 얼음 녹이기
            melt();
        }

        // 남은 얼음 합 구하기
        // 남은 얼음 중 가장 큰 덩어리 차지 칸 개수 구하기
        bigIce = 0;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if(graph[i][j] > 0 && !visited[i][j]) bfs(i, j);
            }
        }


        System.out.println(sum);
        if(bigIce <= 1) System.out.println(0);
        else System.out.println(bigIce);
    }

    private static void rotateAll(int l) {
        int rotateSize = (int) Math.pow(2, l);

        for (int i = 0; i < size; i += rotateSize) {
            for (int j = 0; j < size; j += rotateSize) {
                rotate(i, j, rotateSize);
//                for (int i2 = 0; i2 < size; i2++) {
//                    for (int j2 = 0; j2 < size; j2++) {
//                        System.out.print(graph[i2][j2] + " ");
//                    }
//                    System.out.println();
//                }
//                System.out.println("---------------");
            }
        }
    }

    private static void rotate(int startX, int startY, int rotateSize) {
        int[][] tmp = new int[rotateSize][rotateSize];
        for (int i = 0; i < rotateSize; i++) {
            for (int j = 0; j < rotateSize; j++) {
                tmp[i][j] = graph[startX + rotateSize - j - 1][startY + i];
            }
        }

        for (int i = 0; i < rotateSize; i++) {
            for (int j = 0; j < rotateSize; j++) {
                graph[startX + i][startY + j] = tmp[i][j];
            }
        }
    }

    private static void melt() {
        boolean[][] check = new boolean[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if(graph[i][j] == 0) continue;
                int count = 0;
                for (int d = 0; d < 4; d++) {
                    int mx = i + dx[d];
                    int my = j + dy[d];
                    if(mx < 0 || mx >= size || my < 0 || my >= size) continue;
                    if(graph[mx][my] > 0) count++;
                }

                if(count < 3) check[i][j] = true;
            }
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if(check[i][j]) graph[i][j]--;
            }
        }
    }

    private static void bfs(int i, int j) {
        Queue<int[]> q = new ArrayDeque<>();
        visited[i][j] = true;
        q.add(new int[] {i, j});
        sum += graph[i][j];
        int count = 1;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int d = 0; d < 4; d++) {
                int mx = cur[0] + dx[d];
                int my = cur[1] + dy[d];

                if(mx < 0 || mx >= size || my < 0 || my >= size) continue;
                if(visited[mx][my] || graph[mx][my] == 0) continue;
                visited[mx][my] = true;
                q.add(new int[] {mx, my});
                sum += graph[mx][my];
                count++;
            }
        }

        bigIce = Math.max(bigIce, count);
    }
}