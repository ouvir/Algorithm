import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int N, D;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Map<Integer, List<int[]>> roads = new HashMap<>();

        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            int start, end, distance;
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            distance = Integer.parseInt(st.nextToken());

            if (!roads.containsKey(start)) roads.put(start, new ArrayList<>());
            roads.get(start).add(new int[]{end, distance});
        }


        int minValue = Integer.MAX_VALUE;

        Queue<int[]> q = new ArrayDeque<>();

        q.add(new int[]{0, 0}); // pos, totalDistance

        while(!q.isEmpty()) {
            int[] cur = q.poll();

            if(cur[0] == D) {
                minValue = Math.min(minValue, cur[1]);
                continue;
            }

            if (roads.containsKey(cur[0])) {
                for (int[] road : roads.get(cur[0])) {
                    if(D >= road[0] && (D - cur[0]) > road[1]) {
                        q.add(new int[] {road[0], cur[1] + road[1]});
                    }
                }
            }

            if(cur[0] + 1 <= D) q.add(new int[]{cur[0] + 1, cur[1] + 1});
        }

        System.out.println(minValue);
    }
}

