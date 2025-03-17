import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static char[][] graph;
	static boolean[][][] visited;
	static int[][] end;
	static int endForm;
	static final int[] dx = { 1, 0, -1, 0, 1, 1, -1, -1 };
	static final int[] dy = { 0, 1, 0, -1, 1, -1, 1, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());

		graph = new char[N][N];
		visited = new boolean[N][N][2];
		int[][] train = new int[3][4]; // B, pos
		end = new int[3][2]; // E, pos
		int t_i = 0;
		int e_i = 0;
		
		
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < N; j++) {
				graph[i][j] = line.charAt(j);
				if(graph[i][j] == 'B') {
					train[t_i][0] = i;
					train[t_i][1] = j;
					t_i++;
				}
				else if(graph[i][j] == 'E') {
					end[e_i][0] = i;
					end[e_i][1] = j;
					e_i++;
				}
			}
		}
		
		
		if(end[0][1] == end[1][1]) {
			endForm = 0;
		} else {
			endForm = 1;
		}
		
		train[1][2] = 0; // depth
		
		if(train[0][1] == train[1][1]) {
			train[1][3] = 0; // form |
		} else {
			train[1][3] = 1; // form ---
		}
		
		int result = 0;
		Queue<int[]> q = new ArrayDeque<>();
		
		q.add(train[1]);
		visited[train[1][0]][train[1][1]][train[1][3]] = true;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int cx = cur[0];
			int cy = cur[1];
			int depth = cur[2];
			int form = cur[3];
			
			if(cx == end[1][0] && cy == end[1][1] && form == endForm) {
				result = depth;
				break;
			}
			
			for (int i = 0; i < 4; i++) {
				int mx = cx + dx[i];
				int my = cy + dy[i];
				
				if(check(mx, my, form)) continue;
				if(visited[mx][my][form]) continue;
				visited[mx][my][form] = true;
				q.add(new int[] {mx, my, depth+1, form});
			}
			
			if(checkTurn(cx, cy) && !visited[cx][cy][form^1]) {
				visited[cx][cy][form^1] = true;
				q.add(new int[] {cx, cy, depth+1, form^1});
			}
			
		}
		System.out.println(result);
	}



	private static boolean checkTurn(int cx, int cy) {
		// 8방 모두 확인
		for (int i = 0; i < 8; i++) {
			int mx = cx + dx[i];
			int my = cy + dy[i];
			if(mx < 0 || mx >= N || my < 0 || my >= N) return false;
			if(graph[mx][my] == '1') return false;
		}
		return true;
	}



	private static boolean check(int mx, int my, int form) {
		if(form == 0) {
			if(mx < 0 || mx >= N || my < 0 || my >= N) return true;
			if(mx - 1 < 0 || mx + 1 >= N) return true;
			if(graph[mx][my] == '1' || graph[mx-1][my] == '1' || graph[mx+1][my] == '1') return true;
			return false;
		} else {
			if(mx < 0 || mx >= N || my < 0 || my >= N) return true;
			if(my - 1 < 0 || my + 1 >= N) return true;
			if(graph[mx][my] == '1' || graph[mx][my-1] == '1' || graph[mx][my+1] == '1') return true;
			return false;
		}
	}
}
