import java.util.*;
class Solution {
    public int[] solution(String msg) {
        
        List<Integer> answerList = new ArrayList<>();
        HashMap<String, Integer> words = new HashMap<>();
        int lastIndex = 27;
        for(int i=1; i<=26; i++){
            words.put(Character.toString('A'+(i-1)),i);
        }
        
        int index = 0;
        String str = "";
        for(int i=0; i<msg.length(); i++){
            str += Character.toString(msg.charAt(i));
            if(words.containsKey(str)){
                index = words.get(str);    
            }
            else{
                words.put(str,lastIndex++);
                answerList.add(index);
                str = "";
                i--;
            }
        }
        if(index != 0 ){
            answerList.add(index);
        }

        int[] answer = new int[answerList.size()];
        for(int i=0; i<answerList.size(); i++){
            answer[i] = answerList.get(i);
        }
        return answer;
    }
}