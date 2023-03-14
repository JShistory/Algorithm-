
import java.util.Arrays;

import java.util.Comparator;
class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        Integer[] tmp = Arrays.stream(score)
                        .boxed()
                        .toArray(Integer[]::new);
        Arrays.sort(tmp, Comparator.reverseOrder());
        int size = tmp.length/m;
        for(int i=1; i<=size; i++){
            int p = tmp[m*i-1];
            answer += (p*m);
        }
        return answer;
    }
}