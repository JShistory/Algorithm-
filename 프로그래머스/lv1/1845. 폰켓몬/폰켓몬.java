import java.util.*;
class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int c = nums.length/2;
        HashSet<Integer> hash = new HashSet<>();
        for(int i: nums)
            hash.add(i);
        // System.out.println(hash);
        // System.out.println(hash.size());
        if(hash.size() >= c){
            answer = (int)c;
        }
        else{
            answer = hash.size();
        }
        return answer;
    }
}