import java.util.*;

class Solution_대충만든자판 {
    public int[] solution(String[] keymap, String[] targets) {
        Map<Character, Integer> hashmap = new HashMap<>();
        
        for(int i = 0; i < keymap.length; i++) {
            String key = keymap[i];
            for(int j = 0; j < key.length(); j++){
                int num = hashmap.getOrDefault(key.charAt(j), j+1); // 이미 매핑된 문자 key, defaultValue
                int minNum = Math.min(num, j+1);
                hashmap.put(key.charAt(j), minNum);
            }
        }
        
        int[] answer = new int[targets.length];
        for(int i = 0; i < targets.length; i++) {
            String target = targets[i];
            for(int j = 0; j < target.length(); j++) {
                if(hashmap.containsKey(target.charAt(j))){
                    answer[i] += hashmap.get(target.charAt(j));
                } else {
                    answer[i] = -1;
                    break; // 문자가 하나라도 키맵에 없으면 탈출
                }
            }
        }
        
        return answer;
    }
}
