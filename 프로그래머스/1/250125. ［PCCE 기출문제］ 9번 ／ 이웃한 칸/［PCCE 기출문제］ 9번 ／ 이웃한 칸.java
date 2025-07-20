class Solution {
    private static final int[] dx = {1, 0, -1 ,0};
    private static final int[] dy = {0, 1, 0, -1};
    
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        String color = board[h][w];
        
        int N = board.length;
        int M = board[0].length;
        
        for(int d = 0; d < 4; d++) {
            int mx = h + dx[d];
            int my = w + dy[d];
            if(mx < 0 || mx >= N || my < 0 || my >= M) continue;
            if(board[mx][my].equals(color)) answer++;
        }
        
        return answer;
    }
}