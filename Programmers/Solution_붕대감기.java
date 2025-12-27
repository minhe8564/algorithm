class Solution_붕대감기 {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int t = bandage[0];
        int x = bandage[1];
        int y = bandage[2];
        
        int lastTime = attacks[attacks.length-1][0]; // 마지막 공격 시간
        int idx = 0;
        
        int answer = health; // 현재 체력
        int maxHealth = health;
        int success = 0;

        for(int time = 1; time <= lastTime; time++) {
    
            if(time == attacks[idx][0]) { // 지금이 공격시간인지
                answer -= attacks[idx][1];
                idx++;
                success = 0;
                
                if(answer <= 0) {
                    return -1;
                }
            } else {
                success++;
                answer = Math.min(answer+x, maxHealth);
                
                if(success == t) {
                    answer = Math.min(answer+y, maxHealth);
                    success = 0;
                }
            }
        }
        
        return answer;
    }
}
