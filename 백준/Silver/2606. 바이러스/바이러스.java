import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        graph = new ArrayList[N+1];

        // 초기화
        for (int i = 1; i < N+1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        System.out.print(bfs(1));
    }

    private static int bfs(int start) {
        int count = 0; // 감염시킨 컴퓨터 수
        Queue<Integer> q = new ArrayDeque<>();
        visited = new boolean[N+1];
        q.add(start);
        visited[start] = true;

        while(!q.isEmpty()) {
            int cur = q.poll();
            for(int next : graph[cur]) {
                if(visited[next]) continue;
                visited[next] = true;
                count++;
                q.add(next);
            }
        }
        return count;
    }

}