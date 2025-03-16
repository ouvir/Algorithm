import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            Map<String, Integer> map = new HashMap<>();
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                st.nextToken(); // item 버리기
                String category = st.nextToken();
                map.put(category, map.getOrDefault(category, 0) + 1);
            }
            int output = 1;
            for(String key : map.keySet()) {
                output *= map.get(key) + 1;
            }
            sb.append(output - 1).append('\n');
        }

        System.out.print(sb);
    }
}