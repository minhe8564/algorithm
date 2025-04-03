/*
 * BOJ 1535번 : 안녕_2차원DP
 * 메모리 : 11,660kb
 * 시간 : 68ms
 */

import java.io.*;
import java.util.*;

public class BOJ1535_안녕_2차원DP {
    static int N;
    static int[] blood;
    static int[] happy;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        blood = new int[N+1];
        for(int n = 1; n <= N; n++) {
            blood[n] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        happy = new int[N+1];
        for(int n = 1; n <= N; n++) {
            happy[n] = Integer.parseInt(st.nextToken());
        }

        dp = new int[N+1][101];

        for(int i = 1; i <= N; i++) { // i번째 사람을 고려할 때
            for(int j = 1; j <= 100; j++) { // 현재 체력 j로 가능한 최대 기쁨 계산
                if(j > blood[i]){
                    // 현재 체력이 i번째 사람과 인사할 때 체력보다 많으면
                    // 1. i번째 사람과 인사를 하지 않는 경우 dp[i-1][j]
                    // 2. i번째 사람과 인사를 하는 경우 dp[i-1][j-health[i]]+happy[i]
                    // 두 경우 중 최대값을 선택
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-blood[i]]+happy[i]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        sb.append(dp[N][100]);
        System.out.print(sb);
        br.close();
    }
}
