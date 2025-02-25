package algorithm;

/*
 * comb()
 * 메모리 : 25,344kb
 * 실행시간 : 87ms
 * 
 * subset()
 * 메모리 : 25,216kb
 * 실행시간 : 81ms
 */

import java.io.*;
import java.util.*;

public class Solution_1486_장훈이의높은선반_이민희 {
	static int N, B;
	static int[] height; 
	static int minDiff;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			height = new int[N];
			for (int n = 0; n < N; n++) {
				height[n] = Integer.parseInt(st.nextToken());
			}
			
			minDiff = Integer.MAX_VALUE;
//			comb(0, 0);
			subset(0, 0);
			
			sb.append("#").append(t).append(" ").append(minDiff).append("\n");
		}
		System.out.println(sb);
		br.close();
	}
	
//	private static void comb(int start, int maxSum) {
//		// 탑을 만들었을 떄 B 이상이고, B와 차이가 가장 작을 때 갱신
//		if(maxSum >= B) {
//			minDiff = Math.min(minDiff, maxSum-B);
//			return;
//		}
//		
//		for(int i = start; i < N; i++) {
//			maxSum += height[i];
//			comb(i+1, maxSum);
//			maxSum -= height[i];
//		}
//	}
	
	private static void subset(int idx, int maxSum) {
		if(idx >= N) {
			if(maxSum >= B) {
				minDiff = Math.min(minDiff, maxSum-B);
			}
			return;
		}
		
		// 선택하는 경우
		subset(idx+1, maxSum+height[idx]);
		
		// 선택하지 않는 경우
		subset(idx+1, maxSum);
	}

}
