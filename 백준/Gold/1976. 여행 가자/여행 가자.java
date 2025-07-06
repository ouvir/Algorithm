import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int N, M;
    private static int[] parents;
    private static int[] plans;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        parents = new int[N+1];
        for (int i = 0; i < N+1; i++) parents[i] = i;

        for (int i = 1; i < N+1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < N+1; j++) {
                int value = Integer.parseInt(st.nextToken());
                if(value == 1) {
                    if(find(i) != find(j)) union(i, j);
                }
            }
        }
        plans = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            plans[i] = Integer.parseInt(st.nextToken());
        }

        int key = find(plans[0]);
        String output = "YES";

        for (int i = 1; i < M; i++) {
            if(find(plans[i]) != key) {
                output = "NO";
                break;
            }
        }

        System.out.println(output);
    }

    private static int find(int x) {
        if(parents[x] != x) {
            parents[x] = find(parents[x]);
        }
        return parents[x];
    }

    private static void union(int i, int j) {
        int a = find(i);
        int b = find(j);

        if(a > b) parents[b] = a;
        else parents[a] = b;
    }
}