/*
 dp[x][y] = z
 1. 물건 훔친 개수 x
 2. B 도둑의 흔적 개수 y < m
 3. A 도둑의 최소 흔적 개수 z < n
*/

import java.util.*;

class Solution_완전범죄 {
    static final int INF = 100000;
    public int solution(int[][] info, int n, int m) {
        int[][] dp = new int[info.length+1][m];
        
        for(int i = 0; i <= info.length; i++) {
            Arrays.fill(dp[i], INF);
        }
        
        dp[0][0] = 0;
        
        for(int i = 1; i <= info.length; i++) {
            int A = info[i-1][0];
            int B = info[i-1][1];
            for(int j = 0; j < m; j++) {
                // A 선택
                dp[i][j] = Math.min(dp[i][j], dp[i-1][j]+A);
                
                // B 선택
                if(j+B < m) {
                    dp[i][j+B] = Math.min(dp[i][j+B], dp[i-1][j]);
                }
            }
        }
        
        int answer = INF;
        for(int j = 0; j < m; j++) {
            answer = Math.min(answer, dp[info.length][j]);
        }
        
        return answer >= n ? -1 : answer;
    }
}
