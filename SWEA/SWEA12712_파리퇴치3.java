package algorithm;

import java.io.*;
import java.util.*;

public class SWEA12712_파리퇴치3 {
	// 1. + 형태 x 형태 M의 세기로 분사하기
	// 2. 최대 파리 수 더하기 

	static int N, M;
	static int[][] map;
	static int[] dx = new int[] { -1, 1, 0, 0, -1, -1, 1, 1 };
	static int[] dy = new int[] { 0, 0, -1, 1, -1, 1, -1, 1 };
	static int maxCount;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			maxCount = Integer.MIN_VALUE;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					max(i, j);
				}
			}
			
			sb.append("#").append(t).append(" ").append(maxCount).append("\n");
		}
		System.out.println(sb);
		br.close();
		
	}
	
	private static void max(int x, int y) {
		int countPlus = map[x][y];
		int countX = map[x][y];
		
		for(int m = 1; m < M; m++) {
			for(int d = 0; d < 4; d++) {
				int nx = x + dx[d]*m;
				int ny = y + dy[d]*m;
				
				if(nx >= 0 && ny >= 0 && nx < N && ny < N) {
					countPlus += map[nx][ny];
				}
			}
		}
		
		for(int m = 1; m < M; m++) {
			for(int d = 4; d < 8; d++) {
				int nx = x + dx[d]*m;
				int ny = y + dy[d]*m;
				
				if(nx >= 0 && ny >= 0 && nx < N && ny < N) {
					countX += map[nx][ny];
				}
			}
		}
		
		maxCount = Math.max(maxCount, Math.max(countPlus, countX));
	}

}
