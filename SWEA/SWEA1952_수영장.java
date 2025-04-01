/*
 * SWEA 1952번 : 수영장
 * 메모리 : 27,008kb
 * 시간 : 89ms
 */

import java.io.*;
import java.util.*;

public class SWEA1952_수영장 {
	static int[] cost;
	static int[] plan;
	static boolean[] selected;
	static int minCost;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");
			cost = new int[4];
			selected = new boolean[4];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < 4; i++) {
				cost[i] = Integer.parseInt(st.nextToken());
			}
			plan = new int[12];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < 12; i++) {
				plan[i] = Integer.parseInt(st.nextToken());
			}
			
			minCost = cost[3]; // 1년
			dfs(0, 0);
			
			sb.append(minCost).append("\n");
		}
		System.out.print(sb);
		br.close();
	}
	
	private static void dfs(int month, int sumCost) {
		if(month >= 12) {
			minCost = Math.min(minCost, sumCost);
			return;
		}
		
		if(plan[month] == 0) {
			dfs(month+1, sumCost);
		} else {
			dfs(month+1, sumCost+plan[month]*cost[0]); // 1일
			dfs(month+1, sumCost+cost[1]); // 1달
			dfs(month+3, sumCost+cost[2]); // 3달
		}
	}
}
