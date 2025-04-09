import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[][] graph;
	// 2개
	static final boolean[][][] IBlock = {
									{
										{true, true, true, true}
									},
									{
										{true},
										{true},
										{true},
										{true}
									}
								};
	// true개
	static final boolean[][][] OBlock = {
									{
										{true, true}, 
										{true, true}
									}
								};
	// 8개
	static final boolean[][][] LBlock = {
									{
										{true, false},
										{true, false},
										{true, true}
									},
									{
										{false, true},
										{false, true},
										{true, true}
									},
									{
										{true, true},
										{false, true},
										{false, true}
									},
									{
										{true, true},
										{true, false},
										{true, false}
									},
									{
										{true, false, false},
										{true, true, true}
									},
									{
										{true, true, true},
										{false, false, true}
									},
									{
										{false, false, true},
										{true, true, true}
									},
									{
										{true, true, true},
										{true, false, false}
									}
								};
	// 4개
	static final boolean[][][] SBlock = {
									{
										{true, false},
										{true, true},
										{false, true}
									},
									{
										{false, true},
										{true, true},
										{true, false}
									},
									{
										{false, true, true},
										{true, true, false}
									},
									{
										{true, true, false},
										{false, true, true}
									}
								};
	// 4개
	static final boolean[][][] UBlock =  {
									{
										{true, false},
										{true, true},
										{true, false}
									},
									{
										{false, true},
										{true, true},
										{false, true}
									},
									{
										{false, true, false},
										{true, true, true}
									},
									{
										{true, true, true},
										{false, true, false}
									}
								};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); 
		M = Integer.parseInt(st.nextToken()); 
		
		graph = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int MAX = -1;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				for(boolean[][] block : IBlock) {
					if(i + block.length - 1 < N && j + block[0].length - 1 < M) {
						MAX = Math.max(MAX, calc(block, i, j));
					}
				}
				
				for(boolean[][] block : OBlock) {
					if(i + block.length - 1 < N && j + block[0].length - 1 < M) {
						MAX = Math.max(MAX, calc(block, i, j));
					}
				}
				for(boolean[][] block : LBlock) {
					if(i + block.length - 1 < N && j + block[0].length - 1 < M) {
						MAX = Math.max(MAX, calc(block, i, j));
					}
					
				}
				for(boolean[][] block : SBlock) {
					if(i + block.length - 1 < N && j + block[0].length - 1 < M) {
						MAX = Math.max(MAX, calc(block, i, j));
					}
				}
				for(boolean[][] block : UBlock) {
					if(i + block.length - 1 < N && j + block[0].length - 1 < M) {
						MAX = Math.max(MAX, calc(block, i, j));
					}
				}
			}
		}
		
		System.out.println(MAX);
	}

	private static int calc(boolean[][] block, int x, int y) {
		int value = 0;
		for (int i = 0; i < block.length; i++) {
			for (int j = 0; j < block[0].length; j++) {
				if(block[i][j]) value += graph[x+i][y+j]; 
			}
		}
		
		return value;
	}
}
