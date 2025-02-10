import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static final int[] dx = { 1, 0, -1, 0 };
	static final int[] dy = { 0, 1, 0, -1 };
	static boolean[][] visited;
	static int[][] graph;
	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());

		graph = new int[N][N];
		visited = new boolean[N][N];

		int[] output = new int[N * N];
		int size = 0;

		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < N; j++) {
				graph[i][j] = line.charAt(j) - '0';
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (graph[i][j] == 1 && !visited[i][j]) {
					output[size++] = bfs(i, j);
				}
			}
		}

		output = Arrays.copyOf(output, size);
		Arrays.sort(output);

//		sb.append(String.format("%d\n", size));
		System.out.println(size);
		for (int i = 0; i < size; i++) {
//			sb.append(String.format("%d\n", output[i]));
			System.out.println(output[i]);
		}
//		System.out.println(sb);
	}

	public static int bfs(int x, int y) {
		int output = 1;
		Queue<int[]> q = new LinkedList<>();
		visited[x][y] = true;
		q.add(new int[] { x, y });

		while (!q.isEmpty()) {
			int[] pos = q.poll();
			int cx = pos[0];
			int cy = pos[1];

			for (int i = 0; i < 4; i++) {
				int mx = cx + dx[i];
				int my = cy + dy[i];
				if (mx < 0 || mx >= N || my < 0 || my >= N)
					continue;
				if (visited[mx][my] || graph[mx][my] == 0)
					continue;
				visited[mx][my] = true;
				output += 1;
				q.add(new int[] { mx, my });
			}
		}
		return output;
	}
}