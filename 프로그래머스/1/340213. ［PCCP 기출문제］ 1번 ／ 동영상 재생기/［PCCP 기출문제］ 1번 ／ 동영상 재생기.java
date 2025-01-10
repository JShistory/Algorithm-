import java.util.*;
class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        int pos_second = convertTimeToSecond(pos);
        int op_start_second = convertTimeToSecond(op_start);
        int op_end_second = convertTimeToSecond(op_end);
        int video_len_second = convertTimeToSecond(video_len);
        if(op_start_second <= pos_second && pos_second <= op_end_second) {
            pos_second = op_end_second;
        }
        
        for(String command : commands) {
            if(Objects.equals(command, "next")) {
                pos_second += 10;
            }
            else {
                pos_second -= 10;
            }
            if(pos_second > video_len_second) {
                pos_second = video_len_second;
            }
            else if(pos_second < 0) {
                pos_second = 0;
            }
                
            if(op_start_second <= pos_second && pos_second <= op_end_second) {
                pos_second = op_end_second;
            }
        }
        return convertTimeToString(pos_second);
    }
    
    public int convertTimeToSecond(String time) {
        return Integer.valueOf(time.split(":")[0]) * 60 + Integer.valueOf(time.split(":")[1]);
    }
    
    public String convertTimeToString(int time) {
        String str = "";
        if(time / 60 < 10) {
            str += "0";
        }
        str += time / 60 + ":";
        
        if(time % 60 < 10) {
            str += "0";
        }
        return str += time % 60;
    }
}