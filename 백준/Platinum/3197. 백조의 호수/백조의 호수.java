import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static final int[] dx = {1, 0, -1, 0};
	static final int[] dy = {0, 1, 0, -1};
	
	static int N;
	static int M;
	static char[][] graph;
	static int[][] counted;
	static boolean[][] visited;
	static int[][] swans = new int[2][2];;
	static Queue<int[]> q;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		graph = new char[N][M];
		counted = new int[N][M];
		
		int idx = 0;
		
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < M; j++) {
				graph[i][j] = line.charAt(j);
				if(graph[i][j] == 'L') {
					swans[idx][0] = i;
					swans[idx++][1] = j;
				}
			}
		}
		
		// 물에 대해서 bfs 돌리면서 빙판이 녹는데 걸리는 시간을 저장
		timeCount();
		// 백조끼리 만나도록 bfs 인데, 우선순위큐 사용(다익스트라인가?)
		int day = bfs(swans[0][0], swans[0][1]);

		System.out.println(day);
	}

	private static void timeCount() {
		visited = new boolean[N][M];
		
		q = new ArrayDeque<>();
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(graph[i][j] == '.' || graph[i][j] == 'L') {
					q.add(new int[] {i, j, 0});
					visited[i][j] = true;
				}
			}
		}
		
		while(!q.isEmpty()) {
			int[] pos = q.poll();
			
			for (int i = 0; i < 4; i++) {
				int mx = pos[0] + dx[i];
				int my = pos[1] + dy[i];
				if(mx < 0 || mx >= N || my < 0 || my >= M) continue;
				if(visited[mx][my] || graph[mx][my] == '.') continue;
				visited[mx][my] = true;
				if(graph[mx][my] == 'X') {
					counted[mx][my] = pos[2] + 1;
					q.add(new int[] {mx, my, pos[2] + 1});
				}
				else q.add(new int[] {mx, my, pos[2]});
			}
		}
//		System.out.println(Arrays.deepToString(counted));
	}

	private static int bfs(int x, int y) {
		visited = new boolean[N][M];
		
		q = new PriorityQueue<>((o1,o2)->Integer.compare(o1[2], o2[2]));
		q.add(new int[] {x, y, 0}); // x,y, time
		visited[x][y] = true;
		
		while(!q.isEmpty()) {
			int[] pos = q.poll();
			
			if(pos[0]==swans[1][0] && pos[1] == swans[1][1]) {
				return pos[2];
			}
			
			for (int i = 0; i < 4; i++) {
				int mx = pos[0] + dx[i];
				int my = pos[1] + dy[i];
				if(mx < 0 || mx >= N || my < 0 || my >= M) continue;
				if(visited[mx][my]) continue;
				visited[mx][my] = true;
				if(graph[mx][my] == 'X') {
					int tmp = Math.max(pos[2], counted[mx][my]);
					q.add(new int[] {mx, my, tmp});
				}
				else q.add(new int[] {mx, my, pos[2]});
			}
		}
		return -1;
	}

}