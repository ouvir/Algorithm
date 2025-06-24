import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private static int N;
    private static int count;
    private static int[] graph;
    private static boolean[] isCycle;
    private static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        graph = new int[N+1];
        isCycle = new boolean[N+1];

        for (int i = 1; i <= N; i++) {
            graph[i] = Integer.parseInt(br.readLine());
        }

        count = 0;

        for(int i = 1; i <= N; i++) {
            visited = new boolean[N+1];
            checkCycle(i);
            if(visited[i]) {
                count++;
                isCycle[i] = true;
            }
        }

        sb.append(count).append("\n");
        for(int i = 1; i <= N; i++) {
            if(isCycle[i]) sb.append(i).append("\n");
        }

        System.out.print(sb);
    }

    private static void checkCycle(int cur) {
        if(!visited[graph[cur]]) {
            visited[graph[cur]] = true;
            checkCycle(graph[cur]);
        }
    }
}