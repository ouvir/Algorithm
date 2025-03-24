import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[] graph = new int[N];

		for (int i = 0; i < N; i++) {
			graph[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(graph);

		long output = 0;
		for (int i = 1; i <= N; i++) {
			output += Math.abs(i - graph[i - 1]);
		}
		System.out.println(output);
	}
}