import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int[] nums;
    static int[] input;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        input = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(input);

        nums = new int[M];
        visited = new boolean[N + 1];
        perm(0, 0);
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
        int curr = -1;
        for (int i = start; i < N; i++) {
            if (visited[i] || curr == input[i]) continue;
            visited[i] = true;
            nums[depth] = input[i];
            curr = input[i];
            perm(depth + 1, i + 1);
            visited[i] = false;
        }
    }

}