import java.util.List;
import java.util.ArrayList;

public class Solution {
    public int[] solution(int []arr) {
        List<Integer> list = new ArrayList<>();       
        
        list.add(arr[0]);
        for(int i=0; i<arr.length-1; i++){
            if(arr[i] !=arr[i+1]){
                list.add(arr[i+1]);
            }
            else{
                continue;
            }
        }
        
        int[] temp = list.stream().mapToInt(i->i).toArray();
        return temp;
    }
}