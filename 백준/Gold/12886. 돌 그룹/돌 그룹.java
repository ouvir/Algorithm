import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    // 1. 크기가 같지 않은 2그룹 선택
    // 2. 돌의 개수가 작은 쪽 X, 큰 쪽 Y -> X의 돌의 개수를 X+X개, Y 돌의 개수를 Y-X개로
    // 3. 돌을 같은 개수로 만들 수 있다면 1, 아니면 0을 출력

    private static int A, B, C;
    private static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        int max = A + B + C + 1;
        visited = new boolean[max][max];

        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{A, B, C});
        visited[A][B] = true;

        boolean canEqual = false;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            if (cur[0] == cur[1] && cur[1] == cur[2]) {
                canEqual = true;
                break;
            }

            for (int i = 0; i < 2; i++) {
                for (int j = i + 1; j < 3; j++) {
                    if (cur[i] == cur[j]) continue;
                    if (cur[i] > cur[j]) {
                        cur[i] -= cur[j];
                        cur[j] += cur[j];
                        if (visited[cur[0]][cur[1]]) {
                            cur[i] += cur[j] / 2;
                            cur[j] -= cur[j] / 2;
                            continue;
                        }
                        visited[cur[0]][cur[1]] = true;
                        q.add(new int[]{cur[0], cur[1], cur[2]});
                        cur[i] += cur[j] / 2;
                        cur[j] -= cur[j] / 2;
                    } else {
                        cur[j] -= cur[i];
                        cur[i] += cur[i];
                        if (visited[cur[0]][cur[1]]) {
                            cur[j] += cur[i] / 2;
                            cur[i] -= cur[i] / 2;
                            continue;
                        }
                        visited[cur[0]][cur[1]] = true;
                        q.add(new int[]{cur[0], cur[1], cur[2]});
                        cur[j] += cur[i] / 2;
                        cur[i] -= cur[i] / 2;
                    }
                }
            }
        }

        if (canEqual) System.out.println(1);
        else System.out.println(0);
    }
}
