class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        boolean[][] win = new boolean[n+1][n+1];
        
        for(int[] result : results) {
            win[result[0]][result[1]] = true;
        }
        
        // 3. 플로이드-워샬: 간접 관계 찾기
        for(int k = 1; k <= n; k++) {           // 경유지
            for(int i = 1; i <= n; i++) {       // 출발
                for(int j = 1; j <= n; j++) {   // 도착
                    if(win[i][k] && win[k][j]) {
                        win[i][j] = true;  // i가 k를 이기고, k가 j를 이기면 → i가 j도 이김!
                    }
                }
            }
        }
        for(int i = 1; i <= n; i++) {
            int count = 0;

            for(int j = 1; j <= n; j++) {
                // i가 j를 이기거나, j가 i를 이기면
                if(win[i][j] || win[j][i]) {
                    count++;
                }
            }

            // 나머지 모든 선수(n-1명)와의 관계를 알면 순위 확정
            if(count == n - 1) {
                answer++;
            }
        }
        return answer;
    }
}