package algorithm;

import java.io.*;
import java.util.*;

public class SWEA5215_햄버거다이어트 {
	static int N, L;
	static int sumScore;
	static List<int[]> info;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T  = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 재료의 수
			L = Integer.parseInt(st.nextToken()); // 제한 칼로리
			info = new ArrayList<>(); // 맛점수, 칼로리
			for(int n = 0; n < N; n++) {
				st = new StringTokenizer(br.readLine());
				int score = Integer.parseInt(st.nextToken());
				int kcal = Integer.parseInt(st.nextToken());
				info.add(new int[] { score, kcal });
			}
			sumScore = 0;
			
			comb(0, 0, 0);
			
			sb.append("#").append(t).append(" ").append(sumScore).append("\n");
		}
		System.out.println(sb);
		br.close();
	}
	
	private static void comb(int idx, int score, int kcal) {
		if(kcal > L) {
			return;
		}
		
		sumScore = Math.max(sumScore, score);
		
		for(int i = idx; i < N; i++) {
			score += info.get(i)[0];
			kcal += info.get(i)[1];
			comb(i+1, score, kcal);
			score -= info.get(i)[0];
			kcal -= info.get(i)[1];
			
		}
		
	}

}
