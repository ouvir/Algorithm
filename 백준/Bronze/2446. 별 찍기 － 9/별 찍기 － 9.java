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
        graph = new int[2 * N - 1][2 * N - 1];

        for (int i = 0; i < 2 * N - 1; i++) {
            for( int j = 0; j < -Math.abs(i-(N-1)) + (N-1); j++) {
                sb.append(space);
            }
            for (int j = -Math.abs(i - (N - 1)) + N - 1; j < Math.abs(i - (N - 1)) + N; j++) {
                sb.append(asterisk);
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }
}
