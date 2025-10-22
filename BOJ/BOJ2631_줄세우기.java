/*
 * BOJ 2631번 : 줄 세우기
 * 메모리 : 11,480kb
 * 시간 : 64ms
 * 
 * LIS 구하고, 얘네 건드릴 필요 없이 나머지 애들 옮겨줌
 */

import java.io.*;
import java.util.*;

public class BOJ2631_줄세우기 {
    static int N;
    static int[] arr;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        dp = new int[N];
        for(int n = 0; n < N; n++) {
            arr[n] = Integer.parseInt(br.readLine());
            dp[n] = 1; // 자기 자신만으로 LIS 길이 1
        }

        int maxLen = 1;
        for(int i = 1; i < N; i++) {
            for(int j = 0; j < i; j++) {
                if(arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }

        sb.append(N-maxLen);
        System.out.println(sb);
        br.close();
    }
}
