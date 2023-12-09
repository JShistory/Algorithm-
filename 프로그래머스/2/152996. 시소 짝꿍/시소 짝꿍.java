import java.util.*;

class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        Arrays.sort(weights);
        Map<Double, Integer> siso = new HashMap<>();
        
        for(int i=0; i<weights.length; i++){
            double calc1 = (weights[i] * 1.0);
            double calc2 = (weights[i] * 1.0) / 2.0;
            double calc3 = (weights[i] * 2.0) / 3.0;
            double calc4 = (weights[i] * 3.0) / 4.0;

            if(siso.containsKey(calc1)){
                answer += siso.get(calc1);
            }
            if(siso.containsKey(calc2)){
                answer += siso.get(calc2);
            }
            if(siso.containsKey(calc3)){
                answer += siso.get(calc3);
            }
            if(siso.containsKey(calc4)){
                answer += siso.get(calc4);
            }
            
            siso.put(weights[i]*1.0, siso.getOrDefault(weights[i]*1.0,0) +1);
            
        }
        
        
        
        return answer;
    }
}