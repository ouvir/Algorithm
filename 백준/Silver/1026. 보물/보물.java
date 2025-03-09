import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        int[] countA = new int[101];
        int[] countB = new int[101];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            countA[Integer.parseInt(st.nextToken())]++;
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            countB[Integer.parseInt(st.nextToken())]++;
        }

        int output = 0;
        int idxA = 0, idxB = 100;

        while (N > 0 && idxA < 101 && idxB >= 0) {
            if (countA[idxA] == 0) {
                idxA++;
                continue;
            }
            if (countB[idxB] == 0) {
                idxB--;
                continue;
            }

            output += idxA * idxB;
            countA[idxA]--;
            countB[idxB]--;
            if (countA[idxA] == 0) {
                idxA++;
            }
            if (countB[idxB] == 0) {
                idxB--;
            }
            N--;
        }

        System.out.println(output);
    }
}
