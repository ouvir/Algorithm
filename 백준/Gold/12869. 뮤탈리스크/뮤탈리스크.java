import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static final int[] damage = new int[]{9, 3, 1};
    private static int N;
    private static int[] order;
    private static boolean[] visited;
    private static Queue<int[]> q;
    private static int[] curCSV;
    private static boolean[][][] visitedSCV;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        order = new int[N];
        visited = new boolean[N];
        curCSV = new int[N];
        visitedSCV = new boolean[61][61][61];
        int[] SCV = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            SCV[i] = Integer.parseInt(st.nextToken());
        }
        q = new ArrayDeque<>();
        q.add(SCV);

        int count = 0;
        loop:
        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                if (isAllDie(cur)) {
                    break loop;
                }
                curCSV = cur.clone();
                perm(0);
            }
            count++;
        }

        System.out.println(count);
    }

    private static void perm(int depth) {
        if (depth == N) {
            int[] tmp = curCSV.clone();

            for (int i = 0; i < N; i++) {
                tmp[order[i]] = Math.max(0, tmp[order[i]] - damage[i]);
            }

            int a = N > 0 ? tmp[0] : 0;
            int b = N > 1 ? tmp[1] : 0;
            int c = N > 2 ? tmp[2] : 0;

            if (visitedSCV[a][b][c]) return;
            visitedSCV[a][b][c] = true;

            q.add(tmp);
            return;
        }
        for (int i = 0; i < N; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            order[depth] = i;
            perm(depth + 1);
            visited[i] = false;
            order[depth] = 0;
        }
    }

    private static boolean isAllDie(int[] cur) {
        for (int i = 0; i < N; i++) {
            if (cur[i] > 0) return false;
        }
        return true;
    }
}