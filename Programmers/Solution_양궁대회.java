/*
 * 어피치가 이미 쏜 상태, 라이언이 어떤 과녁 점수에 맞혀야 하는지 10~0점
 * a=b 같이 맞춘 경우 어피치가 k점
 * 라이언이 여러가지 방법으로 우승하는 경우, 낮은 점수 많이 맞혔을 때 return
 *
 * 완탐 + 백트래킹
 */ 

class Solution_양궁대회 {
    static int[] answer = null;
    static int max;
    
    public int[] solution(int n, int[] info) {
        int[] lion = new int[11];
        dfs(0, n, lion, info);
        
        answer = (answer==null) ? new int[]{-1} : answer;
        return answer;
    }
    
    public void dfs(int idx, int arrows, int[] lion, int[] info){
        if(idx==11) { // 기저 조건
            lion[10] += arrows; // 남은 화살
            
            int lionScore = 0, infoScore = 0;
            for(int i = 0; i < 11; i++) {
                if(lion[i]==0 && info[i]==0) {
                    continue;
                }
                
                if(lion[i] > info[i]) {
                    lionScore += 10-i;
                } else {
                    infoScore += 10-i;
                }
            }
            
            // 라이언이 더 큰 점수 차로 우승
            // 낮은 점수를 더 많이 맞힌 경우
            if(lionScore-infoScore <= 0) {
                lion[10] -= arrows;
                return;
            }
            
            // answer 가 아직 null 인 경우
            if(answer == null) {
                max = lionScore-infoScore;
                answer = lion.clone();
                lion[10] -= arrows;
                return;
            }
            
            if(lionScore-infoScore > max || (lionScore-infoScore == max && best(lion))) {
                max = lionScore-infoScore;
                answer = lion.clone();
            }
            
            // 남은 화살 돌려주기
            lion[10] -= arrows;
            return;
        }
        
        // 어피치 점수 이기기
        int need = info[idx]+1;
        if(need <= arrows) {
            lion[idx] = need;
            dfs(idx+1, arrows-need, lion, info);
            lion[idx] = 0;
        }
        
        // 포기하기
        dfs(idx+1, arrows, lion, info);
    }
    
    public boolean best(int[] lion) {
        for(int i = 10; i >= 0; i--){
            if(lion[i] != answer[i]) {
                // 낮은 점수 많이 맞춘 경우
                if(lion[i] > answer[i]){
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }
}
