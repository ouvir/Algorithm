import java.util.*;

class Solution {
    public int solution(int[] mats, String[][] park) {
        Arrays.sort(mats);
        int matsCount = mats.length;
        
        int answer = -1;
        int N = park.length;
        int M = park[0].length;
        
        b:for(int i = matsCount - 1; i >= 0; i--) {
            int curMatSize = mats[i];
            
            for(int x = 0; x <= N - curMatSize; x++) {
                for(int y = 0; y <= M - curMatSize; y++) {
                    boolean can = true;
                    
                    c:for(int m1 = 0; m1 < curMatSize; m1++) {
                        for(int m2 = 0; m2 < curMatSize; m2++) {
                            if(!park[x+m1][y+m2].equals("-1")) {
                                can = false;
                                break c;
                            }
                        }
                    }
                    
                    if(can) {
                        answer = curMatSize;
                        break b;
                    }
                }
            }
        }
        
        return answer;
    }
}