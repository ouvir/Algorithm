import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        // 그리디 -> 앞에 있는 1 최대한 지우기
        // 뒤에 있는 0 최대한 지우기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] data = br.readLine().toCharArray();
        int n = data.length;
        boolean[] isDelete = new boolean[n];

        // 순회하며 0 개수 1 개수 카운트
        int zero = 0;
        int one = 0;

        for(int i = 0; i < n; i++) {
            if(data[i] == '0') zero++;
            else one++;
        }

        zero /= 2;
        one /= 2;

        // 앞에있는 1부터 절반 지우기
        for(int i = 0; i < n; i++) {
            if(!isDelete[i] && data[i] == '1') {
                isDelete[i] = true;
                one--;
                if(one == 0) break;
            }
        }

        // 뒤에있는 0부터 절반 지우기
        for(int i = n-1; i > 0; i--) {
            if(!isDelete[i] && data[i] == '0') {
                isDelete[i] = true;
                zero--;
                if(zero == 0) break;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            if(!isDelete[i]) sb.append(data[i]);
        }

        System.out.println(sb);
    }
}