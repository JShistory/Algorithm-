import java.util.*;
public class Solution {
    public int[] solution(int n, String[] words){
        int[] answer = {0,0};
        int cnt = 0;
        Deque<String> wordsGroups = new ArrayDeque<>();
        for(int i=0; i<words.length; i++){
            String currentword = words[i];

            if(wordsGroups.isEmpty()){
                wordsGroups.add(currentword);
            }
            else if(wordsGroups.contains(currentword)){
                answer[0] = i%n +1;
                answer[1] = i/n +1;
          
                break;
            }
            else{
                int wordSize = wordsGroups.peekLast().length()-1;
//                System.out.println(wordsGroups.peekLast().charAt(wordSize));
//                System.out.println(currentword.charAt(0));
                if(wordsGroups.peekLast().charAt(wordSize) == currentword.charAt(0)){
                    wordsGroups.add(currentword);
                }
                else{
                    answer[0] = i%n +1;
                    answer[1] = i/n +1;
                    break;
                }
            }

        }
        return answer;
    }

}