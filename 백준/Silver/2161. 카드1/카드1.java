import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Deque<Integer> q = new ArrayDeque<>();

        int N = Integer.parseInt(br.readLine());
        for (int i = 1; i < N + 1; i++) {
            q.offer(i);
        }
        while (q.size() != 1) {
            bw.write(q.poll() + " ");
            q.offer(q.poll());
        }
        bw.write(q.poll() + " ");
        bw.flush();
        br.close();
        bw.close();
    }
}