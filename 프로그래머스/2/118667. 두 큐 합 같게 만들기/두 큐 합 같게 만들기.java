import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        Queue<Integer> q1 = new ArrayDeque<>();
        Queue<Integer> q2 = new ArrayDeque<>();
        
        long q1Sum = 0;
        long q2Sum = 0;
        
        for(int e : queue1) {
            q1.add(e);
            q1Sum += e;
        }
        for(int e : queue2) {
            q2.add(e);
            q2Sum += e;
        }
        
        int count = 0;
        int N = queue1.length + queue2.length;
        
        while(true) {
            // 한쪽 큐가 0이면 못만듦 -1 return
            if(q1Sum == 0 || q2Sum == 0) {
                return -1;
            }            
            if(q1Sum == q2Sum) break;
            if(count > 4 * N) return -1;
            if(q1Sum > q2Sum) {
                int tmp = q1.poll();
                q2.add(tmp);
                q1Sum -= tmp;
                q2Sum += tmp;
            }
            else {
                int tmp = q2.poll();
                q1.add(tmp);
                q2Sum -= tmp;
                q1Sum += tmp;
            }
            
            count++;
        }
        
        return count;
    }
}