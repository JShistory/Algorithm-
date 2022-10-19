import java.util.*;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        int time = 0;
        Deque<String> cache = new ArrayDeque<String>();
        if(cacheSize == 0){
            time = 5 * cities.length;
            return time;
        }
        for(int i=0; i<cities.length; i++){
            String city = cities[i].toLowerCase();
            if(cache.contains(city)){
                time += 1;
                cache.remove(city);
                cache.add(city);
            }
            else{
                if(cache.size() == cacheSize){
                    cache.removeFirst();
                }
                cache.add(city);
                time += 5;
            }
        }
        return time;
    }
}