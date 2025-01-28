import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    static final String asterisk = "*";
    static final String space = " ";

    public static void main(String[] args) throws Exception {
        int[][] graph;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        graph = new int[2 * N - 1][2 * N];

        for (int i = 0; i < 2 * N - 1; i++) {
            for (int j = N - Math.abs(N - 1 - i); j < Math.abs(N-1 - i) + N; j++) {
                graph[i][j] = 1;
            }
        }

        for (int i = 0; i < 2 * N - 1; i++) {
            for (int j = 0; j < 2 * N; j++) {
                if (graph[i][j] == 1) {
                    sb.append(space);
                } else {
                    sb.append(asterisk);
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
