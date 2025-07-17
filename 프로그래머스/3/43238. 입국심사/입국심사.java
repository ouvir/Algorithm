class Solution {
    public long solution(int n, int[] times) {
        long answer = 0L;
        long start = 0L;
        long end = 1_000_000_000_000_000_001L;
        
        while(start <= end) {
            long mid = (start + end) / 2;
            
            long checkedPeopleCount = 0L;
            for(int time : times) {
                checkedPeopleCount += mid / (long) time;
            }
            
            if(checkedPeopleCount >= n) {
                answer = mid;
                end = mid-1;
            } else {
                start = mid+1;
            }
        }
        
        return answer;        
    }
}