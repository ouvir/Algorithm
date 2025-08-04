import java.util.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        Arrays.sort(rocks);
        
        // 찾을 것 -> 지점 간, 거리의 최소 값
        int start = 1;
        int end = distance;
        
        int answer = 0;
        
        while(start <= end) {
            int mid = (start + end) / 2;
            
            if(getRemoveCount(rocks, mid, distance) <= n) {
                answer = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        
        return answer;
    }
    
    private static int getRemoveCount(int[] rocks, int mid, int distance) {
        int start = 0;
        int end = distance;
        
        int count = 0;
        
        for(int i = 0; i < rocks.length; i++) {
            if(rocks[i] - start < mid) {
                count++;
                continue;
            }
            start = rocks[i];
        }
        if(end - start < mid) count++;
        
        return count;
    }
}