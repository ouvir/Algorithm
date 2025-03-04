import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static final int[] dx = {1, 0, -1, 0};
	static final int[] dy = {0, 1, 0, -1};
	static int N;
	static int[][] graph;
	static boolean[][] visited;
	static int safeAreaValue;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		
		graph = new int[N][N];
		safeAreaValue = Integer.MIN_VALUE;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int c = 0; c <= 100; c++) {
			visited = new boolean[N][N];
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(graph[i][j] > c && !visited[i][j]) {
						bfs(i,j,c);
						cnt++;
					}
				}
			}
			safeAreaValue = Math.max(safeAreaValue, cnt);
		}
		System.out.println(safeAreaValue);
	}

	private static void bfs(int x, int y, int c) {
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[]{x, y});
		visited[x][y] = true;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			
			for (int i = 0; i < 4; i++) {
				int mx = cur[0] + dx[i];
				int my = cur[1] + dy[i];
				if(mx < 0 || mx >= N || my < 0 || my >= N) continue;
				if(graph[mx][my] <= c || visited[mx][my]) continue;
				visited[mx][my] = true;
				q.add(new int[] {mx, my});
			}
		}
	}

}
