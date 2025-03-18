import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static List<Integer>[] graph;
    static int[] indegree;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        indegree = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int count = Integer.parseInt(st.nextToken());

            int[] tmp = new int[count];
            for (int j = 0; j < count; j++) {
                tmp[j] = Integer.parseInt(st.nextToken());
            }

            for (int j = 1; j < count; j++) {
                graph[tmp[j-1]].add(tmp[j]);
                indegree[tmp[j]]++;
            }
        }

        Queue<Integer> q = new ArrayDeque<>();

        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        int count = 0;

        while (!q.isEmpty()) {
            int cur = q.poll();
            sb.append(cur).append("\n");
            count++;
            for (int next : graph[cur]) {
                indegree[next]--;
                if(indegree[next] == 0) {
                    q.add(next);
                }
            }
        }
        if(count != N) System.out.println(0);
        else System.out.print(sb);
    }
}

