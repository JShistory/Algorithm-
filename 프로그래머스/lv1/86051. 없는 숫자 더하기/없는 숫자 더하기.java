import java.util.*;
class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        List<Integer> intList = new ArrayList<>();        
        for (int element : numbers)         
            intList.add(element);        

        for(int i =0; i<10; i++){
            if(!(intList.contains(i))){
                answer += i;
            }
        }
        
        return answer;
    }
}