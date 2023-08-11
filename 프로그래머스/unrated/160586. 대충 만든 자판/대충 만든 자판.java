import java.util.HashMap;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        HashMap<Character, Integer> data = new HashMap<>();

        for(int i=0; i<keymap.length; i++){
            for(int j=0; j<keymap[i].length(); j++){
                data.put(keymap[i].charAt(j),Math.min(j+1, data.getOrDefault(keymap[i].charAt(j),Integer.MAX_VALUE)));
            }
        }

        for(int i=0; i< targets.length; i++){
            for(int j=0; j<targets[i].length(); j++){
                if(data.containsKey(targets[i].charAt(j))){
                    answer[i] += data.get(targets[i].charAt(j));
                }
                else{
                    answer[i] = -1;
                    break;
                }
            }
        }
        
        return answer;
    }
}