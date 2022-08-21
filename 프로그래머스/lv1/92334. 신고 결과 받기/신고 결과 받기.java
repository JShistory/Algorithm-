import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        HashMap<String,Integer> id = new HashMap<>();
        HashMap<String,Integer> id_report = new HashMap<>();
        for(int i=0; i<id_list.length; i++){
            id.put(id_list[i],0);
            id_report.put(id_list[i],0);
            
        }
        
        HashSet<String> hashset = new HashSet<>(Arrays.asList(report));
        String[] rpt = hashset.toArray(new String[0]);
        for(int i=0; i<rpt.length; i++){
            String[] report_id = rpt[i].split(" ");
            id.put(report_id[1],id.get(report_id[1])+1);
            
        }
        for(int i=0; i<rpt.length; i++){
            String[] report_id = rpt[i].split(" ");
            if(id.get(report_id[1]) >= k){
                id_report.put(report_id[0],id_report.get(report_id[0])+1);
            }
            
        }
        for(int i=0; i<id_list.length; i++){
            answer[i] = id_report.get(id_list[i]);
        }
        
        return answer;
    }
}