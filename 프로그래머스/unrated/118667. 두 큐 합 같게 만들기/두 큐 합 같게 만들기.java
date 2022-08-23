import java.util.*;
class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = -2;
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        long sum1=0L;
        long sum2=0L;
        for(int i : queue1){
            sum1+=i;
            q1.add(i);
        }
        for(int i : queue2){
            q2.add(i);
            sum2+=i;
        }
        
        for(int i=0; i<queue1.length*3; i++){
            if(sum1 == sum2) 
                return i;
            if(sum1 > sum2){
                int num = q1.poll();
                q2.add(num);
                sum1 -=num;
                sum2 +=num;
            }
            else{
                int num = q2.poll();
                q1.add(num);
                sum1 +=num;
                sum2 -=num;
            }
        }
        return -1;
    }
}