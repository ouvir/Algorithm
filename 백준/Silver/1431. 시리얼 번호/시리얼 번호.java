import java.io.*;
import java.util.*;

public class Main {
    private static int N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        PriorityQueue<String> pq = new PriorityQueue<>(
                (o1, o2) -> {
                    if(o1.length() == o2.length()) {
                        int a = 0;
                        int b = 0;
                        for(int i = 0; i < o1.length(); i++) {
                            char ch1 = o1.charAt(i);
                            char ch2 = o2.charAt(i);

                            if( ch1 >= '0' && ch1 <= '9') a += ch1 - '0';
                            if( ch2 >= '0' && ch2 <= '9') b += ch2 - '0';
                        }
                        if(a == b) {
                            return o1.compareTo(o2);
                        }
                        else if(a < b) return -1;
                        else return 1;
                    } else {
                        if(o1.length() < o2.length()) return -1;
                        else return 1;
                    }
                }
        );

        for(int i = 0; i < N; i++) {
            pq.add(br.readLine());
        }

        while(!pq.isEmpty()) {
            sb.append(pq.poll());
            sb.append('\n');
        }

        System.out.print(sb);
    }
}
