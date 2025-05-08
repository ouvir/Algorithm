import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[6];

        for (int i = 0; i < 6; i++) {
            st = new StringTokenizer(br.readLine());
            Integer.parseInt(st.nextToken());
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 최대값 찾기
        int value = 0;

        int bigX = 0;
        int bigY = 0;
        int smallX = 0;
        int smallY = 0;

        for (int i = 0; i < 6; i++) {
            if (arr[i] > value) {
                value = arr[i];
                bigX = i;
            }
        }

        int nextX = (bigX + 1) % 6;
        int prevX = (bigX + 5) % 6;

        if(arr[nextX] > arr[prevX]) {
            bigY = nextX;
            smallX = (prevX + 5) % 6;
            smallY = (smallX + 5) % 6;
        } else {
            bigY = prevX;
            smallX = (nextX + 1) % 6;
            smallY = (smallX + 1) % 6;
        }

        int extent = (arr[bigX] * arr[bigY]) - (arr[smallX] * arr[smallY]);
        System.out.println(extent * N);
    }
}
