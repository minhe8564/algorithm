/*
 * 1. 로봇마다, 시작좌표 + 이동경로
 * 2. 모든 로봇이 동시에 이동
 * 3. 매 초마다, 모든 로봇 위치 기록 -> 같은 좌표에 1대 이상이면 -> 충돌 위험+1
 */
import java.util.*;

class Solution_충돌위험찾기 {
    static class Pos {
        int r, c;
        Pos(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
    
    public int solution(int[][] points, int[][] routes) {
        int maxR = 0, maxC = 0;
        for(int i = 0; i < points.length; i++) {
            maxR = Math.max(maxR, points[i][0]);
            maxC = Math.max(maxC, points[i][1]);
        }
        
        // 로봇 이동 경로 저장
        List<List<Pos>> robotsPath = new ArrayList<>();
        for(int i = 0; i < routes.length; i++){
            List<Pos> path = new ArrayList<>();
            int[] route = routes[i];
            int currR = points[route[0]-1][0]; // 시작 R
            int currC = points[route[0]-1][1]; // 시작 C
            path.add(new Pos(currR, currC));
            
            for(int j = 1; j < route.length; j++) {
                int endR = points[route[j]-1][0];
                int endC = points[route[j]-1][1];
                
                // 행 먼저 이동
                while(currR != endR) {
                    if(endR > currR) {
                        currR += 1;
                    } else {
                        currR -= 1;
                    }
                    path.add(new Pos(currR, currC));
                }
                while(currC != endC) {
                    if(endC > currC){
                        currC += 1;
                    } else {
                        currC -= 1;
                    }
                    path.add(new Pos(currR, currC));
                }
            }
            
            robotsPath.add(path);
        }
        
        // 가장 긴 시간
        int maxTime = 0;
        for(List<Pos> path : robotsPath) {
            maxTime = Math.max(maxTime, path.size());
        }
        
        // 충돌 체크
        int answer = 0;
        for(int time = 0; time < maxTime; time++) {
            int[][] arr = new int[maxR+1][maxC+1];
            
            for(List<Pos> path : robotsPath) {
                if(path.size() > time) { // 이동 중
                    Pos pos = path.get(time);
                    arr[pos.r][pos.c]++;
                }
            }
            
            for(int r = 0; r <= maxR; r++) {
                for(int c = 0; c <= maxC; c++) {
                    if(arr[r][c] >= 2) {
                        answer++;
                    }
                }
            }
        }
        
        return answer;
    }
}
