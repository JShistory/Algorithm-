import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i=0; i<clothes.length; i++){
            String[] clothe = clothes[i];
            if(!map.containsKey(clothe[1])){
                map.put(clothe[1],1);
            }
            else{
                map.put(clothe[1],map.get(clothe[1])+1);
            }
        }
        // System.out.println(map);
        for(String s : map.keySet()){
            answer *=map.get(s)+1;
        }
        return answer-1;
    }
}