import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    static String[] words;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        words = new String[N];

        for (int i = 0; i < N; i++) {
            words[i] = br.readLine();
        }

        int max = -1;
        int a = 0;
        int b = 0;

        for (int i = 0; i < N-1; i++) {
            for (int j = i+1; j < N; j++) {
                int count = calculateSamePrefixLength(i, j);
                if(count > max) {
                    max = count;
                    a = i;
                    b = j;
                }
            }
        }

        System.out.println(words[a]);
        System.out.println(words[b]);
    }

    private static int calculateSamePrefixLength(int i1, int i2) {
        String a = words[i1];
        String b = words[i2];

        int count = 0;
        int N = Math.min(a.length(), b.length());
        for (int i = 0; i < N; i++) {
            if(a.charAt(i) != b.charAt(i)) {
                break;
            }
            count++;
        }
        return count;
    }


}