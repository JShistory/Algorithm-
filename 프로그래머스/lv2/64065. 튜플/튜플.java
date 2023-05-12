import java.util.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
class Solution {
    public int[] solution(String s) {
        
        List<String> list = new ArrayList<>();
        s = s.substring(2,s.length()-2);
        //System.out.println(s);
        s = s.replace("},{","-");
        
        String[] str = s.split("-");
        Arrays.sort(str, new Comparator<String>(){
            @Override
            public int compare(String s1, String s2){
                return s1.length() - s2.length();
            }
        });
        
        for(String strData : str){
            String[] data = strData.split(",");
            for(int i=0; i<data.length; i++){
                if(!list.contains(data[i])){
                    list.add(data[i]);
                }
            }
        }
        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            answer[i] = Integer.parseInt(list.get(i));   
        }

        return answer;
    }
}