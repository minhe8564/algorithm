/*
 * BOJ 9465번 : 스티커
 * 메모리 : 122,252kb
 * 시간 : 592ms
 */

import java.io.*;
import java.util.*;

public class BOJ9465_스티커 {
    static int T, N;
    static int[][] stickers;
    static int[][] dp;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            stickers = new int[2][N+1];
            dp = new int[2][N+1];

            for(int i = 0; i < 2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int n = 1; n <= N; n++) {
                    stickers[i][n] = Integer.parseInt(st.nextToken());
                }
            }

            dp[0][1] = stickers[0][1];
            dp[1][1] = stickers[1][1];

            for(int n = 2; n <= N; n++) {
                dp[0][n] = Math.max(dp[1][n-1], dp[1][n-2]) + stickers[0][n];
                dp[1][n] = Math.max(dp[0][n-1], dp[0][n-2]) + stickers[1][n];
            }

            answer = Math.max(dp[0][N], dp[1][N]);
            sb.append(answer).append("\n");
        }

        System.out.println(sb);
    }
}
