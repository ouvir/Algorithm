import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
//  valid 필요 조건
//  1. 번갈아가면서 -> 카운트 수가 같거나 x가 1더 큼
//  2. 3개가 된 애가 있거나 모든 칸이 다 참
    private static char[][] graph;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String answer = br.readLine();

        while (!answer.equals("end")) {
            char[] data = answer.toCharArray();

            if (calc(data)) {
                sb.append("valid");
            } else {
                sb.append("invalid");
            }

            sb.append("\n");
            answer = br.readLine();
        }

        System.out.print(sb);
    }

    private static boolean calc(char[] data) {
        graph = new char[3][3];
        int oCount = 0;
        int xCount = 0;
        int blank = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                graph[i][j] = data[i * 3 + j];
                if (graph[i][j] == 'O') oCount++;
                else if (graph[i][j] == 'X') xCount++;
                else blank++;
            }
        }

        int diff = xCount - oCount;

        boolean xWin = check('X');
        boolean oWin = check('O');

        // O와 X 동시 이기는 경우(없음)
        if(xWin && oWin) return false;

        // X 만 이기는 경우(diff가 1)
        if(diff == 1 && xWin) return true;

        // O 만 이기는 경우(diff가 0)
        if(diff == 0 && oWin) return true;

        // 무승부(모든 칸이 차 있는 경우)
        if(diff == 1 && blank == 0 && !oWin) return true;

        return false;
    }

    private static boolean check(char c) {
        // 가로 세로
        for (int i = 0; i < 3; i++) {
            if (graph[i][0] == c && graph[i][1] == c && graph[i][2] == c) return true;
            if (graph[0][i] == c && graph[1][i] == c && graph[2][i] == c) return true;
        }

        // 대각선
        if (graph[0][0] == c && graph[1][1] == c && graph[2][2] == c) return true;
        if (graph[0][2] == c && graph[1][1] == c && graph[2][0] == c) return true;

        return false;
    }
}