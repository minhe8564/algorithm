class Solution_카드뭉치 {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "Yes";
        int cards1Idx = 0;
        int cards2Idx = 0;
        
        for(int i = 0; i < goal.length; i++) {
            String word = goal[i];
            
            // 카드를 사용하지 않고, 다음 카드로 넘어갈 수 없음
            if(cards1Idx < cards1.length && cards1[cards1Idx].equals(word)){
                cards1Idx++;
            } else if(cards2Idx < cards2.length && cards2[cards2Idx].equals(word)) {
                cards2Idx++;
            } else {
                answer = "No";
                break;
            }
        }
        
        return answer;
    }
}
