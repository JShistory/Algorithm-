import java.util.*;
class Solution {
    public int solution(String[][] book_time) {
        int cleanTime = 10;
        int answer = 1;
        Arrays.sort(book_time, (o1,o2) -> {
           return convertTime(o1[0]) - convertTime(o2[0]); 
        });
        // for(String[] d : book_time){
        //     System.out.println(Arrays.toString(d));
        // }
        // System.out.println("-----");
        int time1 = convertTime(book_time[0][0]);
        int time2 = convertTime(book_time[0][1]);
        
        List<String> room = new ArrayList<>();
        room.add(book_time[0][1]);
        
        for(int i=1; i<book_time.length; i++){
            room.add(book_time[i][1]);
            for(int j=0; j<room.size(); j++){
                Collections.sort(room);
                if(convertTime(room.get(j)) + cleanTime > convertTime(book_time[i][0])){
                    answer++;
                    break;
                }
                else{
                    room.remove(j);
                    break;
                }
            }
            
                     
            
        }
        return answer;
    }
    
    int convertTime(String time){
        String[] data = time.split(":");
        return (Integer.valueOf(data[0]) * 60) + Integer.valueOf(data[1]);
    }
}