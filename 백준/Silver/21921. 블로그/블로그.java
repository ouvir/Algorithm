import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int N, X;
    private static int[] visitCount;

    private static int durationCount;
    private static int maxVisited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        visitCount = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            visitCount[i] = Integer.parseInt(st.nextToken());
        }

        maxVisited = 0;
        int tmp = 0;
        for (int i = 0; i < X; i++) tmp += visitCount[i];

        maxVisited = tmp;
        durationCount = 1;


        // 슬라이딩 윈도우
        for (int i = X; i < N; i++) {
            tmp -= visitCount[i-X];
            tmp += visitCount[i];

            if(tmp > maxVisited) {
                maxVisited = tmp;
                durationCount = 1;
            }
            else if(tmp == maxVisited) {
                durationCount++;
            }
        }

        if(maxVisited == 0) {
            System.out.println("SAD");
        }
        else {
            System.out.println(maxVisited);
            System.out.println(durationCount);
        }

    }
}