import java.util.Arrays;

public class Main {
	private static int read() throws Exception {
        int d, o;
        boolean negative = false;
        d = System.in.read();
        if (d == '-') {
            negative = true;
            d = System.in.read();
        }
        o = d & 15;
        while ((d = System.in.read()) > 32)
            o = (o << 3) + (o << 1) + (d & 15);
        return negative? -o:o;
    }
    
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		int N = read();
		final int P = 500_000;
		
		int[] count = new int[P+1];
		int[] nums = new int[N]; 
		int[] LIS = new int[N]; // 이분 탐색용 배열
		int[] IDX = new int[N]; // 역추적용 배열
		
		for (int i = 0; i < N; i++) {
			int a = read();
			int b = read();
			count[b] = a;
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
		
		sb.append(N-size).append("\n");

		c = size - 1;
		for (int i = N-1; i >= 0; i--) {
			if(IDX[i] == c) {
				c--;
			} else {
				sb.append(nums[i]).append("\n");
			}
		}
		
		System.out.print(sb);
	}
}
