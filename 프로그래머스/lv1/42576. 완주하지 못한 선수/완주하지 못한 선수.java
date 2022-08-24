import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        int idx = 1;
        HashMap<String,Integer> hash = new HashMap<>();
        Arrays.sort(participant);
        Arrays.sort(completion);
        // System.out.println(Arrays.toString(participant));
        // System.out.println(Arrays.toString(completion));
        for(String s : participant){
            if(!hash.containsKey(s))
                hash.put(s,idx);
            else{
            hash.put(s, hash.get(s)+idx);
            }
        }
        for(int i=0; i<completion.length; i++){
            if(hash.containsKey(completion[i])){
                hash.put(completion[i],hash.get(completion[i])-1);
            }
        }
        for(String key : hash.keySet()){
            if(hash.get(key) >0){
                answer += key;
            }
        }
        return answer;
    }
}