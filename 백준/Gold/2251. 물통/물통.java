import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int A;
    static int B;
    static int C;
    static boolean[][][] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        Queue<int[]> q = new ArrayDeque<>();
        List<Integer> output = new ArrayList<>();

        visited = new boolean[A+1][B+1][C+1];
        visited[0][0][C] = true;
        q.add(new int[] {0, 0, C});

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int a = cur[0];
            int b = cur[1];
            int c = cur[2];

            if(a == 0) {
                output.add(c);
            }
            if(a != 0) {
                // 빈칸 계산
                int tmp = B-b;
                if (a < tmp && !visited[0][a+b][c]) {
                    q.add(new int[] {0, a + b, c});
                    visited[0][a+b][c] = true;
                } else if(a >= tmp && !visited[a-tmp][B][c]) {
                    q.add(new int[] {a - tmp, B, c});
                    visited[a-tmp][B][c] = true;
                }

                tmp = C-c;
                if (a < tmp && !visited[0][b][a + c]) {
                    q.add(new int[] {0, b, a + c});
                    visited[0][b][a + c] = true;
                } else if(a >= tmp && !visited[a-tmp][b][C]) {
                    q.add(new int[] {a - tmp, b, C});
                    visited[a-tmp][b][C] = true;
                }
            }
            if(b != 0) {
                // 빈칸 계산
                int tmp = A-a;
                if (b < tmp && !visited[a+b][0][c]) {
                    q.add(new int[] {a + b, 0, c});
                    visited[a+b][0][c] = true;
                } else if(b >= tmp && !visited[A][b-tmp][c]) {
                    q.add(new int[] {A, b-tmp, c});
                    visited[A][b-tmp][c] = true;
                }

                tmp = C-c;
                if (b < tmp && !visited[a][0][b + c]) {
                    q.add(new int[] {a, 0, b + c});
                    visited[a][0][b + c] = true;
                } else if(b >= tmp && !visited[a][b-tmp][C]) {
                    q.add(new int[] {a, b-tmp, C});
                    visited[a][b-tmp][C] = true;
                }
            }
            if(c != 0) {
                // 빈칸 계산
                int tmp = B-b;
                if (c < tmp && !visited[a][b+c][0]) {
                    q.add(new int[] {a, b + c, 0});
                    visited[a][b+c][0] = true;
                } else if(c >= tmp && !visited[a][B][c-tmp]) {
                    q.add(new int[] {a, B, c-tmp});
                    visited[a][B][c-tmp] = true;
                }

                tmp = A-a;
                if (c < tmp && !visited[a+c][b][0]) {
                    q.add(new int[] {a+c, b, 0});
                    visited[a+c][b][0] = true;
                } else if(c >= tmp && !visited[A][b][c-tmp]) {
                    q.add(new int[] {A, b, c - tmp});
                    visited[A][b][c-tmp] = true;
                }
            }
        }

        output.sort(Integer::compareTo);

        for(int i = 0; i < output.size(); i++) {
            sb.append(output.get(i)).append(" ");
        }
        System.out.println(sb);
    }
}