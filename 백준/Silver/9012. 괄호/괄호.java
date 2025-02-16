import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    static int N;
    static int[] graph;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());

        Stack<String> stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < line.length(); j++) {
                String s = line.substring(j, j + 1);
                if (s.equals(")") && !stack.isEmpty() && stack.peek().equals("(")) {
                    stack.pop();
                    continue;
                }
                stack.push(s);
            }

            if(!stack.isEmpty()){
                sb.append("NO\n");
            }
            else {
                sb.append("YES\n");
            }
            stack.clear();
        }

        System.out.println(sb);
    }
}
