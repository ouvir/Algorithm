import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long N = Long.parseLong(br.readLine());
		long value = N % 5;
		long cnt = N / 5;
		
		long result = -1;
		for (long i = 0; i < 5; i++) {
			if(value % 3 == 0) {
				result = (value / 3) + cnt;
				break;
			}
			value += 5;
			cnt--;
			if(value > N) break;
		}
		System.out.println(result);
	}
}