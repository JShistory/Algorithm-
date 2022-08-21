import java.util.*;
class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        HashMap<String,Integer> map = new HashMap<>();
        map.put("R",0);
        map.put("T",0);
        map.put("C",0);
        map.put("F",0);
        map.put("J",0);
        map.put("M",0);
        map.put("A",0);
        map.put("N",0);
        for(int i=0; i<survey.length; i++){
            String[] m = survey[i].split("");
            if(choices[i] > 4){
                map.put(m[1],map.get(m[1])+(choices[i] - 4));
            }
            else if(choices[i] < 4){
                map.put(m[0],map.get(m[0])+(4-choices[i]));
            }
        }
        if(map.get("R") >= map.get("T")){
            answer +="R";
        }
        else{
            answer+="T";
        }
        if(map.get("C") >= map.get("F")){
            answer +="C";
        }
        else{
            answer+="F";
        }
        if(map.get("J") >= map.get("M")){
            answer +="J";
        }
        else{
            answer+="M";
        }
        if(map.get("A") >= map.get("N")){
            answer +="A";
        }
        else{
            answer+="N";
        }
        
        return answer;
    }
}