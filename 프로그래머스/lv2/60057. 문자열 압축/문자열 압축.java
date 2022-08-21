import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = s.length();
        for(int i=1; i<=s.length()/2; i++){
            String compressed = "";
            String prev = s.substring(0,i);
            int count = 1;
            for(int j=i; j<=s.length(); j+=i){
                String next = s.substring(j, j+i > s.length() ? s.length() : i+j);
                if (prev.equals(next)) count++;
                
                else{
                compressed += count!=1 ? count + prev : prev;
                prev = next;
                count = 1;
                }
            }
            compressed += prev;
            answer = Math.min(answer, compressed.length());
        }
        
        return answer;
    }
}
