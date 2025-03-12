import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] nums;
    static int[][] seg;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        nums = new int[N+1];
        seg = new int[4 * N][2];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N+1; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        initSeg(1,1,N);
        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if(a == 1) {
                update(1,1,N,b,c);
            }
            else if(a == 2) {
                int[] tmp = print(1,1,N,b,c);
                sb.append((long)tmp[0] + (long)tmp[1]).append('\n');
            }
        }

        System.out.print(sb);
    }

    private static int[] initSeg(int node, int start, int end) {
        if(start == end) {
            seg[node][0] = nums[start];
            seg[node][1] = 0;
            return seg[node];
        }
        else {
            int[] tmp = initSeg(node * 2, start, (start + end)/2);
            int[] tmp2 = initSeg(node * 2 + 1, (start + end)/2 + 1, end);

            int[] max = new int[2];

            for (int i = 0; i < 2; i++) {
                if(max[0] <= tmp[i]) {
                    max[1] = max[0];
                    max[0] = tmp[i];
                }
                else if(max[1] < tmp[i]) {
                    max[1] = tmp[i];
                }

                if(max[0] <= tmp2[i]) {
                    max[1] = max[0];
                    max[0] = tmp2[i];
                }
                else if(max[1] < tmp2[i]) {
                    max[1] = tmp2[i];
                }
            }

            seg[node][0] = max[0];
            seg[node][1] = max[1];
            return seg[node];
        }
    }

    private static int[] update(int node, int start, int end, int idx, int value) {
        if(start > idx || end < idx) {
            return seg[node];
        }
        if(start == end) {
            seg[node][0] = value;
            seg[node][1] = 0;
            return seg[node];
        }
        int[] tmp = update(node * 2, start, (start + end)/2, idx, value);
        int[] tmp2 = update(node * 2 + 1, (start + end)/2 + 1, end, idx, value);

        int[] max = new int[2];

        for (int i = 0; i < 2; i++) {
            if(max[0] <= tmp[i]) {
                max[1] = max[0];
                max[0] = tmp[i];
            }
            else if(max[1] < tmp[i]) {
                max[1] = tmp[i];
            }

            if(max[0] <= tmp2[i]) {
                max[1] = max[0];
                max[0] = tmp2[i];
            }
            else if(max[1] < tmp2[i]) {
                max[1] = tmp2[i];
            }
        }

        seg[node][0] = max[0];
        seg[node][1] = max[1];
        return seg[node];
    }

    private static int[] print(int node, int start, int end, long left, long right) {
        if(right < start || left > end) {
            return new int[] {0, 0};
        }
        if(left <= start && end <= right) {
            return seg[node];
        }
        else {
            int[] tmp = print(node * 2, start, (start + end)/2, left, right);
            int[] tmp2 = print(node * 2 + 1, (start + end)/2 + 1, end, left, right);

            int[] max = new int[2];

            for (int i = 0; i < 2; i++) {
                if(max[0] <= tmp[i]) {
                    max[1] = max[0];
                    max[0] = tmp[i];
                }
                else if(max[1] < tmp[i]) {
                    max[1] = tmp[i];
                }
            }
            for (int i = 0; i < 2; i++) {
                if(max[0] <= tmp2[i]) {
                    max[1] = max[0];
                    max[0] = tmp2[i];
                }
                else if(max[1] < tmp2[i]) {
                    max[1] = tmp2[i];
                }
            }

            return max;
        }
    }

}