import java.util.*;
import java.io.*;

public class Main {
    private static int N, M;

    private static int[] distanceY;
    private static int[][] distanceN;
    private static final int INF = Integer.MAX_VALUE;

    private static List<int[]>[] graph;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        distanceY = new int[N+1];
        distanceN = new int[N+1][2];
        graph = new List[N+1];

        for(int i = 1; i <= N; i++) {
            distanceY[i] = INF;
            distanceN[i][0] = INF;
            distanceN[i][1] = INF;
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            graph[a].add(new int[]{b, 2 * d});
            graph[b].add(new int[]{a, 2 * d});
        }

        dijkstra();
        int count = 0;

        for(int i = 2; i <= N; i++) {
            if(distanceY[i] < Math.min(distanceN[i][0], distanceN[i][1])) count++;
        }

        System.out.println(count);
    }

    private static void dijkstra() {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (o1, o2) -> Integer.compare(o1[1], o2[1])
        );

        pq.add(new int[] {1, 0}); // start, distance
        distanceY[1] = 0;

        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            int now = cur[0];
            int d = cur[1];

            if(d > distanceY[now]) continue;

            for(int[] next : graph[now]) {
                if(distanceY[next[0]] > next[1] + d) {
                    distanceY[next[0]] = next[1] + d;
                    pq.add(new int[] {next[0], next[1] + d});
                }
            }
        }

        pq.add(new int[] {1, 0, 1}); // start, distance, flag
        distanceN[1][1] = 0;

        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            int now = cur[0];
            int d = cur[1];
            int flag = cur[2];
            int nextFlag = (flag + 1) % 2;

            if(distanceN[now][flag] < d) continue;

            for(int[] next : graph[now]) {
                int nextD = d;
                if(flag > 0) nextD += next[1] / 2;
                else nextD += next[1] * 2;

                if(distanceN[next[0]][nextFlag] > nextD) {
                    distanceN[next[0]][nextFlag] = nextD;
                    pq.add(new int[] {next[0], nextD, nextFlag});
                }
            }
        }
    }
}