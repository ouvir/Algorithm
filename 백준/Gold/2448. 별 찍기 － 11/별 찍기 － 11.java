import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    static final String asterisk = "*";
    static final String space = " ";
    static int[][] graph;
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        graph = new int[N][2 * N - 1];

        // 삼각형 만들기
        for (int i = 0; i < N; i++) {
            for (int j = N - i - 1; j < N + i; j++) {
                graph[i][j] = 1;
            }
        }

        // 재귀
        recursive(N, 0, 0);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 2 * N - 1; j++) {
                if (graph[i][j] == 1) {
                    sb.append(asterisk);
                } else {
                    sb.append(space);
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void recursive(int n, int x, int y) {
        if (n == 3) {
            for (int i = x + 1; i < x + 2; i++) {
                for (int j = y + 2; j < y + 3; j++) {
                    graph[i][j] = 0;
                }
            }
            return;
        }

        // work
        for (int i = x + n / 2; i < x + n; i++) {
            for (int j = y + i - x; j < y + 2 * n - 1 - (i - x); j++) {
                graph[i][j] = 0;
            }
        }

        // recursive
        recursive(n / 2, x + n / 2, y);
        recursive(n / 2, x, y + n / 2);
        recursive(n / 2, x + n / 2, y + n);
    }
}
