import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int tan : tangerine){
            map.put(tan, map.getOrDefault(tan, 0)+1);
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());

        list.sort((o1, o2) -> o2.getValue().compareTo(o1.getValue()));

        for (Map.Entry<Integer, Integer> entry : list) {
            if(k<=0) break;
            answer++;
            k -= entry.getValue();
        }
        return answer;
    }
}

