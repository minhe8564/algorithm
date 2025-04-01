/*
 * SWEA 2105번 : 디저트 카페
 * 메모리 : 28,800kb
 * 시간 : 134ms
 * 
 * 1. 대각선 4방향으로만 이동
 * 2. 한 번 먹은 디저트는 다시 못 먹음
 * 3. 시작점으로 돌아와야 하고, 최소 4개 이상 먹은 경우만 인정
 * 4. 방향은 시계 방향으로만 한 번 꺾을 수 있음 -> dir은 현재 방향 유지 또는 하나만 증가 가능
 */

import java.io.*;
import java.util.*;

public class SWEA2105_디저트카페 {
	static int N;
	static int[][] dessert;
	static boolean[] eat; // 디저트 중복 체크
	static int[] dx = new int[] { 1, 1, -1, -1 }; // 우하, 좌하, 좌상, 우상 
	static int[] dy = new int[] { 1, -1, -1, 1 };
	static int maxCnt;
	static int startX, startY;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");
			N = Integer.parseInt(br.readLine());
			dessert = new int[N][N];
			for(int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					dessert[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			maxCnt = -1;
			// 모든 좌표에서 출발 시도
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					eat = new boolean[101]; // 디저트 먹은 기록 초기화
					startX = i; startY = j;
					eat[dessert[i][j]] = true;
					dfs(i, j, 0, 1); // x, y, dir, cnt
				}
			}
			
			sb.append(maxCnt).append("\n");
		}
		System.out.print(sb);
		br.close();
	}
	
	private static void dfs(int x, int y, int dir, int cnt) {
		// 현재 방향 or 오른쪽으로 꺾기만 허용
		for(int d = dir; d <= dir+1; d++) {
			if(d >= 4) continue; // 4방향 이상은 없음
			int nx = x + dx[d];
			int ny = y + dy[d];
			
			if(nx==startX && ny==startY && cnt >= 4) {
				maxCnt = Math.max(maxCnt, cnt);
				return;
			}
			
			// 범위 내 && 디저트 중복으로 안먹었을 때
			if(nx >= 0 && ny >= 0 && nx < N && ny < N) {
				if(!eat[dessert[nx][ny]]) {
					eat[dessert[nx][ny]] = true; // 디저트 먹음
					dfs(nx, ny, d, cnt+1);
					eat[dessert[nx][ny]] = false; // 백트래킹
				}
			}
		}
	}
}
