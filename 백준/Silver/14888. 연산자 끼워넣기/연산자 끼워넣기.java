import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] operators;
	static int[] nums;
	static int maxValue;
	static int minValue;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		nums = new int[N];
		operators = new int[4];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			operators[i] = Integer.parseInt(st.nextToken());
		}

		minValue = Integer.MAX_VALUE;
		maxValue = Integer.MIN_VALUE;

		// perm
		perm(0, nums[0]); // depth, value

		System.out.println(maxValue);
		System.out.println(minValue);
	}

	static void perm(int depth, int value) {
		if (depth == N - 1) {
			minValue = Math.min(minValue, value);
			maxValue = Math.max(maxValue, value);
			return;
		}

		if(operators[0] > 0) {
			operators[0]--;
			perm(depth+1, value + nums[depth+1]);
			operators[0]++;
		}
		if(operators[1] > 0) {
			operators[1]--;
			perm(depth+1, value - nums[depth+1]);
			operators[1]++;
		}
		if(operators[2] > 0) {
			operators[2]--;
			perm(depth+1, value * nums[depth+1]);
			operators[2]++;
		}
		if(operators[3] > 0) {
			operators[3]--;
			if(value < 0) {
				value *= -1;
				value /= nums[depth+1];
				value *= -1;
			} else {
				value /= nums[depth+1];
			}
			perm(depth+1, value);
			operators[3]++;
		}
		
	}
}