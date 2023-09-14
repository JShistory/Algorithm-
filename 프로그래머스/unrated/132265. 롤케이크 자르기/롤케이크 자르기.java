import java.util.*;
class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        Set<Integer> data1 = new HashSet<>();
        HashMap<Integer, Integer> data2 = new HashMap<>();
        
        for(int i : topping){
            data2.put(i,data2.getOrDefault(i,0)+1);
        }
        
        for(int i : topping){
            data1.add(i);
            data2.put(i,data2.getOrDefault(i,0)-1);
            if(data2.get(i) == 0){
                data2.remove(i);
            }
            if(data1.size() == data2.size()){
                answer++;
            }
        }
        return answer;
    }
}