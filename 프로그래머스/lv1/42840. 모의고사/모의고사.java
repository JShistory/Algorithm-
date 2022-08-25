import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        
        int[] s1 = new int[]{1,2,3,4,5};
        int[] s2 = new int[]{2,1,2,3,2,4,2,5};
        int[] s3 = new int[]{3,3,1,1,2,2,4,4,5,5};
        int c1=0;
        int c2=0;
        int c3=0;
        for(int i=0; i<answers.length; i++){
            int ss1 = i%5;
            int ss2 = i%8;
            int ss3 = i%10;
            if(s1[ss1] == answers[i]){
                c1++;
            }
            if(s2[ss2]==answers[i]){
                c2++;
            }
            if(s3[ss3]==answers[i]){
                c3++;
            }
        
        }
        ArrayList<Integer> list = new ArrayList<>();
        int max = Math.max(c1,Math.max(c3,c2));
        if(max == c1) list.add(1);
        if(max == c2) list.add(2);
        if(max == c3) list.add(3);
        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}