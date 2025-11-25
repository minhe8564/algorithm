import java.util.*;

class Solution_달리기경주 {
    public String[] solution(String[] players, String[] callings) {        
        Map<String, Integer> map = new HashMap<>();
        for(int p = 0; p < players.length; p++) {
            map.put(players[p], p);
        }
        
        for(String calling : callings) {
            int idx = map.get(calling);
            if(idx==0) continue;
            
            String prevPlayers = players[idx-1];
            players[idx-1] = players[idx];
            players[idx] = prevPlayers;
            
            map.put(players[idx], idx);
            map.put(players[idx-1], idx-1);
        }
        
        return players;
    }
}
    
