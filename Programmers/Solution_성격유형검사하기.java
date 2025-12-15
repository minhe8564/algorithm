import java.util.*;

class Solution_성격유형검사하기 {
    public String solution(String[] survey, int[] choices) {
        StringBuilder sb = new StringBuilder();
        
        // 모든 지표를 미리 저장해놔야 함
        Map<Character, Integer> map = new HashMap<>();
        char[] charArr = new char[]{ 'R', 'T', 'C', 'F', 'J', 'M', 'A', 'N'};
        for(char c : charArr) {
            map.put(c, 0);
        }
        
        for(int i = 0; i < choices.length; i++) {
            char left = survey[i].charAt(0);
            char right = survey[i].charAt(1);

            switch (choices[i]) {
                case 1: map.put(left, map.get(left)+3); 
                        break;
                case 2: map.put(left, map.get(left)+2);
                        break;
                case 3: map.put(left, map.get(left)+1);
                        break;
                case 5: map.put(right, map.get(right)+1);
                        break;
                case 6: map.put(right, map.get(right)+2);
                        break;
                case 7: map.put(right, map.get(right)+3);
                        break;
            }
        }
        
        sb.append(map.get('R') >= map.get('T') ? 'R' : 'T');
        sb.append(map.get('C') >= map.get('F') ? 'C' : 'F');
        sb.append(map.get('J') >= map.get('M') ? 'J' : 'M');
        sb.append(map.get('A') >= map.get('N') ? 'A' : 'N');
        
        String answer = sb.toString();
        return answer;
    }
}
