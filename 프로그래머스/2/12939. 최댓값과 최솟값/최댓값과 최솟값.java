import java.util.*;
import java.util.stream.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        List<Integer> list = Arrays.stream(s.split(" "))
                           .map(Integer::parseInt)
                           .collect(Collectors.toList());
        if(list.size() == 2) {
            return s;
        }
        Collections.sort(list);
        answer = list.get(0) + " " + list.get(list.size() - 1);
        return answer;
    }
}