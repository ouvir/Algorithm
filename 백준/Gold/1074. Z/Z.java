import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long r = Integer.parseInt(st.nextToken());
        long c = Integer.parseInt(st.nextToken());

        long M;
        // find M
        while (true) {
            M = (long) Math.pow(2, N);
            if (M > r && M > c) {
                break;
            }
            N -= 1;
        }

        System.out.println(recursive(r, c, M, 0));
    }

    private static long recursive(long r, long c, long m, long total) {
        if (m == 1) {
            return total;
        }

        long k = m / 2;
        if (r < k) {
            if (c < k) {
                total += 0;
            } else {
                c -= k;
                total += k * k;
            }
        } else {
            if (c < k) {
                r -= k;
                total += k * k * 2;
            } else {
                r -= k;
                c -= k;
                total += k * k * 3;
            }
        }
        return recursive(r, c, k, total);
    }

}