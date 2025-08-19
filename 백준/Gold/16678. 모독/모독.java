import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    private static int N;
    private static int[] scores;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        scores = new int[N];
        for (int i = 0; i < N; i++) {
            scores[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(scores);

        long result = 0L;
        int threshold = 1;

        for (int i = 0; i < N; i++) {
            if(scores[i] - threshold > 0) {
                result += scores[i] - threshold;
                threshold++;
            } else if (scores[i] - threshold == 0) {
                threshold++;
            }
        }

        System.out.println(result);
    }
}