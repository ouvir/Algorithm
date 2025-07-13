class Solution {
    public static int N;
    
    public int solution(int[][] sizes) {        
        N = sizes.length;
        int r = 0;
        int c = 0;
        
        for(int i = 0; i < N; i++) {
            if(sizes[i][0] > sizes[i][1]) {
                r = Math.max(r, sizes[i][0]);
                c = Math.max(c, sizes[i][1]);
            } else {
                r = Math.max(r, sizes[i][1]);
                c = Math.max(c, sizes[i][0]);
            }
        }
        
        return r * c;
    }
}