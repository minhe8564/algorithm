/*
 * BOJ 17136번 : 색종이 자르기
 * 메모리 : 21,824kb
 * 시간 : 240ms
 *
 * 문제 풀이
 * 1. 1x1부터 5x5까지 색종이를 붙여서 모든 1을 덮어야 한다.
 * 2. 색종이 크기별로 최대 5장 사용 가능하다.
 * 3. 최소 색종이 개수로 모든 1을 덮어야 한다!
 *
 * 문제 해결
 * 1. 10x10을 한 줄로 보고 depth로 넘김
 * 2. 1이 있는 곳에 색종이 붙일 수 있으면 붙이고 재귀 호출
 * 3. 붙이려는 색종이가 범위안이고, 방문하지 않았고, 모두 1이어야 붙일 수 있음
 * 4. 색송이 붙였으면 visited 체크, 백트래킹(색종이 떼기)
 */

import java.io.*;
import java.util.*;

public class BOJ17136_색종이붙이기 {
	static int[][] paper;
	static boolean[][] visited;
	static int[] usePaper; // 사용한 색종이 개수 
	static int minCnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		paper = new int[10][10];
		visited = new boolean[10][10];
		usePaper = new int[5];
		for(int i = 0; i < 10; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 10; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		minCnt = Integer.MAX_VALUE;
		dfs(0, 0); // cnt, depth
		
		if(minCnt == Integer.MAX_VALUE) {
			sb.append(-1);
		} else {
			sb.append(minCnt);
		}
		System.out.print(sb);
		br.close();
	}
	
	private static void dfs(int cnt, int depth) {
		if(depth==100) {
			minCnt = Math.min(minCnt, cnt);
			return;
		}
		
		int x = depth/10;
		int y = depth%10;

		if(paper[x][y] == 1 && !visited[x][y]) { // 색종이를 붙일 수 있다면,
			for(int i = 1; i <= 5; i++) { // 색종이 크기 1~5까지 시도
				if(check(x, y, i, true)) {
					dfs(cnt+1, depth+1);
					check(x, y, i, false);
				}
			}
		} else {
			dfs(cnt, depth+1);
		}
	}
	
	private static boolean check(int x, int y, int num, boolean flag) {
		if(flag) { // 색종이를 붙이는 경우
			if (usePaper[num-1] == 5) { // 색종이를 전부 사용함
				return false;
			}

			// num 크기만큼 색종이 붙일 수 있는지 확인
			for (int i = x; i < x+num; i++) {
				for (int j = y; j < y+num; j++) {
					if (i >= 10 || j >= 10 || visited[i][j] || paper[i][j] == 0) {
						return false;
					}
				}
			}
			usePaper[num-1]++;
		} else {
			usePaper[num-1]--;
		}
		
		// 색종이 붙이거나 떼기
		for(int i = x; i < x+num; i++) {
			for(int j = y; j < y+num; j++) {
				visited[i][j] = flag;
			}
		}
		
		return true;
	}
}
