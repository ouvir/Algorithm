import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        Set<Integer>[] students = new HashSet[N+1];
        for (int i = 1; i <= N; i++) students[i] = new HashSet<>();

        int[][] nums = new int[N+1][6];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < 6; j++) {
                nums[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i < 6; i++) {
            for (int j = 1; j <= N; j++) {
                for (int k = 1; k <= N; k++) {
                    if(j != k && nums[j][i] == nums[k][i]) {
                        students[k].add(j);
                        students[j].add(k);
                    }
                }
            }
        }

        int idx = 0;
        int maxValue = -1;

        for (int i = 1; i <= N; i++) {
            if(maxValue < students[i].size()) {
                idx = i;
                maxValue = students[i].size();
            }
        }

        System.out.println(idx);
    }
}