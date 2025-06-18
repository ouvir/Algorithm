import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static final int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    private static final int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

    private static int N, M, K;
    private static int[][] fireM;
    private static int[][] fireS;
    private static int[][] fireD;
    private static int[][] fireCount;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        Queue<int[]> fireballs = new ArrayDeque<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            fireballs.add(new int[] {x-1, y-1, m, s, d});
        }

        // k번 이동 명령
        for (int k = 0; k < K; k++) {
            fireM = new int[N][N];
            fireS = new int[N][N];
            fireD = new int[N][N]; // 없(0), 1개 있(1~8), 짝(-1), 홀(-2), 섞(-3)
            fireCount = new int[N][N];


            // fireball 이동
            while(!fireballs.isEmpty()) {
                int[] fireball = fireballs.poll();
                int x = fireball[0];
                int y = fireball[1];
                int m = fireball[2];
                int s = fireball[3];
                int d = fireball[4];

                int mx = (x + dx[d] * s + 1000 * N) % N;
                int my = (y + dy[d] * s + 1000 * N) % N;

                fireCount[mx][my]++;
                fireM[mx][my] += m;
                fireS[mx][my] += s;

                if(fireD[mx][my] == 0) fireD[mx][my] = d + 1;
                else if(fireD[mx][my] > 0) {
                    if((fireD[mx][my]-1) % 2 == 0 && d % 2 == 0) fireD[mx][my] = -1;
                    else if((fireD[mx][my]-1) % 2 == 1 && d % 2 == 1) fireD[mx][my] = -2;
                    else fireD[mx][my] = -3;
                }
                else {
                    if(fireD[mx][my] == -1 && d % 2 == 1) fireD[mx][my] = -3;
                    else if(fireD[mx][my] == -2 && d % 2 == 0) fireD[mx][my] = -3;
                }
            }

            // 파이어볼 분해
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(fireCount[i][j] >= 2) {
                        int m = fireM[i][j]/5;
                        if(m==0) continue;
                        int s = fireS[i][j]/fireCount[i][j];
                        if(fireD[i][j] == -1 || fireD[i][j] == -2) {
                            fireballs.add(new int[] {i, j, m, s, 0});
                            fireballs.add(new int[] {i, j, m, s, 2});
                            fireballs.add(new int[] {i, j, m, s, 4});
                            fireballs.add(new int[] {i, j, m, s, 6});
                        } else {
                            fireballs.add(new int[] {i, j, m, s, 1});
                            fireballs.add(new int[] {i, j, m, s, 3});
                            fireballs.add(new int[] {i, j, m, s, 5});
                            fireballs.add(new int[] {i, j, m, s, 7});
                        }
                    } else if(fireCount[i][j] == 1) {
                        fireballs.add(new int[] {i, j, fireM[i][j], fireS[i][j], fireD[i][j] - 1});
                    }
                }
            }
        }

        int sum = 0;
        for (int[] fireball : fireballs) {
            sum += fireball[2];
        }

        System.out.println(sum);
    }
}