import java.util.*;
class Solution {
    public int solution(int n, int k, int[] enemy) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for(int i=0; i<enemy.length; i++){
            priorityQueue.add(enemy[i]);
            if(priorityQueue.size() > k){
                n -= priorityQueue.poll();
            }
            if(n < 0){
                return i;
            }
        }
        return enemy.length;
    }
}