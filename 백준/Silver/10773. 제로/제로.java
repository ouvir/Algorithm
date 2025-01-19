import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        int temp;
        long total = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();

        int K = Integer.parseInt(br.readLine());

        for (int i = 0; i < K; i++) {
            temp = Integer.parseInt(br.readLine());
            if (temp == 0) {
                if (!stack.isEmpty()) {
                    total -= stack.pop();
                }
            } else {
                total += temp;
                stack.push(temp);
            }
        }
        br.close();
        System.out.println(total);
    }
}