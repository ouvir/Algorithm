import java.util.*;

class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0; // 초기 값
        
        int distance = n;
        
        while(true) {
            // distance 감소
            while(deliveries[distance-1] == 0 && pickups[distance-1] == 0) {
                distance--;
                if(distance <= 0) break;
            }
            
            // 만약 모든 애들이 끝났다면 종료
            if(distance <= 0) break;
            
            int dTmp = cap;
            int pTmp = 0;
            
            // 역순으로 최대한 배달
            for(int i = distance - 1; i >= 0; i--) {
                if(deliveries[i] >= dTmp) {
                    deliveries[i] -= dTmp;
                    dTmp = 0;
                    break;
                }
                else {
                    dTmp -= deliveries[i];
                    deliveries[i] = 0;
                }
            }
            
            // 거리 추가
            answer += distance;
            
            // 역순으로 최대한 수거
            for(int i = distance - 1; i >= 0; i--) {
                if(pickups[i] + pTmp >= cap) {
                    pickups[i] -= (cap - pTmp);
                    pTmp = cap;
                    break;
                }
                else {
                    pTmp += pickups[i];
                    pickups[i] = 0;
                }
            }
            
            // 거리 추가
            answer += distance;
        }
        
        return answer;
    }
}