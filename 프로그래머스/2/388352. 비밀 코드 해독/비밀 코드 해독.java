class Solution {
    public int solution(int n, int[][] q, int[] ans) {
        int answer = 0;
        int[] secret = new int[5];
        for(int a=1; a<=n-4; a++) {
            secret[0] = a;
            for(int b=a+1; b<=n-3; b++) {
                secret[1] = b;
                for(int c=b+1; c<=n-2; c++) {
                    secret[2] = c;
                    for(int d=c+1; d<=n-1; d++) {
                        secret[3] = d;
                        for(int e=d+1; e<=n; e++) {
                            secret[4] = e;
                            if(isSecret(q,secret,ans)) answer++;
                        }
                    }
                }
            }
        }
        return answer;
    }
    boolean isSecret(int[][] q, int[] secret, int[] ans) {
        int[] ansCount = new int[ans.length];
        for(int i=0; i<q.length; i++) {
            int correctCount = 0;
            for(int j=0; j<5; j++) {
                for(int k=0; k<5; k++) {
                    if(q[i][j] == secret[k]) correctCount ++;
                }                
            }
            ansCount[i] = correctCount;
        }
        
        for(int i=0; i<q.length; i++) {
            if(ans[i] != ansCount[i]) return false;
        }
        return true;
    }
    
}