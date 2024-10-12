import java.util.*;
class Solution {
    private int brown;
    private int yellow;
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        this.brown = brown;
        this.yellow = yellow;
        
        int sumOfCarfet = brown + yellow;
        
        for(int i=3; i<sumOfCarfet; i++) {
            int j = sumOfCarfet / i;
            
            if (sumOfCarfet % i == 0 && j >= 3){
                int col = Math.max(i,j);
                int row = Math.min(i,j);
                int center = (col - 2) * (row - 2);
                if (center == yellow) {
                    answer[0] = col;
                    answer[1] = row;
                }
            }
        }
        return answer;
    }
}