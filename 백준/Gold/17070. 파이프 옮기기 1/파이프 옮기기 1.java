import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;

	static int[][] graph;
	static int output;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		graph = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		output = 0;
		
		dfs(0, 1, 0); // x1,y1, x2,y2, form
		System.out.println(output);
	}

	private static void dfs(int x, int y, int form) {
		if (x == N - 1 && y == N - 1 && graph[x][y] != 1) {
			output++;
			return;
		}

		int mx = x + 1;
		int my = y + 1;
		
		if (form == 0) { // - 방향
			if (!check(x, my)) {
				dfs(x, my, 0);
			}

			if (!check(mx, y) && !check(x, my) && !check(mx, my)) {
				dfs(mx, my, 1);
			}
			return;
		}
		if (form == 1) { // \ 방향
			if (!check(x, my)) {
				dfs(x, my, 0);
			}
			if (!check(mx, y)) {
				dfs(mx, y, 2);
			}
			if (!check(mx, y) && !check(x, my) && !check(mx, my)) {
				dfs(mx, my, 1);
			}
			return;
		}
		if (form == 2) { // | 방향
			if (!check(mx, y)) {
				dfs(mx, y, 2);
			}

			if (!check(mx, y) && !check(x, my) && !check(mx, my)) {
				dfs(mx, my, 1);
			}
			return;
		}
	}

	private static boolean check(int mx, int my) {
		return mx < 0 || mx >= N || my < 0 || my >= N || graph[mx][my] == 1;
	}
}