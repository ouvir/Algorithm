import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static int N, K, P, X;
    private static final int ALL_BIT = 0b1111111;
    private static int[][] graph;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        graph =  new int[10][10];

        // LED의 bit로 초기화
        int[] LED = new int[10];
        LED[0] = 0b1111110;
        LED[1] = 0b0000110;
        LED[2] = 0b1011011;
        LED[3] = 0b1001111;
        LED[4] = 0b0100111;
        LED[5] = 0b1101101;
        LED[6] = 0b1111101;
        LED[7] = 0b1000110;
        LED[8] = 0b1111111;
        LED[9] = 0b1101111;

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                graph[i][j] = Integer.bitCount((LED[i] ^ LED[j]) & ALL_BIT);
            }
        }

        int[] baseCh = setSameLength(X);

        int result = 0;

        for(int ch = 1; ch <= N; ch++) { // 층수
            // 층수 계산
            int[] tmpCh = setSameLength(ch);

            int value = countChange(baseCh, tmpCh);
            if(value <= P) result++;
        }

        System.out.println(result-1);
    }

    private static int countChange(int[] baseCh, int[] tmpCh) {
        int count = 0;
        for(int i = 0; i < K; i++) {
            count += graph[baseCh[i]][tmpCh[i]];
        }
        return count;
    }

    private static int[] setSameLength(int num) {
        int[] result = new int[K];

        for(int i = 0; i < K; i++) {
            result[K-1-i] = (num % 10);
            num /= 10;
        }
        return result;
    }
}