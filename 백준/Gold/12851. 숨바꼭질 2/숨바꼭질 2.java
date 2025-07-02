import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static final int MAX_POS = 100000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] visited = new int[MAX_POS + 1];
        Arrays.fill(visited, Integer.MAX_VALUE);

        int time = Integer.MAX_VALUE;
        int count = 0;

        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] {N, 0});
        visited[N] = 0;

        while(!q.isEmpty()) {
            int[] cur = q.poll();

            if(cur[0] == K) {
                if(time > cur[1]) {
                    time = cur[1];
                    count = 1;
                }else if(time == cur[1]) {
                    count++;
                }
                continue;
            }

            if(cur[0] + 1 <= MAX_POS && visited[cur[0] + 1] >= cur[1] + 1) {
                q.add(new int[] {cur[0] + 1, cur[1] + 1});
                visited[cur[0] + 1] = cur[1] + 1;
            }

            if(cur[0] - 1 >= 0 && visited[cur[0] - 1] >= cur[1] + 1) {
                q.add(new int[] {cur[0] - 1, cur[1] + 1});
                visited[cur[0] - 1] = cur[1] + 1;
            }
            if(cur[0] * 2 <= MAX_POS && visited[cur[0] * 2] >= cur[1] + 1) {
                q.add(new int[] {cur[0] * 2, cur[1] + 1});
                visited[cur[0] * 2] = cur[1] + 1;
            }
        }

        System.out.println(time);
        System.out.println(count);
    }
}