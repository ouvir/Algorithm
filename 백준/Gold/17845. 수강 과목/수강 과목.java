import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[][] subjects = new int[K+1][2];
		
		for (int i = 1; i < K+1; i++) {
			st = new StringTokenizer(br.readLine());
			subjects[i][0] = Integer.parseInt(st.nextToken()); // 중요도
			subjects[i][1] = Integer.parseInt(st.nextToken()); // 공부 시간
		}
		
		int[][] dp = new int[N+1][K+1]; 
		// dp[i][j] = i 라는 공부 시간 한계에서 j개의 과목수를 이용해 얻은 중요도 최대값
		
		for (int j = 1; j < K+1; j++) {
			for (int i = 1; i < N+1; i++) {
				if(subjects[j][1] <= i) {
					dp[i][j] = Math.max(dp[i][j-1], dp[i-subjects[j][1]][j-1] + subjects[j][0]);
				} else {
					dp[i][j] = dp[i][j-1];
				}
			}
		}

		System.out.println(dp[N][K]);
	}
}
