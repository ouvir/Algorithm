import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static int N, K;
    private static char[] graph;
    private static boolean[] eat;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        graph = new char[N];
        eat = new boolean[N];

        String line = br.readLine();
        for(int i = 0; i < N; i++) {
            graph[i] = line.charAt(i);
        }

        int count = 0;

        a: for (int i = 0; i < N; i++) {
            if (graph[i] == 'P') {
                // 앞에 찾기
                for (int j = K; j >= 1; j--) {
                    if(i-j >= 0 && graph[i-j] == 'H' && !eat[i-j]) {
                        count++;
                        eat[i-j] = true;
                        continue a;
                    }
                }
                // 뒤에 찾기
                for (int j = 1; j <= K; j++) {
                    if(i+j < N && graph[i+j] == 'H' && !eat[i+j]) {
                        count++;
                        eat[i+j] = true;
                        continue a;
                    }
                }
            }
        }
        System.out.println(count);
    }
}
