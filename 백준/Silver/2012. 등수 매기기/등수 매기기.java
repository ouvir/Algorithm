import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] count = new int[500001];

        for (int i = 0; i < N; i++) {
            count[Integer.parseInt(br.readLine())]++;
        }

        long output = 0;
        int rank = 1;

        for (int i = 1; i <= 500000; i++) {
            while(count[i] > 0) {
                output += Math.abs(rank - i);
                count[i]--;
                rank++;
            }
        }
        System.out.println(output);
    }
}