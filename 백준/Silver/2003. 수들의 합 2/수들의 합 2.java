import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] graph = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            graph[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = 0;
        int count = 0;
        int sum = graph[0];

        while(start < N && end < N) {

            if(sum == M) {
                count++;
                sum -= graph[start];
                start++;
            }
            else if(sum < M) {
                end++;
                if(end < N) sum += graph[end];
            }
            else {
                sum -= graph[start];
                start++;
            }
        }

        System.out.println(count);
    }
}
