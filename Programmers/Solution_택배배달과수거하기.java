/*
 * 재귀 접근?
 * 가장 먼 인덱스 해결하고 가까운 집 해결하는 순서로 오기
 */

class Solution_택배배달과수거하기 {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        
        // 쌓여있는 상자 저장
        long deliveriesCap = 0;
        long pickupsCap = 0;
        
        for(int i = n-1; i >= 0; i--) {
            deliveriesCap += deliveries[i];
            pickupsCap += pickups[i];
            
            if(deliveriesCap == 0 && pickupsCap == 0) {
                continue;
            }
            
            // 쌓여있는 상자 처리
            // 한 번 왕복애 cap 만큼 배달가능
            long deliveriesReturn = (deliveriesCap + cap - 1) / cap; // 올림 처리..
            long pickupsReturn = (pickupsCap + cap - 1) / cap;
            
            // 실제 왕복
            long returnMax = Math.max(deliveriesReturn, pickupsReturn);
            
            // 왕복 이동 거리 추가 / 0-base (i+1)
            answer += returnMax * 2 * (i+1);
            
            // 왕복으로 처리 가능한 만큼 제거
            deliveriesCap -= returnMax * cap;
            pickupsCap -= returnMax * cap;
        }
        
        return answer;
    }
}
