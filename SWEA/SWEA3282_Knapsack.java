/*
 * SWEA 3282번 : 0/1 Knapsack
 * 메모리 : 29,568kb
 * 시간 : 102ms
 */

import java.io.*;
import java.util.*;

public class SWEA3282_Knapsack {
	static int N, K;
	static int[] V;
	static int[] C;
	static int[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 물건의 개수
			K = Integer.parseInt(st.nextToken()); // 최대 부피
			V = new int[N+1]; // 물건의 부피
			C = new int[N+1]; // 물건의 가치
			for(int n = 1; n <= N; n++) {
				st = new StringTokenizer(br.readLine());
				V[n] = Integer.parseInt(st.nextToken());
				C[n] = Integer.parseInt(st.nextToken());
			}
			
			dp = new int[N+1][K+1];
			for(int n = 1; n <= N; n++) {
				for(int k = 1; k <= K; k++) {
					if(k < V[n]) {
						dp[n][k] = dp[n-1][k];
					} else {
						dp[n][k] = Math.max(dp[n-1][k], dp[n-1][k-V[n]]+C[n]);
					}
				}
			}
			
			sb.append(dp[N][K]).append("\n");
		}
		System.out.print(sb);
		br.close();
	}
}
