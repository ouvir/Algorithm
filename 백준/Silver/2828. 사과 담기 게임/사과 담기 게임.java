import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());

        int start = 1;
        int count = 0;
        int tmp = 0;
        int gap;
        for (int i = 0; i < K; i++) {
            tmp = Integer.parseInt(br.readLine());
            if(tmp < start) {
                gap = start - tmp;
                count += gap;
                start -= gap;
                M -= gap;
            }
            else if (tmp > M) {
                gap = tmp - M;
                count += gap;
                start += gap;
                M += gap;
            }
        }
        System.out.println(count);
    }
}
