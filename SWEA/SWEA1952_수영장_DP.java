/*
 * SWEA 1952번 : 수영장
 * 메모리 : 32,896kb
 * 시간 : 156ms
 */

import java.io.*;
import java.util.*;

public class SWEA1952_수영장_DP {
	static int[] cost;
	static int[] plan;
	static int minCost;
	static int[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");
			cost = new int[4];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < 4; i++) {
				cost[i] = Integer.parseInt(st.nextToken());
			}
			plan = new int[13];
			st = new StringTokenizer(br.readLine());
			for(int i = 1; i <= 12; i++) {
				plan[i] = Integer.parseInt(st.nextToken());
			}
			
			minCost = cost[3];
			dp = new int[13];
			
			dp[1] = Math.min(Math.min(cost[0]*plan[1], cost[1]), cost[2]);
			dp[2] = Math.min(Math.min(cost[0]*plan[2], cost[1])+dp[1], cost[2]);
			for(int i = 3; i <= 12; i++) {
				dp[i] = Math.min(Math.min(cost[0]*plan[i], cost[1])+dp[i-1], cost[2]+dp[i-3]);
			}
			sb.append(Math.min(minCost, dp[12])).append("\n");
		}
		System.out.print(sb);
		br.close();
	}
}
