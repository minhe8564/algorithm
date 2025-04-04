/*
 * BOJ 1149번 : RGB 거리
 * 메모리 : 12,044kb
 * 시간 : 72ms
 */

import java.io.*;
import java.util.*;

public class BOJ1149_RGB거리 {
	static int N;
	static int[][] dp;
	static int minCost;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		dp = new int[N+1][3];
	
		for(int n = 1; n <= N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int R = Integer.parseInt(st.nextToken());
			int G = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			dp[n][0] = Math.min(dp[n-1][1], dp[n-1][2]) + R;
			dp[n][1] = Math.min(dp[n-1][0], dp[n-1][2]) + G;
			dp[n][2] = Math.min(dp[n-1][0], dp[n-1][1]) + B;
		}
		
		minCost = Math.min(dp[N][0], Math.min(dp[N][1], dp[N][2]));
		sb.append(minCost);
		System.out.print(sb);
		br.close();
	}
}
