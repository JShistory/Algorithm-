import java.util.*;
class Solution {
    int[] answer = new int[2];
    public int[] solution(int[][] arr) {
        int size = arr.length;
        zipQuad(arr, 0,0, size);
        return answer;
    }
    
    private void zipQuad(int[][] arr, int colX, int rowY, int quadZipSize) {
        if (check(arr, colX, rowY, quadZipSize)) {
            answer[arr[colX][rowY]]++;
            return;
        }
        zipQuad(arr, colX, rowY, quadZipSize / 2);
        zipQuad(arr, colX + quadZipSize / 2, rowY, quadZipSize / 2);
        zipQuad(arr, colX, rowY + quadZipSize / 2, quadZipSize / 2);
        zipQuad(arr, colX + quadZipSize / 2, rowY + quadZipSize / 2, quadZipSize / 2);
        
    }
    
    private boolean check(int[][] arr, int colX, int rowY, int quadZipSize) {
        for (int i = colX; i < colX + quadZipSize; i++) {
            for (int j = rowY; j < rowY + quadZipSize; j++) {
                if (arr[colX][rowY] != arr[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}