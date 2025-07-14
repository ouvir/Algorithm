import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        
        for(int s : scoville) {
            queue.add(s);
        }
        
        boolean isCan = false;
        int count = 0;
        
        while(queue.size() >= 2) {
            int a = queue.poll();
            if(a >= K) {
                isCan = true;
                break;
            }
            int b = queue.poll();
            
            int c = a + b * 2;
            queue.add(c);
            count++;
        }
        
        int c = queue.poll();
        if(c >= K) isCan = true;
        
        if(isCan) {
            return count;
        }
        return -1;
    }
}