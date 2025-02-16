package algorithm;

import java.io.*;
import java.util.*;

public class SWEA1486_장훈이의높은선반 {
	static int N, B;
	static int[] per;
	static int minDiff;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken()); // N명의 점원
			B = Integer.parseInt(st.nextToken()); // 높이가 B인 선반
			per = new int[N]; // 각 점원의 키
			st = new StringTokenizer(br.readLine(), " ");
			for(int n = 0; n < N; n++) {
				per[n] = Integer.parseInt(st.nextToken());
			}
			
			// 점원이 쌓은 탑 >= B
			// 점원이 쌓은 탑 - B = 가장 높이 차이가 낮은 탑
			minDiff = Integer.MAX_VALUE;
			comb(0, 0);
			
			sb.append("#").append(t).append(" ").append(minDiff).append("\n");
		}
		System.out.println(sb);
		br.close();
	}
	
	private static void comb(int idx, int topSum) {
		if(topSum >= B) {
			minDiff = Math.min(minDiff, topSum-B);
			return;
		}
		
		for(int i = idx; i < N; i++) {
			topSum += per[i];
			comb(i+1, topSum);
			topSum -= per[i];
		}
	}

}
