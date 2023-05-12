import java.util.*;

class dataPoint{
    String str;
    int count;
    dataPoint(String str, int count){
        this.str = str;
        this.count = count;
    }
}
class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        for(String s : words){
            if(s.equals(target)){
                answer ++;
            }
        }
        if(answer != 1){
            return 0;
        }
        answer = 0;
        Deque<dataPoint> data = new LinkedList<>();
        data.add(new dataPoint(begin,0));
        
        while(!data.isEmpty()){
            dataPoint temp = data.poll();
            String checkStr = temp.str;
            int checkCount = temp.count;
            if(checkStr.equals(target)){
                return checkCount;
            }            
            for(String s : words){
                int cnt = 0;
                for(int i=0; i<s.length(); i++){
                    if(checkStr.charAt(i) != s.charAt(i)){
                        cnt++;
                    }
                }
                if(cnt == 1){
                    data.offer(new dataPoint(s,checkCount+1));
                }
            }
        }
        return answer;
    }
}