import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int[] nums;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        nums = new int[M];
        visited = new boolean[N + 1];
        perm(0, 1);
        System.out.print(sb);
    }

    private static void perm(int depth, int start) {
        if(depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(nums[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i <= N; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            nums[depth] = i;
            perm(depth + 1, i + 1);
            visited[i] = false;
        }
    }

}