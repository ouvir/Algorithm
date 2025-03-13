import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][] array;
	static boolean[] visited;
	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());

		array = new int[N][2]; // sin, ssen

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			array[i][0] = Integer.parseInt(st.nextToken());
			array[i][1] = Integer.parseInt(st.nextToken());
		}

		int output = Integer.MAX_VALUE;

		for (int i = 0; i < N; i++) {
			output = Math.min(output, perm(i, 0, 1, 0));
		}

		System.out.println(output);
	}

	public static int perm(int target, int depth, int sin, int ssen) {
		if (depth == N) {
			return Math.abs(sin - ssen);
		}
		if (depth == target) {
			return perm(target, depth + 1, sin * array[depth][0], ssen + array[depth][1]);
		}

		int tmp1 = perm(target, depth + 1, sin * array[depth][0], ssen + array[depth][1]);
		int tmp2 = perm(target, depth + 1, sin, ssen);

		return Math.min(tmp1, tmp2);
	}
}