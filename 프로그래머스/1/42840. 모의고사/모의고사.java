import java.util.*;

class Solution {
    private final static int[] one = {1,2,3,4,5};
    private final static int[] two = {2,1,2,3,2,4,2,5};
    private final static int[] three = {3,3,1,1,2,2,4,4,5,5};
    
    public int[] solution(int[] answers) {        
        int oneLength = one.length;
        int twoLength = two.length;
        int threeLength = three.length;
        
        int[] scores = new int[3];
        
        int N = answers.length;
        
        for(int i = 0; i < N; i++) {
            if(one[i % oneLength] == answers[i]) scores[0]++;
            if(two[i % twoLength] == answers[i]) scores[1]++;
            if(three[i % threeLength] == answers[i]) scores[2]++;
        }
        
        List<Integer> best = new ArrayList<>();
        int bestScore = 0;
        
        for(int i = 0; i < 3; i++) {
            if(bestScore < scores[i]) {
                bestScore = scores[i];
                best.clear();
                best.add(i+1);
            }else if(bestScore == scores[i]) {
                best.add(i+1);
            }
        }
        
        int[] answer = new int[best.size()];
        
        int idx = 0;
        for(int a : best) {
            answer[idx++] = a;
        }
        return answer;
    }
}