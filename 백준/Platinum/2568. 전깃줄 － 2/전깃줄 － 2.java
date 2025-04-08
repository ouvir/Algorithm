import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		final int P = 500_000;
		
		int[] count = new int[P+1];
		int[] nums = new int[N]; 
		int[] LIS = new int[N]; // 이분 탐색용 배열
		int[] IDX = new int[N]; // 역추적용 배열
		Map<Integer, Integer> valueA = new HashMap<>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			count[a] = b;
			valueA.put(b, a);
		}
		
		int c = 0;
		for (int i = 0; i < P+1; i++) {
			if(count[i] != 0) nums[c++] = count[i]; 
		}
		
		
		int size = 0;
		for (int i = 0; i < N; i++) {
			int pos = Arrays.binarySearch(LIS, 0, size,nums[i]);
			if(pos >= 0) return;
			
			pos = Math.abs(pos) - 1;
			
			LIS[pos] = nums[i];
			if(size == pos) {
				size++;
			}
			IDX[i] = pos;
		}
		
		c = size - 1;
		ArrayDeque<Integer> target = new ArrayDeque<>();
		
		for (int i = N-1; i >= 0; i--) {
			if(IDX[i] == c) {
				c--;
			} else {
				target.addFirst(valueA.get(nums[i]));
			}
		}
		
		sb.append(N-size).append("\n");
		
		for (int t : target) {
			sb.append(t).append("\n");
		}
		System.out.print(sb);
	}
}
