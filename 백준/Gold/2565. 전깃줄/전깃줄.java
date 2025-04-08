import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		final int P = 500;
		
		int[] count = new int[P+1];
		int[] nums = new int[N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			count[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
		}
		
		int c = 0;
		for (int i = 0; i < P+1; i++) {
			if(count[i] != 0) nums[c++] = count[i]; 
		}
		
		int[] LIS = new int[N];
		
		int size = 0;
		for (int i = 0; i < N; i++) {
			int pos = Arrays.binarySearch(LIS, 0, size,nums[i]);
			if(pos >= 0) return;
			
			pos = Math.abs(pos) - 1;
			
			LIS[pos] = nums[i];
			if(size == pos) {
				size++;
			}
		}
		
		System.out.println(N - size);
		
	}
}
