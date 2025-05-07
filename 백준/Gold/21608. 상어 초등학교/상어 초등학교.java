import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] graph;
    static int[][] scoreCount;
    static int[][] emptyCount;
    static boolean[][] infos;
    static int[] order;
    static final int[] dx = {1, 0, -1, 0};
    static final int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        infos = new boolean[N * N + 1][N * N + 1];
        order = new int[N*N];
        graph = new int[N][N];

        for (int i = 0; i < N * N; i++) {
            st = new StringTokenizer(br.readLine());
            order[i] = Integer.parseInt(st.nextToken());
            for (int j = 0; j < 4; j++) {
                infos[order[i]][Integer.parseInt(st.nextToken())] = true;
            }
        }

        // 1. 모두 자리 배치
        for (int p = 0; p < N * N; p++) {
            // i 친구 자리 배치
            scoreCount = new int[N][N];
            emptyCount = new int[N][N];

            // a. 점수 부여
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    int score = 0;
                    // 4방 확인해서 점수 부여
                    for (int k = 0; k < 4; k++) {
                        int mx = i + dx[k];
                        int my = j + dy[k];
                        if (mx < 0 || mx >= N || my < 0 || my >= N) continue;
                        if (infos[order[p]][graph[mx][my]]) score++;
                        if(graph[mx][my] == 0) emptyCount[i][j]++;
                    }

                    scoreCount[i][j] = score;
                }
            }

            // b. 자리 배치
            int tx = 0;
            int ty = 0;
            int maxScore = -1;
            int maxEmpty = -1;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (graph[i][j] > 0) continue;
                    if (scoreCount[i][j] > maxScore) {
                        tx = i;
                        ty = j;
                        maxScore = scoreCount[i][j];
                        maxEmpty = emptyCount[i][j];
                    } else if (scoreCount[i][j] == maxScore && emptyCount[i][j] > maxEmpty) {
                        tx = i;
                        ty = j;
                        maxEmpty = emptyCount[i][j];
                    }
                }
            }

            graph[tx][ty] = order[p];
        }

        // 2. 만족도 조사
        int sum = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int tmp = 0;
                for (int k = 0; k < 4; k++) {
                    int mx = i + dx[k];
                    int my = j + dy[k];
                    if(mx < 0 || mx >= N || my < 0 || my >= N) continue;
                    if(infos[graph[i][j]][graph[mx][my]]) tmp++;
                }

                if(tmp == 1) sum += 1;
                else if(tmp == 2) sum += 10;
                else if(tmp == 3) sum += 100;
                else if(tmp == 4) sum += 1000;
            }
        }
        System.out.println(sum);
    }
}
