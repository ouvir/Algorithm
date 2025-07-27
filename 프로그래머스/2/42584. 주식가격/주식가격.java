import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int N = prices.length;
        int[] answer = new int[N];
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (o1, o2) -> Integer.compare(o2[0], o1[0])
        );
        
        for(int i = 0; i < N; i++) {
            while(!pq.isEmpty()) {
                int[] top = pq.poll();
                if(prices[i] >= top[0]) {
                    pq.add(top);
                    break;
                }
                answer[top[1]] = i - top[1];
            }
            pq.add(new int[] {prices[i], i});
        }
        
        while(!pq.isEmpty()) {
            int[] top = pq.poll();
            answer[top[1]] = (N-1) - top[1];
        }
        
        return answer;
    }
}