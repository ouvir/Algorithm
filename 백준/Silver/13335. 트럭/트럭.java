import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int N, W, L;
    private static int[] truckWeight;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        truckWeight = new int[N];
        st =  new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            truckWeight[i] = Integer.parseInt(st.nextToken());
        }

        Queue<Integer> q = new ArrayDeque<>();
        for(int i = 0; i < W; i++) q.add(0);

        int size = 0;
        int time = 0;
        int tIndex = 0;


        while(tIndex < N) {
            size -= q.poll();

            int weight = truckWeight[tIndex];

            if(size + weight <= L) {
                q.add(weight);
                size += weight;
                tIndex++;
            } else {
                q.add(0);
            }

            time++;
        }

        time += W;
        System.out.println(time);
    }
}