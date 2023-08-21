import java.util.*;
class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        m = replaceMelody(m);
        int maxiumTime = 0;
        for(int i=0; i<musicinfos.length; i++){
            String[] info = musicinfos[i].split(",");
            int playTime = convertTime(info[0],info[1]);
            String melodyInfo = replaceMelody(info[3]);
            
            if(playTime > melodyInfo.length()){
                while(playTime > melodyInfo.length()){
                    melodyInfo += melodyInfo;
                }
            }
            
            melodyInfo = melodyInfo.substring(0,playTime);
            if(melodyInfo.contains(m)){
                if(maxiumTime < playTime){
                    answer = info[2];
                    maxiumTime = playTime;
                }
            }
            
        }
        return answer;
        
    }
    
    int convertTime(String time1, String time2){
        String[] timeInfo1 = time1.split(":");
        String[] timeInfo2 = time2.split(":");
        return (Integer.valueOf(timeInfo2[0]) * 60 + Integer.valueOf(timeInfo2[1])) - (Integer.valueOf(timeInfo1[0]) * 60 + Integer.valueOf(timeInfo1[1]));
    }
    String replaceMelody(String melody){
        melody = melody.replaceAll("C#","c");
        melody = melody.replaceAll("D#","d");
        melody = melody.replaceAll("F#","f");
        melody = melody.replaceAll("G#","g");
        melody = melody.replaceAll("A#","a");
        return melody;
    }
}