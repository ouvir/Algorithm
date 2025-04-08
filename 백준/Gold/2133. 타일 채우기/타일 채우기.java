import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static long[] graph = new long[31];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		graph[0] = 1;
		graph[2] = 3;
		for (int i = 4; i < N + 1; i+=2) {
			// An = An-2 + An-4 + ... + A0
			graph[i] = 3*graph[i-2];
			// 나머지 수열 에 대한 합으로 생각
			for (int j = 2; 2 * j <= i; j += 1) {
				graph[i] += 2 * graph[i-j*2];
			}     
		}
		System.out.println(graph[N]);
	}
}