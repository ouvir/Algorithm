import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
    static int N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        String leg = "*" + " ".repeat(N-2) +"*";
        String mid = leg + " ".repeat(N-2) +"*";

        // 상층부
        sb.append("*".repeat(N) + " ".repeat((N-1)*2 - 1) + "*".repeat(N) + "\n");
        for (int i = 1; i < N - 1; i++) {
            sb.append(" ".repeat(i) + leg + " ".repeat((N - i - 1)*2 - 1) + leg + "\n");
        }
        // 중층부
        sb.append(" ".repeat(N-1) + mid + "\n");

        // 하층부
        for (int i = 1; i < N - 1; i++) {
            sb.append(" ".repeat(N-i-1) + leg + " ".repeat((i)*2 - 1) + leg + "\n");
        }
        sb.append("*".repeat(N) + " ".repeat((N-1)*2 - 1) + "*".repeat(N)+ "\n");
        System.out.println(sb.toString());
    }
}