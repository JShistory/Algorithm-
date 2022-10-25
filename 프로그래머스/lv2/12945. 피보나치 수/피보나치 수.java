class Solution {
    public int solution(int n) {
        int answer = 0;
        int[] dp = new int[100001];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        for(int i=3; i<n+1; i++){
            dp[i] = (dp[i-2]+dp[i-1])%1234567;
        }
        return dp[n];
    }
}