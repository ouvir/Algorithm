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
		
		int[] nums = new int[N];
		int[] lis = new int[N];
		int[] answer;	
		
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		
		int size = 0;
		for (int i = 0; i < N; i++) {
			int pos = Arrays.binarySearch(lis, 0, size, nums[i]);
			if(pos >= 0) continue;
			pos = Math.abs(pos) - 1;
			lis[pos] = nums[i];
			if(pos == size) size++;
		}
		
		System.out.println(size);
	}
}
