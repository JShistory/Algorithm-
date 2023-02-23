import java.util.*;
class Solution {
    public int solution(int[] sides) {
        int answer = 0;
        int max_value = Arrays.stream(sides)
                        .max()
                                .getAsInt();
        
        answer = Arrays.stream(sides)
                        .sum();
        
        if(answer-max_value <= max_value){
            return 2;
        }
        else{
            return 1;
        }
        
    }
}