/*
 * BOJ 1106번 : 호텔
 * 메모리 : 11,712kb
 * 시간 : 68ms
 */

import java.io.*;
import java.util.*;

public class BOJ1106_호텔 {
    static int C, N;
    static int[][] arr;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N][2];
        for(int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            arr[n][0] = Integer.parseInt(st.nextToken());
            arr[n][1] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[C+100];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for(int n = 0; n < N; n++) {
            int cost = arr[n][0];
            int customer = arr[n][1];

            // 현재 도시의 광고를 여러 번 써서 누적 고객 수 만들기
            for(int c = customer; c < C+100; c++) {
                if(dp[c-customer] != Integer.MAX_VALUE) {
                    dp[c] = Math.min(dp[c], dp[c-customer]+cost);
                }
            }
        }

        // 최소 고객 수 C 이상 확보한 경우 중, 최소 비용 구하기
        int answer = Integer.MAX_VALUE;
        for(int c = C; c < C+100; c++) {
            answer = Math.min(answer, dp[c]);
        }

        sb.append(answer);
        System.out.println(sb);
        br.close();
    }
}
