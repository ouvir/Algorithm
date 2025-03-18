// 연구소 2
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M; // N * N 연구소에 M개의 바이러스 설치
    static int lab[][];
    static ArrayList<int[]> danger; // 바이러스를 심을 수 있는 빈칸
    static boolean fullVirus[][];   // 감염 대상: 빈 칸(0)만 true
    static boolean hasVirus[][];    // 빈 칸 감염 여부를 추적 (빈 칸이 감염되면 true)
    static int selected[];          // 선택된 2의 r, c의 인덱스 (danger의 인덱스)
    static int size;
    static int dr[] = {-1, 0, 1, 0};
    static int dc[] = {0, 1, 0, -1};
    static int time;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        lab = new int[N][N];
        selected = new int[M];
        danger = new ArrayList<int[]>();
        size = 0;
        time = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                lab[i][j] = Integer.parseInt(st.nextToken());
                if (lab[i][j] == 2) {
                    danger.add(new int[] {i, j});
                }
            }
        }
        size = danger.size();

        // 감염 대상은 빈 칸(0)만
        fullVirus = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                fullVirus[i][j] = (lab[i][j] != 1);
            }
        }

        combination(0, 0);
        if (time == Integer.MAX_VALUE) time = -1;
        System.out.print(time);
    }

    private static void combination(int cnt, int start) {
        if (cnt == M) {
            time = Math.min(time, bfs(selected));
            return;
        } else {
            for (int i = start; i < size; i++) {
                selected[cnt] = i;
                combination(cnt + 1, i + 1);
            }
        }
    }

    private static int bfs(int virus[]) {
        int day = 0;
        int labCopy[][] = new int[lab.length][];
        for (int i = 0; i < lab.length; i++) {
            labCopy[i] = Arrays.copyOf(lab[i], lab[i].length);
        }

        hasVirus = new boolean[N][N];
        Queue<int[]> q = new ArrayDeque<int[]>();

        // 선택된 바이러스만 큐에 추가
        for (int i = 0; i < virus.length; i++) {
            int idx = virus[i];
            int pos[] = danger.get(idx);
            q.offer(new int[] {pos[0], pos[1]});
            hasVirus[pos[0]][pos[1]] = true;
        }

        if (Arrays.deepEquals(hasVirus, fullVirus)) {
            return day;
        }

        while (!q.isEmpty()) {
            int cnt = q.size();
            for (int i = 0; i < cnt; i++) {
                int cur[] = q.poll();

                for (int j = 0; j < 4; j++) {
                    int mr = cur[0] + dr[j];
                    int mc = cur[1] + dc[j];

                    if (mr < 0 || mr >= N || mc < 0 || mc >= N || labCopy[mr][mc] == 1) continue;
                    if (hasVirus[mr][mc]) continue;

                    if (labCopy[mr][mc] == 0 || labCopy[mr][mc] == 2) {
                        hasVirus[mr][mc] = true;
                        labCopy[mr][mc] = 3;
                        q.offer(new int[]{mr, mc});
                    }
                }
            }
            day++;
            if (Arrays.deepEquals(hasVirus, fullVirus)) {
                return day;
            }
        }

        if (Arrays.deepEquals(hasVirus, fullVirus)) {
            return day;
        }

        return Integer.MAX_VALUE;
    }
}