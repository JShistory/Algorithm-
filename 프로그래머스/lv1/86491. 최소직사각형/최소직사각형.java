import java.util.*;
class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int[] m1 = new int[sizes.length];
        int[] m2 = new int[sizes.length];
        int max1=0;
        int max2=0;
        
        for(int i=0; i<sizes.length; i++){
            int max = sizes[i][0];
            int min = sizes[i][1];
                if(sizes[i][0] > sizes[i][1]){
                    max = sizes[i][1];
                    min = sizes[i][0];
                }
                else{
                    min = sizes[i][1];
                    max = sizes[i][0];
                }
            m1[i] = max;
            m2[i] = min;
        
        }
        //System.out.println(Arrays.toString(m1));
        //System.out.println(Arrays.toString(m2));
        for(int i : m1)
            max1 = Math.max(i,max1);
        for(int i : m2)
            max2 = Math.max(i,max2);
            
        answer = max1*max2;
        return answer;
    }
}