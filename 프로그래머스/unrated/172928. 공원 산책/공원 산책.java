import java.util.*;
class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];
        Character[][] maps = new Character[park.length][park[0].length()];
        int startH = 0;
        int startW = 0;
        for(int i=0; i<park.length; i++){
            for(int j=0; j<park[0].length(); j++){
                maps[i][j] = park[i].charAt(j);
                if(park[i].charAt(j) == 'S'){
                    startH = i;
                    startW = j;
                }
            }
        
        }
        
        for(int i=0; i<routes.length; i++){
            String[] command = routes[i].split(" ");
            String direction = command[0];
            int amount = Integer.valueOf(command[1]);
            boolean checkX = false;
            System.out.println(startH);
            System.out.println(startW);
            if(direction.equals("E")){
                if(startW+amount < 0 || startW+amount >= park[0].length()){
                    continue;
                }
                for(int j=startW; j<=startW+amount; j++){
                    if(maps[startH][j] == 'X'){
                        checkX = true;
                        }
                    }
                if(checkX){
                    continue;
                }
                startW += amount;
            }
            else if(direction.equals("W")){
                
                if(startW - amount < 0 || startW - amount >= park[0].length()){
                    continue;
                }
                for(int j=startW; j>=startW-amount; j--){
                    
                if(maps[startH][j] == 'X'){
                    checkX = true;
                }
                }
                if(checkX){
                    continue;
                }
                startW -= amount;
            }
            else if(direction.equals("N")){
                
                if(startH - amount < 0 || startH - amount >= maps.length){
                    continue;
                }
                for(int j=startH; j>=startH-amount; j--){
                if(maps[j][startW] == 'X'){
                    checkX = true;
                }
                }
                if(checkX){
                    continue;
                }
                startH -= amount;
            }
            else if(direction.equals("S")){
                
                if(startH + amount < 0 || startH + amount >= maps.length){
                    continue;
                }
                for(int j=startH; j<=startH+amount; j++){
                if(maps[j][startW] == 'X'){
                    checkX = true;
                }
                }
                if(checkX){
                    continue;
                }
                startH += amount;
            }
            
            
        }
        answer[0] = startH;
        answer[1] = startW;
        return answer;
    }
}