import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] cats = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) cats[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(cats);
        int start = 0;
        int end = N - 1;
        int count = 0;

        while (start < end) {
            if (cats[start] + cats[end] <= K) {
                count++;
                start++;
                end--;
            }
            else {
                end--;
            }
        }

        System.out.println(count);
    }
}