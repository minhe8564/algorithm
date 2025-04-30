/*
 * BOJ 17281번 : 야구 ⚾
 * 메모리 : 60472kb
 * 시간 : 484ms
 */

import java.io.*;
import java.util.*;

public class BOJ17281_야구 {
	static int N;
	static int[][] innings;
	static boolean[] visited = new boolean[10];
	static int[] batter = new int[10]; // 타자
	static int maxScore;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		innings = new int[N][10];
		
		for(int n = 0; n < N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 1; i < 10; i++) {
				innings[n][i] = Integer.parseInt(st.nextToken());
			}
		}
		
		visited[1] = true; // 1번 선수는 고정
		batter[4] = 1; // 1번 선수는 4번 타자
		dfs(1);
		
		sb.append(maxScore);
		System.out.print(sb);
		br.close();
	}
	
	private static void dfs(int idx) {
		if(idx==10) {
			maxScore = Math.max(maxScore, game());
			return;
		}
		
		if(idx==4) {
			dfs(idx+1); // 4번 타자 고정 
			return;
		}
		
		for(int i = 1; i < 10; i++) {
			if(!visited[i]) {
				visited[i] = true;
				batter[idx] = i;
				dfs(idx+1);
				visited[i] = false;
			}
		}
	}
	
	private static int game() {
		int score = 0;
		int idx = 1;
		
		for(int n = 0; n < N; n++) {
			int outCnt = 0;
			boolean[] base = new boolean[3]; // 1루, 2루, 3루
			
			while(outCnt < 3) {
				int player = batter[idx];
				int result = innings[n][player];
				
				if(result == 0) { // 아웃 
					outCnt++;
				} else if(result == 1) { // 1루타
					if(base[2]) score++;
					base[2] = base[1];
					base[1] = base[0];
					base[0] = true;
				} else if(result == 2) { // 2루타
					if(base[2]) score++;
					if(base[1]) score++;
					base[2] = base[0];
					base[1] = true;
					base[0] = false;
				} else if(result == 3) { // 3루타 
					if(base[2]) score++;
					if(base[1]) score++;
					if(base[0]) score++;
					base[0] = base[1] = base[2] = false;
					base[2] = true;
				} else if(result == 4) { // 홈런 
					score += 1;
					if(base[0]) score++;
					if(base[1]) score++;
					if(base[2]) score++;
					base[0] = base[1] = base[2] = false;
				}
				
				idx = (idx%9)+1;
			}
		}
		return score;
	}
}
