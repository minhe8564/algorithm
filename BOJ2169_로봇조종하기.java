/*
 * BOJ 2169번 : 로봇 조종하기
 * 메모리 : 80,448kb
 * 시간 : 484ms
 */

import java.io.*;
import java.util.*;

public class BOJ2169_로봇조종하기 {
    static int N, M;
    static int[][] arr;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N+1][M+1];
        for(int n = 1; n <= N; n++) {
            st = new StringTokenizer(br.readLine());
            for(int m = 1; m <= M; m++) {
                arr[n][m] = Integer.parseInt(st.nextToken());
            }
        }

        dp = new int[N+1][M+1];

        // 1행
        // 왼 -> 오 고려만 하면 됨
        dp[1][1] = arr[1][1];
        for(int m = 2; m <= M; m++) {
            dp[1][m] = dp[1][m-1] + arr[1][m];
        }

        // 2행~
        for(int n = 2; n <= N; n++) {
            int[] left = new int[M+1];
            int[] right = new int[M+1];

            // 왼 -> 오
            left[1] = dp[n-1][1] + arr[n][1];
            for(int m = 2; m <= M; m++) {
                left[m] = Math.max(left[m-1], dp[n-1][m]) + arr[n][m];
            }

            // 오 -> 왼
            right[M] = dp[n-1][M] + arr[n][M];
            for(int m = M-1; m >= 1; m--) {
                right[m] = Math.max(right[m+1], dp[n-1][m]) + arr[n][m];
            }

            // 두 방향 중 최댓값 선택
            for(int m = 1; m <= M; m++) {
                dp[n][m] = Math.max(left[m], right[m]);
            }
        }

        sb.append(dp[N][M]);
        System.out.println(sb);
        br.close();
    }
}
