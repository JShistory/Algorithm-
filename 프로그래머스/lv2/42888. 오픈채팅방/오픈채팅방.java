import java.util.*;
class Solution {
    public String[] solution(String[] record) {
        HashMap<String, String> id = new HashMap<>();
        ArrayList<String> list = new ArrayList<>();
        int size = 0;
        for(int i=0; i<record.length; i++){
            String[] r = record[i].split(" ");
            if(r[0].equals("Enter")){
                id.put(r[1],r[2]);
                size++;
            }
            else if(r[0].equals("Change")){
                id.put(r[1],r[2]);
            }
            else{
                size++;
            }
        }
        
        String[] answer = new String[size];
        for(int i=0; i<record.length; i++){
            String[] r = record[i].split(" ");
            if(r[0].equals("Enter")){
                list.add(id.get(r[1])+"님이 들어왔습니다.");
            }
            else if(r[0].equals("Leave")){
                list.add(id.get(r[1]) + "님이 나갔습니다.");
            }

        }
        for(int i = 0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}
