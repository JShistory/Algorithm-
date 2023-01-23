import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Stack;

class Solution {
    public int[] solution(int k, int[] score) {
                List<Integer> answer = new ArrayList<>();
        Stack<Integer> data = new Stack<>();
        for(int i=0; i<score.length; i++){
            data.add(score[i]);
            Integer min = data
                    .stream()
                    .mapToInt(v -> v)
                    .min()
                    .orElseThrow(NoSuchElementException::new);

            if(data.size() <= k){
                answer.add(min);
            }

            else{
                data.remove(data.indexOf(min));
                min = data
                        .stream()
                        .mapToInt(v -> v)
                        .min()
                        .orElseThrow(NoSuchElementException::new);
                answer.add(min);
            }

        }
        return answer.stream()
                .mapToInt(i -> i)
                .toArray();

    }
}