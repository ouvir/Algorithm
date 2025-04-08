import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		int[] nums = new int[N];
		int[] lis = new int[N];
		int[] idx = new int[N];
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		
		int size = 0;
		for (int i = 0; i < N; i++) {
			int pos = Arrays.binarySearch(lis, 0, size, nums[i]);
			idx[i] = pos;
			if(pos >= 0) continue;
			pos = Math.abs(pos) - 1;
			lis[pos] = nums[i];
			if(pos == size) size++;
			idx[i] = pos;
		}
		
		
		// 역추적
		int[] answer = new int[size];
		int c = size-1;
		
		for (int i = N-1; i >= 0; i--) {
			if(idx[i] == c) {
				answer[c] = nums[i];
				c--;
			}
		}
		
		sb.append(size).append("\n"); // size 
		
		for (int i = 0; i < size; i++) {
			sb.append(answer[i]).append(" ");
		}
		
		System.out.println(sb);
	}
}
