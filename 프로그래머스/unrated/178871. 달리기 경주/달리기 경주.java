import java.util.*;
class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = new String[players.length];
        List<String> playersList = new ArrayList<>();
        HashMap<String,Integer> runner = new HashMap<>();
        for(int i=0; i<players.length; i++){
            playersList.add(players[i]);
            runner.put(players[i],i);
        }
        
        for(String calling : callings){
            int level = runner.get(calling);
            
            String slowRunner = players[level-1];
            players[level-1] = calling;
            players[level] = slowRunner;
            runner.put(slowRunner,runner.get(slowRunner)+1);
            runner.put(calling,runner.get(calling)-1);
            
        }
        
    
        return players;
    }
}