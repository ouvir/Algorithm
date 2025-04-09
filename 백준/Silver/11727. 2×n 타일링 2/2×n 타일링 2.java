import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int[] graph = new int[1001];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		graph[0] = 1;
		graph[1] = 1;

		for (int i = 2; i < N + 1; i++) {
			graph[i] = (graph[i - 1] + 2 * graph[i - 2]) % 10_007;
		}
		System.out.println(graph[N]);
	}
}
