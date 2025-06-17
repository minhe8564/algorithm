/*
 * BOJ 17404번 : RGB 거리 2
 * 메모리 : 12,196kb
 * 시간 : 80ms
 */

import java.io.*;
import java.util.*;

public class BOJ17404_RGB거리2 {
    static final int INF = 1000 * 1000 + 1;
    static int N;
    static int[][] cost, dp;
    static int answer = INF;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());

        cost = new int[N][3];
        for(int n = 0; n < N; n++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            cost[n][0] = Integer.parseInt(st.nextToken());
            cost[n][1] = Integer.parseInt(st.nextToken());
            cost[n][2] = Integer.parseInt(st.nextToken());
        }

        for(int first = 0; first < 3; first++) {
            dp = new int[N][3];

            for(int i = 0; i < 3; i++) {
                if(first == i) dp[0][i] = cost[0][i];
                else dp[0][i] = INF; // 나머지 색은 선택 불가
            }

            for(int n = 1; n < N; n++) {
                dp[n][0] = Math.min(dp[n-1][1], dp[n-1][2]) + cost[n][0];
                dp[n][1] = Math.min(dp[n-1][0], dp[n-1][2]) + cost[n][1];
                dp[n][2] = Math.min(dp[n-1][0], dp[n-1][1]) + cost[n][2];
            }

            // 마지막 집은 첫 번째 집과 다른 색만 고려
            for(int last = 0; last < 3; last++) {
                if(first == last) continue;
                answer = Math.min(answer, dp[N-1][last]);
            }
        }

        sb.append(answer);
        System.out.println(sb);
        br.close();
    }
}
