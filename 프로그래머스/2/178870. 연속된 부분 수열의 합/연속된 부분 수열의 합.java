import java.util.*;
class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];

        int left = 0;
        int right = 0;
        int sum = 0;
        int len = Integer.MAX_VALUE;
        while(right < sequence.length || sum >= k) {
            
            if(sum < k) {
                sum += sequence[right++];
            }
            else if(sum > k) {
                sum -= sequence[left++];
            }
            else if(sum == k) {
                if(right - left < len) {
                    len = right - left;
                    answer[0] = left;
                    answer[1] = right - 1;
                }
                sum -= sequence[left++];
            }
        }
        return answer;
    }
}