import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        Map<String, Integer> giftScore = new HashMap<>();
        Map<String, Integer> giftCountNextMonth = new HashMap<>();
        Map<String, Map<String, Integer>> gainCount = new HashMap<>();
        
        int N = friends.length;
        int[][] graph = new int[N][N];

        for(String friend : friends) {
            giftScore.put(friend, 0);
            giftCountNextMonth.put(friend, 0);
            gainCount.put(friend, new HashMap<>());
        }
        
        for(String own : friends) {
            for(String friend : friends) {
                gainCount.get(own).put(friend, 0);
            }
        }
        
        
        for(String gift: gifts) {
            String[] data = gift.split(" ");
            giftScore.put(
                data[0], giftScore.get(data[0]) + 1
            );
            giftScore.put(
                data[1], giftScore.get(data[1]) - 1
            );
                            
            gainCount.get(data[1])
                .put(
                    data[0], gainCount.get(data[1]).get(data[0]) + 1
                );
        }
        
        for(int i = 0; i < N-1 ; i++) {
            for(int j = i+1; j < N; j++) {
                String A = friends[i];
                String B = friends[j];
                
                int countA = gainCount.get(A).get(B);
                int countB = gainCount.get(B).get(A);
                
                if(countA > countB) {
                    giftCountNextMonth.put(B, giftCountNextMonth.get(B) + 1); 
                } else if(countA == countB) {
                    int scoreA = giftScore.get(A);
                    int scoreB = giftScore.get(B);
                    
                    if(scoreA > scoreB) {
                        giftCountNextMonth.put(
                            A, giftCountNextMonth.get(A) + 1); 
                    } else if(scoreA < scoreB) {
                        giftCountNextMonth.put(
                            B, giftCountNextMonth.get(B) + 1); 
                    }
                } else {
                    giftCountNextMonth.put(A, giftCountNextMonth.get(A) + 1);
                }
                
            }
        }
        
        int answer = -1;
        
        for(String p : friends) {
            answer = Math.max(answer, giftCountNextMonth.get(p));
        }
        
        return answer;
    }
}