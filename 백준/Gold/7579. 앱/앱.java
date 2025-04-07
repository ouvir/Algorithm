import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] appMemory = new int[N+1];
		int[] appCost = new int[N+1];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < N+1; i++) {
			appMemory[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < N+1; i++) {
			appCost[i] = Integer.parseInt(st.nextToken());
		}
		
		int[][] dp = new int[N+1][10001]; 
		// dp[n][k] =n개의 앱들 중 k 비용을 소모해서 만들 수 있는 최대 메모리
		
		for (int i = 1; i < N+1; i++) {
			for (int j = 0; j < 10001; j++) {
				if(j >= appCost[i]) {
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-appCost[i]] + appMemory[i]);
				} else {
					dp[i][j] = dp[i-1][j]; 
				}
			}
		}

		for (int i = 0; i < 10001; i++) {
			if(dp[N][i] >= M) {
				System.out.println(i);
				break;
			}
		}
	}
}
