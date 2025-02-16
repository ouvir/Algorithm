import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    static int N;
    static char[] graph;
    static int[] nums;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        String line = br.readLine();
        graph = new char[line.length()];
        int maxAlpha = 0;
        for (int i = 0; i < line.length(); i++) {
            graph[i] = line.charAt(i);
            if (graph[i] - 'A' >= 0 && graph[i] - 'Z' <= 0) {
                maxAlpha = Math.max(maxAlpha, graph[i] - 'A');
            }
        }

        nums = new int[maxAlpha + 1];

        for (int i = 0; i < maxAlpha + 1; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        double tmp = 0;
        Stack<Double> stack = new Stack<>();
        for (char c : graph) {
            if (c - 'A' >= 0 && c - 'Z' <= 0) {
                stack.push((double) nums[c - 'A']);
            } else {
                double b = stack.pop();
                double a = stack.pop();
                if (c == '+') {
                    stack.push(a + b);
                } else if ( c == '-') {
                    stack.push(a - b);
                } else if ( c == '*') {
                    stack.push(a * b);
                } else if ( c == '/') {
                    stack.push(a / b);
                }
            }
        }
        System.out.printf("%.2f", stack.pop());
    }
}
