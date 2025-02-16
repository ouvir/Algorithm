import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static ArrayList[] linked;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        linked = new ArrayList[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int root = 0;

        for (int i = 0; i < N; i++) {
            linked[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < N; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            if (tmp == -1) {
                root = i;
            } else linked[tmp].add(i);
        }

        M = Integer.parseInt(br.readLine());
        if(root == M) System.out.println(0);
        else System.out.println(dfs(root));
    }
    public static int dfs(int v) {
        if(linked[v].isEmpty()) return 1;
        int output = 0;

        for (int i = 0; i < linked[v].size(); i++) {
            int next = (int) linked[v].get(i);
            if(next == M) continue;
            output += dfs(next);
        }
        if (output == 0) {
            output += 1;
        }
        return output;
    }
}
