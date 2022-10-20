import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        int answer = 0;
        for(int i=0; i<priorities.length; i++){
            maxHeap.add(priorities[i]);
        }

        while(!maxHeap.isEmpty()){
            for(int i=0; i<priorities.length; i++){
                if(maxHeap.peek() == priorities[i]){
                    if(i == location){
                        answer +=1;
                        return answer;
                    }
                    maxHeap.poll();
                    answer +=1;
                }
            }
        }
    return -1;
    }
}
