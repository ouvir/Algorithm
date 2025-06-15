import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static final int[] dx = {-1000, 0, -1, -1, -1, 0, 1, 1, 1};
    private static final int[] dy = {-1000, -1, -1, 0, 1, 1, 1, 0, -1};

    private static final int[] diagX = {1, 1, -1 , -1};
    private static final int[] diagY = {1, -1, 1 , -1};

    private static int N;
    private static int M;
    private static int[][] graph;
    private static boolean[][] cloud;
    private static boolean[][] isDeleteCloud;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[N][N];
        cloud = new boolean[N][N];
        isDeleteCloud = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        cloud[N-1][0] = true;
        cloud[N-1][1] = true;
        cloud[N-2][0] = true;
        cloud[N-2][1] = true;

        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());

            // 모든 구름 d 방향으로 s 만큼 움직이기
            moveCloud(d, s);

            // 비 내리기
            rain();
            
            // 구름 없어짐
            deleteCloud();

            // 물 복사 버그 마법
            magic();

            // 구름 생성
            createCloud();
            
            // 초기화
            isDeleteCloud = new boolean[N][N];
        }

        int sum = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sum += graph[i][j];
            }
        }

        System.out.println(sum);
    }

    private static void createCloud() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(graph[i][j] >= 2 && !isDeleteCloud[i][j]) {
                    cloud[i][j] = true;
                    graph[i][j] -= 2;
                }
            }
        }
    }

    private static void magic() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (isDeleteCloud[i][j]) {
                    int count = 0;
                    for (int d = 0 ; d < 4; d++) {
                        int mx = i + diagX[d];
                        int my = j + diagY[d];

                        if(mx < 0 || mx >= N || my < 0 || my >= N) continue;
                        if(graph[mx][my] > 0) count++;
                    }
                    graph[i][j] += count;
                }
            }
        }
    }

    private static void deleteCloud() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (cloud[i][j]) {
                    isDeleteCloud[i][j] = true;
                }
            }
        }

        cloud = new boolean[N][N];
    }

    private static void rain() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (cloud[i][j]) {
                    graph[i][j] += 1;
                }
            }
        }
    }

    private static void moveCloud(int d, int s) {
        boolean[][] newCloud = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (cloud[i][j]) {
                    int mx = (i + dx[d] * s + 50 * N) % N;
                    int my = (j + dy[d] * s + 50 * N) % N;
                    newCloud[mx][my] = true;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                cloud[i][j] = newCloud[i][j];
            }
        }
    }
}
