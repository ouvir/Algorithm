import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] memo = new int[41][2];
    static boolean[] visited = new boolean[41];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(br.readLine());
            int[] result = fibo(n);
            sb.append(result[0]).append(' ').append(result[1]).append("\n");
        }

        System.out.print(sb);
    }

    private static int[] fibo(int n) {
        int[] result = new int[2];
        if(n == 0) {
            result[0] = 1;
            result[1] = 0;
        } else if (n == 1) {
            result[0] = 0;
            result[1] = 1;
        }
        else if(visited[n]) {
            return memo[n];
        }
        else {
            int[] tmp1 = fibo(n - 1);
            int[] tmp2 = fibo(n - 2);

            result[0] = tmp1[0] + tmp2[0];
            result[1] = tmp1[1] + tmp2[1];
            visited[n] = true;
            memo[n][0] = result[0];
            memo[n][1] = result[1];
        }

        return result;
    }
}