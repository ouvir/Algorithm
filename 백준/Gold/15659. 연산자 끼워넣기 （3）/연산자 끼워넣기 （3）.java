import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] operators;
	static int[] nums;
	static int[] opOrder;
	static int maxValue;
	static int minValue;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		nums = new int[N];
		opOrder = new int[N-1];
		operators = new int[4];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			operators[i] = Integer.parseInt(st.nextToken());
		}

		minValue = Integer.MAX_VALUE;
		maxValue = Integer.MIN_VALUE;

		// perm
		perm(0); // depth, value

		System.out.println(maxValue);
		System.out.println(minValue);
	}

	static void perm(int depth) {
		if (depth == N - 1) {
			calc();
			return;
		}

		if(operators[0] > 0) {
			operators[0]--;
			opOrder[depth] = 0;
			perm(depth+1);
			operators[0]++;
		}
		if(operators[1] > 0) {
			operators[1]--;
			opOrder[depth] = 1;
			perm(depth+1);
			operators[1]++;
		}
		if(operators[2] > 0) {
			operators[2]--;
			opOrder[depth] = 2;
			perm(depth+1);
			operators[2]++;
		}
		if(operators[3] > 0) {
			operators[3]--;
			opOrder[depth] = 3;
			perm(depth+1);
			operators[3]++;
		}
		
	}
	
	static void calc() {
		ArrayDeque<Integer> stackNum = new ArrayDeque<>();
		ArrayDeque<Integer> stackOp = new ArrayDeque<>();
		
		int size = 0;
		stackNum.add(nums[size++]);
		
		for (int i = 0; i < N-1; i++) {
			if(opOrder[i] == 2 || opOrder[i] == 3) {
				int tmp = stackNum.pollLast();
				if(opOrder[i] == 2) {
					stackNum.add(tmp * nums[size++]);
				} else {
					if (tmp < 0) {
						stackNum.add( -1 * tmp / nums[size++] * -1);
					} else stackNum.add(tmp / nums[size++]);					
				}
			} else {
				stackNum.add(nums[size++]);
				stackOp.add(opOrder[i]);
			}
		}
		
		while(!stackOp.isEmpty()) {
			int op = stackOp.poll();
			
			int a = stackNum.poll();
			int b = stackNum.poll();
			
			switch(op) {
				case 0:
					stackNum.addFirst(a + b);
					break;
				case 1:
					stackNum.addFirst(a - b);
					break;
			}
		}
		
		int output = stackNum.poll();
		minValue = Math.min(minValue, output);
		maxValue = Math.max(maxValue, output);
	}
}