import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for(int i=0; i<commands.length; i++){
            int[] list = commands[i];
            // System.out.println(Arrays.toString(list));
            int[] a = Arrays.copyOfRange(array, list[0]-1,list[1]);
            Arrays.sort(a);
            System.out.println(Arrays.toString(a));
            answer[i] = a[list[2]-1];
            // System.out.println(a[list[2]-1]);
        }
        return answer;
    }
}