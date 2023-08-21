import java.util.*;
class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "";
        m = replaceMelody(m);
        int time = 0;
        
        for(int i=0; i<musicinfos.length; i++){
            String[] info = musicinfos[i].split(",");
            
            String[] timeInfo1 = info[0].split(":");
            String[] timeInfo2 = info[1].split(":");
            String melodyInfo = replaceMelody(info[3]);
            int playTime = convertTime(timeInfo2[0],timeInfo2[1]) - convertTime(timeInfo1[0],timeInfo1[1]);
            System.out.println(playTime);
            
            if(playTime > melodyInfo.length()){
                while(melodyInfo.length() < playTime){
                    melodyInfo += melodyInfo;
                }
            }
            melodyInfo = melodyInfo.substring(0,playTime);
            
            if(melodyInfo.contains(m)){
                if(time < playTime){
                    time = playTime;
                    answer = info[2];
                }
            }
            
        }
        if(answer ==""){
            return "(None)";
        }
        return answer;
    }
    int convertTime(String time1,String time2){
        int t1 = Integer.valueOf(time1) * 60;
        int t2 = Integer.valueOf(time2);
        return t1+ t2;
    }
    String replaceMelody(String melody){
        melody = melody.replaceAll("C#","H");
        melody = melody.replaceAll("D#","I");
        melody = melody.replaceAll("F#","J");
        melody = melody.replaceAll("G#","K");
        melody = melody.replaceAll("A#","L");
        
        return melody;
    }
}