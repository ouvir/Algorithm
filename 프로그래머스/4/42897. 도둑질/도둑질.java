class Solution {
    public int solution(int[] money) {
        int n = money.length;
        int[] dp = new int[n];
        
        // 0번째를 선택 안하는 경우
        dp[1] = money[1];
        for(int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + money[i]);
        }
        int f = dp[n-1];
        
        // -1번째를 선택 안하는 경우
        dp = new int[n];
        dp[0] = money[0];
        dp[1] = Math.max(money[0], money[1]);
        for(int i = 2; i < n-1; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + money[i]);
        }
        int s = dp[n-2];
        
        return Math.max(f, s);
    }
}