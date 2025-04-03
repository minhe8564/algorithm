/*
 * BOJ 4883번 : 삼각 그래프
 * 메모리 : 46,684kb
 * 시간 : 316ms
 * 
 * dp[0][1] 시작 ~ dp[N-1][1] 도착
 * 
 * dp[n][0] = Math.min(dp[n-1][0], dp[n-1][1])
 * dp[n][1] = Math.min(Math.min(dp[n][0], dp[n-1][0]), Math.min(dp[n-1][1], dp[n-1][2])
 * dp[n][2] = Math.min(dp[n][1], Math.min(dp[n-1][1], dp[n-1][2])
 */

import java.io.*;
import java.util.*;

public class BOJ4883_삼각그래프 {
	static int N;
	static int[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = 1; // 테스트케이스
		while(true) {
			N = Integer.parseInt(br.readLine());
			if(N==0) break;
			dp = new int[N][3];
			
			for(int n = 0; n < N; n++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int m = 0; m < 3; m++) {
					dp[n][m] = Integer.parseInt(st.nextToken());
				}
			}
			
			dp[1][0] += dp[0][1];
			dp[1][1] += Math.min(dp[1][0], Math.min(dp[0][1], dp[0][1]+dp[0][2]));
			dp[1][2] += Math.min(dp[1][1], Math.min(dp[0][1], dp[0][1]+dp[0][2]));
		
			for(int n = 2; n < N; n++) {
				dp[n][0] += Math.min(dp[n-1][0], dp[n-1][1]);
				dp[n][1] += Math.min(Math.min(dp[n][0], dp[n-1][0]), Math.min(dp[n-1][1], dp[n-1][2]));
				dp[n][2] += Math.min(dp[n][1], Math.min(dp[n-1][1], dp[n-1][2]));
			}
			
			sb.append(t).append(". ").append(dp[N-1][1]).append("\n");
			t++;
		}
		System.out.print(sb);
		br.close();
	}
}
