import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int[][] graph;
    static int[][] allVirus;
    static int[][] selected;
    static int vCount;
    static int output;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[N][N];
        selected = new int[M][2];
        allVirus = new int[10][2];
        vCount = 0;
        output = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                if(graph[i][j] == 2) {
                    allVirus[vCount][0] = i;
                    allVirus[vCount++][1] = j;
                }
            }
        }

        combi(0, 0);

        if(output == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(output - 1);
        }
    }

    private static void combi(int depth, int start) {
        if(depth == M) {
            int time = bfs();
            output = Math.min(output, time);
            return;
        }

        for (int i = start; i < vCount; i++) {
            selected[depth][0] = allVirus[i][0];
            selected[depth][1] = allVirus[i][1];

            combi(depth + 1, i+1);
        }
    }

    private static int bfs() {
        int[][] tmp = new int[N][N];

        // deepcopy
        for (int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(graph[i][j] == 2) tmp[i][j] = 0; // 바이러스 가능 공간도 0 으로 수정
                else if(graph[i][j] == 1) tmp[i][j] = -1; // 벽을 -1 로 수정
                else tmp[i][j] = graph[i][j];
            }
        }

        Queue<int[]> q = new ArrayDeque<>();
        for (int i = 0; i < M; i++) {
            q.add(new int[]{selected[i][0], selected[i][1], 1}); // x, y, t
            tmp[selected[i][0]][selected[i][1]] = 1;
        }

        while(!q.isEmpty()) {
            int[] cur = q.poll();

            for(int i = 0; i < 4; i++) {
                int mx = cur[0] + dx[i];
                int my = cur[1] + dy[i];

                if(mx < 0 || my < 0 || mx >= N || my >= N) continue;
                if(tmp[mx][my] == -1 || tmp[mx][my] > 0) continue;
                tmp[mx][my] = cur[2] + 1;
                q.add(new int[]{mx, my, cur[2] + 1});
            }
        }

        // 바이러스가 전체로 다 퍼졌는지 확인
        int time = 0;

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(tmp[i][j] == 0) { // 다 퍼진게 아니라면 max 값 리턴
                    return Integer.MAX_VALUE;
                }
                time = Math.max(time, tmp[i][j]);
            }
        }

        return time;
    }
}

