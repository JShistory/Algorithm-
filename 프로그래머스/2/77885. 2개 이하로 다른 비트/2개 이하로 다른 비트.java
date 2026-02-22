import java.util.*;
class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        
        for(int i=0; i<numbers.length; i++) {
            if(numbers[i]%2==0) {
                answer[i] = numbers[i]+1;
            }
            else {
                String num = Long.toBinaryString(numbers[i]);
                if(!num.contains("0")) {
                    num = "0" + num;
                    //System.out.println(num);
                }
                int idx = num.lastIndexOf("0");
                System.out.println(idx);
                num = num.substring(0, idx) + "10" + num.substring(idx+2,num.length());
                answer[i] = Long.parseLong(num, 2);
                //System.out.println(num);
            }
        }
        
        return answer;
    }
}
// 0001, 0010, 0011, 0100, 0101, 0110, 0111