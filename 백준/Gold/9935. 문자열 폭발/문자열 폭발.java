import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String text = br.readLine();
        String pattern = br.readLine();
        char[] t = text.toCharArray();
        char[] p = pattern.toCharArray();

        int n = t.length;
        int m = p.length;

        char[] stack = new char[n];
        int top = 0;

        for (int i = 0; i < n; i++) {
            stack[top++] = t[i];

            if (top >= m) {
                boolean match = true;
                for (int j = 0; j < m; j++) {
                    if (stack[top - m + j] != p[j]) {
                        match = false;
                        break;
                    }
                }
                if (match) top -= m;  // m글자 제거
            }
        }

        if (top == 0) {
            System.out.println("FRULA");
        } else {
            // 0 .. top-1 까지 결과 출력
            System.out.println(new String(stack, 0, top));
        }
    }
}
