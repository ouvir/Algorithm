import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Set<Integer> a = new HashSet<Integer>();
        Set<Integer> b = new HashSet<Integer>();

        int A, B;
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < A; i++) {
            a.add(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < B; i++) {
            b.add(Integer.parseInt(st.nextToken()));
        }

        Set<Integer> tmpA = new HashSet<>(a);
        Set<Integer> tmpB = new HashSet<>(b);
        tmpA.removeAll(b);
        tmpB.removeAll(a);
        int output = tmpA.size() + tmpB.size();

        System.out.println(output);
    }
}