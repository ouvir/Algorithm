import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static final int[] dx = { -1, 0, 1, 0};
	static final int[] dy = { 0, 1, 0, -1};
	static int R;
	static int C;
	static int K;
	static char[][] graph;
	static boolean[][] visited;
	static int count;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		graph = new char[R][C];
		visited = new boolean[R][C];
		
		for (int i = 0; i < R; i++) {
			String line = br.readLine();
			for (int j = 0; j < C; j++) {
				graph[i][j] = line.charAt(j);
			}
		}
		
		count = 0;
		visited[R-1][0] = true;
		dfs(R-1, 0, 1); // x, y, d
		
		System.out.println(count);
	}

	public static void dfs(int x, int y, int d) {
		if(d == K) {
			if(x == 0 && y == C-1) count++;
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			int mx = x + dx[i];
			int my = y + dy[i];
			if(mx < 0 || mx >= R || my < 0 || my >= C) continue;
			if(visited[mx][my] || graph[mx][my] == 'T') continue;
			visited[mx][my] = true;
			dfs(mx, my, d+1);
			visited[mx][my] = false;
		}
		
		return;
	}
	
}
