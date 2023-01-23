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
            if(data.size() <= k){
                Integer min = data
                        .stream()
                        .mapToInt(v -> v)
                        .min()
                        .orElseThrow(NoSuchElementException::new);
                answer.add(min);
            }

            else{
                Integer min = data
                        .stream()
                        .mapToInt(v -> v)
                        .min()
                        .orElseThrow(NoSuchElementException::new);
                data.remove(data.indexOf(min));
                Integer min1 = data
                        .stream()
                        .mapToInt(v -> v)
                        .min()
                        .orElseThrow(NoSuchElementException::new);
                answer.add(min1);
            }

        }
        return answer.stream()
                .mapToInt(i -> i)
                .toArray();
    }
}