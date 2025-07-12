import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int output = Integer.MAX_VALUE;

        out: for (int i = 0; i < N-3; i++) {
            for (int j = N-1; j > i + 2; j--) {
                int h1 = arr[i] + arr[j]; // 눈사람1의 크기
                int start = i+1;
                int end = j-1;

                while(start < end) {
                    int h2 = arr[start] + arr[end];
                    if(h2 < h1) {
                        start++;
                    } else if(h2 > h1) {
                        end--;
                    } else {
                        output = 0;
                        break out;
                    }
                    output = Math.min(output, Math.abs(h1-h2));
                }
            }
        }

        System.out.println(output);
    }
}