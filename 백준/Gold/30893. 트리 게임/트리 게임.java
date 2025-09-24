import java.io.*;
import java.util.*;

public class Main {

    static int N, S, E;
    static List<Integer>[] adj;
    static boolean[] seen;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) adj[i] = new ArrayList<>();

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adj[u].add(v);
            adj[v].add(u);
        }

        // 경로가 끝나면 결국 후공 승리
        String answer = "Second";
        Queue<int[]> q = new ArrayDeque<>();
        seen = new boolean[N + 1];
        q.add(new int[]{S, 0}); // {현재 노드, 0=선공, 1=후공}
        seen[S] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int node = cur[0];
            int turn = cur[1];

            // 목표 정점 도달 → 선공 승리
            if (node == E) {
                answer = "First";
                break;
            }
            int branch = 0;
            for (int nxt : adj[node]) {
                if (!seen[nxt]) {
                    seen[nxt] = true;
                    q.add(new int[]{nxt, (turn + 1) % 2});
                    branch++;
                }
            }

            // 후공 차례에서 갈래가 2개 이상 → 후공이 최적 전략으로 승리
            if (turn == 1 && branch > 1) {
                answer = "Second";
                break;
            }
        }

        
        System.out.println(answer);
    }
}