import java.util.*;
import java.util.stream.Collectors;
class Solution {
    public int solution(int[] mats, String[][] park) {
        List<Integer> matsList = Arrays.stream(mats).boxed().collect(Collectors.toList());
        Collections.sort(matsList, Collections.reverseOrder());
        
        for(int matSize : matsList) {
            for(int i=0; i<park.length; i++) {
                for(int j=0; j<park[i].length; j++) {
                    if(park[i][j].equals("-1")) {
                        if(canPlace(park,i,j,matSize)) {
                            return matSize;
                        }
                    }
                    
                }
            }                
        }
        return -1;
    }
    
    boolean canPlace(String[][] park, int i, int j, int matSize) {
        if(i+matSize > park.length || j+matSize > park[i].length) return false;
        for(int x = i; x<i+matSize; x++) {
            for(int y = j; y<j+matSize; y++) {
                if(!park[x][y].equals("-1")) {
                    return false;
                }
            }
        }
        return true;
    }
}
