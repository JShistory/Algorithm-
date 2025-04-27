import java.util.*;
class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        int start = startday;
        for(int i=0; i<schedules.length; i++) {
            int checkTime = convert(schedules[i]);
            boolean goodToWork = true;
            start = startday;
            for(int j=0; j<7; j++, start++) {
                if(start % 7 == 6 || start % 7 == 0) {
                    continue;
                }
                
                if(checkTime < timelogs[i][j]) {
                    goodToWork = false;
                    break;
                }
            }
            if(goodToWork) answer ++;
        }
        return answer;
    }
    
    int convert(int time) {
        time += 10;
        String str = Integer.toString(time);
        if(str.charAt(str.length() - 2) == '6') {
            // 1더하고 나머지 시간은 또 붙여줘야됨.
            time = time - 60 + 100;
        }
        return time;
    }
}