import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Deque<Integer> stack = new ArrayDeque<>();
        int count = 0;
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < line.length(); j++) {
                int value = line.charAt(j) - 'A';
                if (!stack.isEmpty() && stack.peek() == value) {
                    stack.pop();
                    continue;
                }
                stack.push(value);
            }
            if (stack.isEmpty()) {
                count++;
            }
            stack.clear();
        }
        System.out.println(count);
    }
}
