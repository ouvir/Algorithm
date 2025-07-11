import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static final int[] dx = {1, 0, -1, 0};
	static final int[] dy = {0, 1, 0, -1};
	
	static int N;
	static int[][] distance;
	static int[][] graph;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int count = 1;
		StringTokenizer st;

		
		while(true) {
			N = Integer.parseInt(br.readLine());
			if (N==0) break;
			
			graph = new int[N][N];
			distance = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				Arrays.fill(distance[i], Integer.MAX_VALUE / 100);
			}
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					graph[i][j] = Integer.parseInt(st.nextToken());
					
				}
			}
			
			dijkstra(0,0);
			
			sb.append("Problem ").append(count++).append(": ").append(distance[N-1][N-1]).append("\n");
		}
		System.out.print(sb);
	}
	
	public static void dijkstra(int i, int j) {
		PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[2], o2[2]));
		q.offer(new int[] {i, j, graph[i][j]});
		distance[i][j] = graph[i][j];
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			
			if(cur[0] == N-1 && cur[1] == N-1) continue;
			if(cur[2] > distance[cur[0]][cur[1]]) continue;
			
			for (int k = 0; k < 4; k++) {
				int mx = cur[0] + dx[k];
				int my = cur[1] + dy[k];
				
				if(mx < 0 || mx >= N || my < 0 || my >= N) continue;
				if(distance[mx][my] > graph[mx][my] + cur[2]) {
					distance[mx][my] = graph[mx][my] + cur[2];
					q.offer(new int[] {mx,my,distance[mx][my]});
				}
			}
		}
	}
}