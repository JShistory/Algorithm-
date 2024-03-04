class Solution {
    public int[] solution(int n) {
        
        int[][] data = new int[n][n];
        int idx = 1;
        int x = -1;
        int y = 0;
        int k = 0;
        for(int i=0; i<n; i++){
            for(int j=i; j<n; j++){
                if(i % 3 == 0){
                    x++;  
                }
                else if(i % 3 == 1){
                    y++;
                }
                else if(i % 3 == 2){
                    x--;
                    y--;
                }
                data[x][y] = idx++;
                k++;
            }
        }
        int[] answer = new int[k];
        k = 0;
        for(int i=0; i<data.length; i++){
            for(int j=0; j<data[i].length; j++){
                if(data[i][j] != 0){
                    answer[k++] = data[i][j];  
                }
            }
        }
        
        return answer;
    }
}