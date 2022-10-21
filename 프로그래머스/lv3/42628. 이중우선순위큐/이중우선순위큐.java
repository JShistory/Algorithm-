import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int[] answer = new int[2];

        for(int i=0; i< operations.length; i++){
            String[] tmp = operations[i].split(" ");
            if(tmp[0].equals("I")){
                maxHeap.add(Integer.valueOf(tmp[1]));
                minHeap.add(Integer.valueOf(tmp[1]));
            }
            else if(tmp[0].equals("D")){
                if(maxHeap.isEmpty() || minHeap.isEmpty()){
                    continue;
                }
                else if(tmp[1].equals("1")){
                    if(maxHeap.isEmpty()){
                        minHeap.poll();
                    }
                    else {
                        int max = maxHeap.poll();
                        minHeap.remove(max);
                    }
                }
                else{
                    if(minHeap.isEmpty()){
                        maxHeap.poll();
                    }
                    else {
                        int min = minHeap.poll();
                        maxHeap.remove(min);

                    }
                }
            }

        }
        if(!minHeap.isEmpty()){
            answer[0] = maxHeap.poll();
            answer[1] = minHeap.poll();
        }
        else{
            answer[0] = 0;
            answer[1] = 0;
        }
        
        return answer;
    }

}
