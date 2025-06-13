import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static boolean[] team;
    static int[][] graph;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        // 브루트 포스 (조합 -> 절반을 고르는 경우의 수) n P n/2
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        team = new boolean[N];
        graph = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        perm(0, 0);

        // 4. 최솟값 기억했다가 출력
        System.out.println(min);
    }

    // 1. 팀 나누기(조합)
    private static void perm(int depth, int start) {
        if(depth == N/2) {
            int ability = countAbility();
            // 3. 최솟값 업데이트
            min = Math.min(min, ability);
        }

        for (int i = start+1; i < N; i++) {
            team[i] = true;
            perm(depth+1, i);
            team[i] = false;
        }
    }

    // 2. 팀의 능력치 재기
    private static int countAbility() {
        int[] teamA = new int[N/2];
        int[] teamB = new int[N/2];
        int indexA = 0;
        int indexB = 0;
        int totalA = 0;
        int totalB = 0;
        for (int i = 0; i < N; i++) {
            if (team[i]) {
                teamA[indexA] = i;
                indexA++;
            }
            else {
                teamB[indexB] = i;
                indexB++;
            }
        }

        for (int i = 0; i < N/2 - 1; i++) {
            for (int j = i + 1; j < N/2; j++) {
                totalA += (graph[teamA[i]][teamA[j]] + graph[teamA[j]][teamA[i]]);
                totalB += (graph[teamB[i]][teamB[j]] + graph[teamB[j]][teamB[i]]);
            }
        }

        return Math.abs(totalA - totalB);
    }
}
